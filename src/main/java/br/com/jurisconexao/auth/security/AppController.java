/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jurisconexao.auth.security;

import br.com.jurisconexao.auth.models.Person;
import br.com.jurisconexao.auth.models.Revendedor;
import br.com.jurisconexao.auth.models.Vendedor;
import br.com.jurisconexao.auth.repositories.PersonRepository;
import br.com.jurisconexao.auth.services.VendedorService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class AppController {
    
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PersonRepository personRepo;
    @Autowired
    private JwtUtil jwtUtil;
     @Autowired
    private VendedorService VendedorService;
     
     @Autowired
     private AuthenticationManager authenticationManager;
      
	
    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

	@CrossOrigin(origins = "http://localhost:4200/")
     @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception { //change to entity
              
      try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception ex) {
	      System.err.println(ex.getMessage());
           // throw new Exception("inavalid username/password");
	       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
        } 
	    return ResponseEntity.status(HttpStatus.OK).body(jwtUtil.generateToken(authRequest.getEmail()));
      
       
    }
    
	@CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signupform";
    }

	@CrossOrigin(origins = "http://localhost:4200/")
@PostMapping("/process_register")
public ResponseEntity<User> processRegister(@RequestBody User user) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
  //  System.err.println(user.toString());
    
    //SALVA USUARIO
     user.setVerify(false);
    User newUser = userRepo.save(user);
    
     Locale locale = new Locale("pt","BR");
                SimpleDateFormat formatador = new SimpleDateFormat("YYYY-MM-dd hh:mm:ssXXX",locale);
                Date d = new Date();
                String data = formatador.format(d.getTime());
    
    //SALVA MODEL
    if(user.getTipo().equals("1")){ //VENDEDOR
        Vendedor vendedor = new Vendedor();
        vendedor.setId(newUser.getId());
        vendedor.setNomefantasia(user.getFirstName() + " " + user.getLastName());
        vendedor.setRua("Rua dos Bobos");
        vendedor.setEmail(newUser.getEmail());
        vendedor.setTelefone("+55 (75) 9 88525220");
        vendedor.setDatainicio(data);
        vendedor.setDatafim(data);
        vendedor.setAmbiente(0);
        vendedor.setSerie(0);
        vendedor.setDescricao("Olá, sou "+vendedor.getNomefantasia()+" : Decisões: Se você não consegue decidir, a resposta é não. Se dois caminhos igualmente difíceis, escolha o mais doloroso a curto prazo (evitar a dor é criar uma ilusão de igualdade).");
        VendedorService.addVendedor(vendedor);

	
        
        
        
    }
    if(user.getTipo().equals("2")){ //Revendedor
        Revendedor r = new Revendedor();
        r.setCodigo(user.getFirstName() + user.getLastName()+newUser.getId());
        r.setEmail(newUser.getEmail());
        r.setFirstName(user.getFirstName());
        r.setId(newUser.getId());
        r.setLastName(user.getLastName());
        
        //revendedorservice.add(r);
    }
    if(user.getTipo().equals("3")){ //CLIENTE
         Person person = new Person();
        person.setId(newUser.getId());
        person.setEmail(user.getEmail());
        person.setPassword(user.getPassword());
        person.setFirstName(user.getFirstName());
        person.setLastName(user.getLastName());
        personRepo.save(person);
    }
   
    
    
  
         
         
         
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
}
@CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/users")
    public String listUsers(Model model) {
    List<User> listUsers = userRepo.findAll();
    model.addAttribute("listUsers", listUsers);
     
    
    return "users";
}
@CrossOrigin(origins = "http://localhost:4200/")
 @GetMapping("/user/{email}")
    public ResponseEntity<User> getUserByEmail (@PathVariable("email") String email) {
        User user = userRepo.findByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
@CrossOrigin(origins = "http://localhost:4200/")
@GetMapping("/user/id/{email}")
    public ResponseEntity<User> getUserById (@PathVariable("email") Long email) {
        User user = userRepo.findByid(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

   
    
    
    @GetMapping(path = "confirm")
    public Boolean confirm(@RequestParam("token") String token,
            @RequestParam("email") String email) {
        
        User user = userRepo.findByEmail(email);
        
        //Verifica se email já foi verificado
        if (user.isVerify()) {
            throw new IllegalStateException("email already confirmed");
        }

        
        //Verifica se token expirou
        if (jwtUtil.isTokenExpired(token)) {
            throw new IllegalStateException("token expired");
        }

        //ConfirmaEmail
        user.setVerify(true);
        User newUser = userRepo.save(user);
        
        Locale locale = new Locale("pt","BR");

                SimpleDateFormat formatador = new SimpleDateFormat("YYYY-MM-dd hh:mm:ssXXX",locale);
                Date d = new Date();
         
         
         
       /* try {
            EventoService.SaveEvento(evento,"7");
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        return true;
    }
    
    
  @GetMapping(path = "islogged")
    public Boolean confirm(@RequestParam("token") String token){
        if (jwtUtil.isTokenExpired(token)) {
            throw new IllegalStateException("token expired");
        }
        
        return true;
    }
    
    
   
    
}
