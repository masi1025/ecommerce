package com.ecommerce.controller; 
import com.ecommerce.entity.Bestellung;
import com.ecommerce.service.BestellungReadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import static com.ecommerce.controller.BestellungGetController.API_PATH;
@RestController
@RequestMapping(API_PATH)
@OpenAPIDefinition(info = @Info(title = "Bestellung API", version = "v1"))
@SuppressWarnings("java:S1075")
 public class BestellungGetController {
    
    static final String API_PATH = "api";

    
    //private static final String ID_PATTERN = "ORD\\d+";

    //private static final String customerID_PATH = "/customerID";

    private static final Logger LOGGER = LoggerFactory.getLogger(BestellungGetController.class);

    
    private final BestellungReadService service;

    
    BestellungGetController(final BestellungReadService service) {
        this.service = service;
    }
    @GetMapping("/{orderID}")
    @Operation(summary = "Suche mit der Bestellung-ID", tags = "Suchen")
    @ApiResponse(responseCode = "200", description = "Bestellung gefunden")
    @ApiResponse(responseCode = "404", description = "Bestellung nicht gefunden")
    Bestellung getById(@PathVariable final String orderID) {
        LOGGER.debug("getById: id={}, Thread={}", orderID, Thread.currentThread().getName());

        // Geschaeftslogik bzw. Anwendungskern
        final var bestellung  = service.findById(orderID);

        LOGGER.debug("getById: bestellung={}", bestellung);
        return bestellung;
    }

    /*@GetMapping(path = customerID_PATH + "/{prefix}")
    @Operation(summary = "Suche CustomerID mit Praefix", tags = "Suchen")
    String getNachnamenByPrefix(@PathVariable final String prefix) {
        LOGGER.debug("getNachnamenByPrefix: {}", prefix);
        final var nachnamen = service.findNachnamenByPrefix(prefix);
        LOGGER.debug("getNachnamenByPrefix: {}", nachnamen);
        return nachnamen.parallelStream()
            .map(nachname -> "\"" + nachname + '"')
            .toList()
            .toString();
    }*/


}