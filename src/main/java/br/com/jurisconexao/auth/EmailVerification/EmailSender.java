/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.auth.EmailVerification;

/**
 *
 * @author Marcos
 */

public interface EmailSender {
    void send(String to, String email);
}