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
@Table(name = "Evento")
public class Evento {
    
    /*SEVERE (highest)
        WARNING
        INFO
        CONFIG
        FINE
        FINER
        FINEST*/
    
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    @Column(nullable = false, unique = false, length = 30)
    private String message;
    @Column(nullable = false, unique = false, length = 30)
    private String info;
    @Column(nullable = false, unique = false, length = 30)
    private String date;
    @Column(nullable = false, unique = false, length = 30)
    //1 - Mostra
    //2 - Não Mostra
    private String cod;
    @Column(nullable = false, unique = false, length = 30)
    //1-Apafa ao ver
    //2-Não apaga  ao ver
    private String level;
    //Email
     @Column(nullable = false, unique = false, length = 30)
    private String usuario;

   
    
    
}
