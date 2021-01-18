package griezma.mssc.brewerygateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@ActiveProfiles("sample")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWireMock(port = 0)
class ApiGatewayTests {

    @Autowired
    WebTestClient client;

    @Test
    void contextLoads() {
//        stubFor(get(urlEqualTo("/mirror/get"))
//                .willReturn(aResponse()
//                    .withHeader("Content-Type", "application/json")
//                    .withBody("{\"headers\":{\"X-Hello\":\"World\"}")));

        client.get().uri("/mirror/get").exchange()
                .expectStatus().isOk()
                .expectBody()
                    .jsonPath("$.headers.Forwarded").exists()
                    .jsonPath("$.headers.Host").isEqualTo("httpbin.org");
    }

}
