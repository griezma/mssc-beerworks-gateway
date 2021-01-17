package griezma.mssc.brewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("sample")
@Configuration
public class SampleConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("google", r -> r.path("/google")
                        .filters(f -> f.redirect(301, "https://www.google.com"))
                        .uri("no://op"))
                .route("google-search", r -> r.path("/google/*")
                        .filters(f -> f.rewritePath("/google/(.*)", "/?q=$1"))
                        .uri("http://google.com"))
//                .route("mirror-api", r -> r.path("/mirror/**")
//                        .filters(f -> f.rewritePath("/mirror/(.*)", "/$1"))
//                        .uri("http://httpbin.org"))
                .build();
    }
}
