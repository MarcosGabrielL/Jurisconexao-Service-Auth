/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.auth.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.jurisconexao.auth.models.Evento;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.apache.bcel.classfile.annotation.NameValuePair;


/**
 *
 * @author Marcos
 */
public class EventoService {
    
   
    
     public static void SaveEvento(Evento evento,String token) throws IOException, InterruptedException{
                
            String apiHost = "https://emiele-service-gerenciador.herokuapp.com/eventos/evento/add?token=1";
       
     }
    
}
