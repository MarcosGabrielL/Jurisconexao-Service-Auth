/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.auth.repositories;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jurisconexao.auth.models.PerfilPagamento;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcos
 */
@Repository
public interface PerfilPagamentoRepository extends JpaRepository<PerfilPagamento, Long> {
    
     Optional<PerfilPagamento> findPerfilPagamentoById(Long id);
     
     @Query("select n from PerfilPagamento n where n.email = ?1")
	 Optional<PerfilPagamento> userPerfilPagamento(String userId);
     
     void deletePerfilPagamentoById(Long id);
}
