package server.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import server.dto.Person;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;


/**
 * server
 *
 * @author wedul
 * @since 2019-01-12
 **/
@Configuration
@EnableWebFlux
public class PersonRouterFunction implements WebFluxConfigurer {

  @Bean
  public RouterFunction<ServerResponse> routes(FunctionHandler handler) {
    return RouterFunctions.route(GET("/person"), handler::functionHandler);
  }

}

@Component
class FunctionHandler {
  public Mono<ServerResponse> functionHandler(ServerRequest req) {
    Mono<Person> person = Mono.just(new Person("wedul"));
    return ServerResponse.ok().body(person, Person.class);
  }
}