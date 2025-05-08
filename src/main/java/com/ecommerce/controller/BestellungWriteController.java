package com.ecommerce.controller;
import com.ecommerce.controller.BestellungDTO.OnCreate;
import com.ecommerce.gRPC.OrderClient;
import com.ecommerce.service.BestellungWriteService;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import static org.springframework.http.ResponseEntity.created;

import static com.ecommerce.controller.BestellungGetController.API_PATH;

import java.net.URI;



@Controller
@Validated
@RequestMapping(API_PATH)
@SuppressWarnings({"ClassFanOutComplexity", "java:S1075"})
class BestellungWriteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BestellungWriteController.class);
    private final BestellungWriteService service;
    private final BestellungMapper mapper;
    private final UriHelper uriHelper;

    BestellungWriteController(final BestellungWriteService service, final BestellungMapper mapper, final UriHelper uriHelper) {
        this.service = service;
        this.mapper = mapper;
        this.uriHelper = uriHelper;
    }

    @PostMapping
    @Operation(summary = "Eine neue Bestellung anlegen", tags = "Neuanlegen")
    @ApiResponse(responseCode = "201", description = "Bestellung neu angelegt")
    @ApiResponse(responseCode = "400", description = "Syntaktische Fehler im Request-Body")
    @ApiResponse(responseCode = "422", description = "Ungültige Werte oder Email vorhanden")
    ResponseEntity<Void> post(
        @RequestBody @Validated({jakarta.validation.groups.Default.class, OnCreate.class}) final BestellungDTO bestellungDTO,
        final HttpServletRequest request
    ) {
        LOGGER.debug("post: {}", bestellungDTO);

        final var bestellungInput = mapper.ToBestellung(bestellungDTO);
        final var bestellung = service.create(bestellungInput);
        final var baseUri = uriHelper.getBaseUri(request).toString();
        final var location = URI.create(baseUri + '/' + bestellung.getOrderID());
        
        //Bestell-Objekt über gRPC-Schnittstelle an ERP-System weiterleiten
        OrderClient.sendOrderRequest(bestellung);

        return created(location).build();
    }


    
}

