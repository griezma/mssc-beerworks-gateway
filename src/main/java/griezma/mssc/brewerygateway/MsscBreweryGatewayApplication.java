package griezma.mssc.brewerygateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class MsscBreweryGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsscBreweryGatewayApplication.class, args);
    }
}

@RestController
class Fallback {
    @GetMapping("/fallback")
    String fallback() {
        return "fallback called";
    }
}

