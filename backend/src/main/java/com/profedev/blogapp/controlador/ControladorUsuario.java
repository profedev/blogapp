package com.profedev.blogapp.controlador;

import com.profedev.blogapp.controlador.data.DaoUsuarioDb;
import com.profedev.blogapp.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api")
public class ControladorUsuario {

    //Implementa el método login
    @PostMapping("user")
    public Usuario login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        DaoUsuarioDb db = new DaoUsuarioDb();
        // Controla que exista un usuario y el password correspondiente
        Usuario user = db.getUserByNombreUsuario(username);
        if(user!=null){
            if (user.getPassUsu().equals(pwd)){
                // Si el usuario es válido genera el token
                String token = getJWTToken(username);
                user.setNombreUsu(username);
                user.setToken(token);
            }
        }
        return user;
    }

    // Método que construye el token, delegando en la clase de utilidad Jwts que incluye información sobre su expiración y un objeto de
    // GrantedAuthority de Spring que usaremos para autorizar las peticiones a los recursos protegidos.
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("id")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000)) //Tiempo de expiración
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
