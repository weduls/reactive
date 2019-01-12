package server.controller;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;
import server.dto.Person;
import server.repository.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * server
 *
 * @author wedul
 * @since 2019-01-12
 **/
@RestController
public class PersonController {

  private final PersonRepository repository;

  public PersonController(PersonRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/person")
  Mono<Void> create(@RequestBody Publisher<Person> personStream) {
    return this.repository.save(personStream).then();
  }

  @GetMapping("/person")
  Flux<Person> list() {
    return this.repository.findAll();
  }

  @GetMapping("/person/{id}")
  Mono<Person> findById(@PathVariable String id) {
    return this.repository.findOne(id);
  }
}