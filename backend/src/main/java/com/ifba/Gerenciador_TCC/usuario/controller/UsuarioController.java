package com.ifba.Gerenciador_TCC.usuario.controller;

import com.ifba.Gerenciador_TCC.security.CustomUserDetailsService;
import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioControllerApi;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;
import com.ifba.Gerenciador_TCC.login.domain.LoginRequest;
import com.ifba.Gerenciador_TCC.exceptions.NotFoundException;
import com.ifba.Gerenciador_TCC.security.JwtTokenUtil;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class UsuarioController implements UsuarioControllerApi {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }
    @GetMapping
    public ResponseEntity<Void> redirecionar(@RequestBody RedirecionarRequest redirecionarRequest) {
        Usuario usuario = usuarioService.findById(redirecionarRequest.getId());
        if (usuario != null) {
            String posicao = usuario.getTipoUsuario().getDescricao();
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("/dashboard/" + posicao))
                    .build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
