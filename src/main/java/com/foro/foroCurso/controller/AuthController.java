package com.foro.foroCurso.controller;

import com.foro.foroCurso.dto.AuthRequest;
import com.foro.foroCurso.repository.UsuarioRepository;
import com.foro.foroCurso.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private UsuarioRepository usuarioRepo;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest request) {
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String token = jwtUtil.generarToken(request.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }
}


