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
@Table(name = "Vendedor")
public class Vendedor {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    
     private String CNPJ;
     @Column(nullable = false, unique = false, length = 45)
        private String nomefantasia; 
     @Column(nullable = false, unique = false, length = 250)
           private String descricao;   
        private String Cidade;
        private String CEP;
        private String CFOP;
     private String razaosocial;
     @Column(nullable = false, unique = false, length = 45)
    private String rua;
    private String Bairro;
    private String Numero;
    private String Estado;
    private String Uf;
    @Column(nullable = false, unique = false, length = 45)
    private String telefone;
      @Column(nullable = false, unique = true, length = 45)
    private String email;
    private String Certificado;
    private String  NumeroSérie;
    /*
    0 - nenhum
    1 - Free
    2 - Medio
    3 - Top*/
     @Column(nullable = false, unique = false, length = 4)
    private int  ambiente;
     /*
     0- nada
    1 - Teste
    2 - Vencido
    3 - Pago*/
     
    @Column(nullable = false, unique = false, length = 4)
    private int serie;
    
    @Column(nullable = false, unique = false, length = 35)
     private String datainicio;
    
    @Column(nullable = false, unique = false, length = 35)
     private String datafim;
    private String CódigoRegimeTributario;
    private String ICMS;
    private String PIS;
    private String COFINS;
    private String IPI;
       private int CTipo;
        private String CSenha;
        private String CValidade;
        private String NCM;
        private String CST;
            private String CodigoCity;
            private String InscricaoEstadual;
            private String IBPT;

            private String IdToken;
            private String CSC;

   

   

}
