package com.foro.foroCurso.controller;

import com.foro.foroCurso.dto.CrearTopicoDTO;
import com.foro.foroCurso.dto.TopicoDTO;
import com.foro.foroCurso.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
@Validated
public class TopicoController {

    @Autowired private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoDTO> crear(@Valid @RequestBody CrearTopicoDTO dto) {
        return new ResponseEntity<>(topicoService.crear(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TopicoDTO>> listar() {
        return ResponseEntity.ok(topicoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDTO> ver(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CrearTopicoDTO dto) {
        return ResponseEntity.ok(topicoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}




