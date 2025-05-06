# syntax=docker/dockerfile:1.14.0

# Copyright (C) 2020 - present Juergen Zimmermann, Hochschule Karlsruhe
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.

# Aufruf:   docker build --tag juergenzimmermann/kunde:2025.4.1-eclipse-noble .
#               ggf. --progress=plain
#               ggf. --no-cache
#           Get-Content Dockerfile | docker run --rm --interactive hadolint/hadolint:2.12.1-beta-debian
#           docker save juergenzimmermann/kunde:2025.4.1-eclipse-noble > kunde.tar

# https://docs.docker.com/engine/reference/builder/#syntax
# https://github.com/moby/buildkit/blob/master/frontend/dockerfile/docs/reference.md
# https://hub.docker.com/r/docker/dockerfile
# https://docs.docker.com/build/building/multi-stage
# https://github.com/moby/buildkit/releases
# https://containers.gitbook.io/build-containers-the-hard-way

# ARG: "build-time" Variable
# ENV: "build-time" und "runtime" Variable
#ARG JAVA_VERSION=23.0.2_7
ARG JAVA_VERSION=24_36

# ---------------------------------------------------------------------------------------
# S t a g e :   b u i l d e r
#
#   "Eclipse Temurin" aus "Eclipse Adoptium Project" als JDK https://github.com/adoptium/containers
#   Ubuntu "Noble Numbat" 24.04 LTS (Long Term Support, Juni 2029 / 2036)
#   https://ubuntu.com/about/release-cycle https://wiki.ubuntu.com/Releases
#   Docker-Image fuer OpenJDK ist *deprecated*
#   Amazon Coretto: nur JDK, nicht JRE (s.u.)
#   SapMachine: nur JDK, nicht JRE (s.u.)
#   JAR bauen mit eigenem Code und Dependencies z.B. Spring, Jackson
# ---------------------------------------------------------------------------------------
FROM eclipse-temurin:${JAVA_VERSION}-jdk-noble AS builder
#FROM bellsoft/liberica-openjdk-debian:${JAVA_VERSION} AS builder

# "working directory" fuer die Docker-Kommandos RUN, ENTRYPOINT, CMD, COPY und ADD
WORKDIR /builder

# JAR-Datei mit den Schichten ("layers") erstellen und aufbereiten bzw. entpacken
# https://docs.docker.com/reference/dockerfile/#run---mounttypecache

# Gradle:
RUN --mount=type=bind,source=build.gradle.kts,target=build.gradle.kts \
    --mount=type=bind,source=gradle.properties,target=gradle.properties \
    --mount=type=bind,source=gradlew,target=gradlew \
    --mount=type=bind,source=settings.gradle.kts,target=settings.gradle.kts \
    --mount=type=bind,source=gradle,target=gradle \
    --mount=type=bind,source=src,target=src \
    --mount=type=cache,target=/root/.gradle \
    ./gradlew --no-configuration-cache --no-daemon --no-watch-fs -DuseTracing=false bootJar
ARG JAR_FILE=build/libs/*.jar

# Maven:
#RUN --mount=type=bind,source=pom.xml,target=pom.xml \
#    --mount=type=bind,source=mvnw,target=mvnw \
#    --mount=type=bind,source=.mvn,target=.mvn \
#    --mount=type=bind,source=src,target=src \
#    --mount=type=cache,target=/root/.m2 \
#    ./mvnw package spring-boot:repackage -Dmaven.test.skip=true -Dspring-boot.build-image.skip=true \
#        -P !persistence -P !mail -P !security -P !observability -P !graphql -P !kotlin
#ARG JAR_FILE=target/*.jar

# java --help
# java --help-extra
RUN java -Djarmode=tools -jar ${JAR_FILE} extract
#ENTRYPOINT ["/bin/bash", "-c", "echo 'Container als bash gestartet.' && sleep infinity"]

# ---------------------------------------------------------------------------------------
# S t a g e   f i n a l
#
#   JRE statt JDK
#   Dependencies, z.B. Spring, Jackson
#   Loader fuer Spring Boot
#   Eigener uebersetzter Code
# ---------------------------------------------------------------------------------------

FROM eclipse-temurin:${JAVA_VERSION}-jre-noble AS final
#FROM bellsoft/liberica-openjre-debian:${JAVA_VERSION} AS final

# Anzeige bei "docker inspect ..."
# https://specs.opencontainers.org/image-spec/annotations
# https://spdx.org/licenses
# https://snyk.io/de/blog/how-and-when-to-use-docker-labels-oci-container-annotations
# MAINTAINER ist deprecated https://docs.docker.com/engine/reference/builder/#maintainer-deprecated
LABEL org.opencontainers.image.title="kunde" \
      org.opencontainers.image.description="Microservice kunde v1 mit Basis-Image Eclipse Temurin und Ubuntu Noble" \
      org.opencontainers.image.version="2025.4.1-eclipse-noble" \
      org.opencontainers.image.licenses="GPL-3.0-or-later" \
      org.opencontainers.image.vendor="Juergen Zimmermann" \
      org.opencontainers.image.authors="Juergen.Zimmermann@h-ka.de" \
      org.opencontainers.image.base.name="eclipse-temurin:LATEST_VERSION-jre-noble"

# gleiches Basis-Verzeichnis wie bei "Cloud Native Buildpacks": Mounting von private-key.pem, certificate.crt
WORKDIR /workspace

# "here document" wie in einem Shellscipt
RUN <<EOF
set -eux
apt-get update
apt-get upgrade --yes
# https://unix.stackexchange.com/questions/217369/clear-apt-get-list
apt-get autoremove -y
apt-get clean -y
rm -rf /var/lib/apt/lists/*
# https://manpages.debian.org/bookworm/passwd/groupadd.html
# https://manpages.debian.org/bookworm/adduser/addgroup.html
#groupadd --gid 1000 ubuntu
# https://manpages.debian.org/bookworm/passwd/useradd.html
# https://manpages.debian.org/bookworm/adduser/adduser.html
#useradd --uid 1000 --gid ubuntu --no-create-home ubuntu
chown -R ubuntu:ubuntu /workspace
EOF

# ADD hat mehr Funktionalitaet als COPY, z.B. auch Download von externen Dateien
# ggf. auch /builder/snapshot-dependencies/
COPY --from=builder --chown=ubuntu:ubuntu /builder/*/lib/ ./lib/
COPY --from=builder --chown=ubuntu:ubuntu /builder/*/*.jar ./application.jar

USER ubuntu:ubuntu
EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s --retries=1 \
  CMD wget -qO- --no-check-certificate https://localhost:8080/actuator/health/ | grep UP || exit 1

# Bei CMD statt ENTRYPOINT kann das Kommando bei "docker run ..." ueberschrieben werden
ENTRYPOINT ["java", "--enable-preview", "-classpath", "application.jar:lib/*:.", "com.acme.kunde.Application"]
