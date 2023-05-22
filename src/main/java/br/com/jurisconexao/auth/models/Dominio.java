/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.auth.models;



/**
 *
 * @author Marcos
 */

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
@Table(name = "Dominio")
public class Dominio {
    
     @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
     
     private String vendedor;
     private String urlfree;
     private String urlpersonal;
     private String appurl;


    public Dominio(Long id, String vendedor, String urlfree, String urlpersonal, String appurl) {
        this.id = id;
        this.vendedor = vendedor;
        this.urlfree = urlfree;
        this.urlpersonal = urlpersonal;
        this.appurl = appurl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getUrlfree() {
        return urlfree;
    }

    public void setUrlfree(String urlfree) {
        this.urlfree = urlfree;
    }

    public String getUrlpersonal() {
        return urlpersonal;
    }

    public void setUrlpersonal(String urlpersonal) {
        this.urlpersonal = urlpersonal;
    }

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl;
    }
    
    
     
     
}
