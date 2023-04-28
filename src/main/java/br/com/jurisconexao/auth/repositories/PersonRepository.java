
package br.com.jurisconexao.auth.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jurisconexao.auth.models.Person;

/**
 *
 * @author Marcos
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
     Optional<Person> findPersonById(Integer id);
     
     void deletePersonById(Integer id);
}