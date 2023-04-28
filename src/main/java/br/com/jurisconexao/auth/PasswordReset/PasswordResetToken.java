/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.auth.PasswordReset;

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
@Table(name = "PasswordResetToken")
public class PasswordResetToken {
 
   

    @Id
    @Column(length = 45)
    private String id;
    
    @Column(name = "token", nullable = true, unique = true, length = 200)
    private String resetPasswordToken;

    public PasswordResetToken() {
        super();
    }

    public PasswordResetToken(String id, String resetPasswordToken) {
        this.id = id;
        this.resetPasswordToken = resetPasswordToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

   
}
