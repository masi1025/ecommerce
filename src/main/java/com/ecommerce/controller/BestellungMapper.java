package com.ecommerce.controller;

import com.ecommerce.entity.Bestellung;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;

@Mapper(nullValueIterableMappingStrategy = RETURN_DEFAULT, componentModel = "spring")
interface BestellungMapper {

    @Mapping(target = "orderID", ignore = false)
    @Mapping(source = "eMail", target = "EMail") 
    Bestellung ToBestellung(BestellungDTO dto);

}
