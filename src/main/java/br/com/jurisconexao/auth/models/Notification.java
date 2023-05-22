
package br.com.jurisconexao.auth.models;

import java.util.Date;

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
@Table(name = "Notification")
public class Notification {

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
    private String cod;
    @Column(nullable = false, unique = false, length = 30)
    private String level;
    //Email
     @Column(nullable = false, unique = false, length = 30)
    private String usuario;
	 @Column(nullable = false, unique = false, length = 30)
	private boolean isRead;
       


    
    }
        

