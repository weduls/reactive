package client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import server.dto.Person;

/**
 * reactive
 *
 * @author wedul
 * @since 2019-01-12
 **/
public class PersonClient {

  WebClient client = WebClient.create("https://wedul.pos:8080");

  public void Test() {
    Flux<Person> personMono = client.get().uri("/person").retrieve().bodyToFlux(Person.class);

    personMono.subscribe(System.out::println);
  }

}
