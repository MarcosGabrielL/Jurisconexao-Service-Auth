/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.auth.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PerfilPagamento")
public class PerfilPagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = true, length = 64)
    private String password;
     
    @Column(name = "first_name", nullable = true, length = 20)
    private String firstName;
     
    @Column(name = "last_name", nullable = true, length = 64)
    private String lastName;
    
     private String banco;
      private String   tipoconta;
      private String   numeroconta;
      private String   agencia;
      private String   nomecompleto;
       private String  cpf;
       private String  numeroCartao1;
       private String  numeroCartao2;
       private String  numeroCartao3;
       private String  numeroCartao4;
       private String  titular;
        private String mesvencimento;
        private String anovencimento;
        private String cvv;

  

        
    
}
