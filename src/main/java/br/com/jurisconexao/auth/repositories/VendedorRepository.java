package br.com.jurisconexao.auth.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jurisconexao.auth.models.Vendedor;

/**
 *
 * @author Marcos
 */
@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    
     Optional<Vendedor> findVendedorById(Long id);
     
     void deleteVendedorById(Long id);
     
     @Query("SELECT u FROM Vendedor u WHERE u.email = ?1")
      List<Vendedor> findByEmail(String usuario);
}