package server.repository;

import org.springframework.data.repository.CrudRepository;
import server.dto.Person;
import reactor.core.publisher.Mono;

/**
 * server
 *
 * @author wedul
 * @since 2019-01-12
 **/
public interface PersonRepository extends CrudRepository<Long, Person> {
  Mono<Person> findOne(String id);
}
