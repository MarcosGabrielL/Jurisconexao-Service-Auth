/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jurisconexao.auth.security;

/**
 *
 * @author Marcos
 */
import br.com.jurisconexao.auth.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
public interface UserRepository extends JpaRepository<User, Long> {
 @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
    
@Query("SELECT u FROM User u WHERE u.id = ?1")
    public User findByid(Long id);
}