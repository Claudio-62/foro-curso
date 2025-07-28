package com.foro.foroCurso.service;

import com.foro.foroCurso.dto.CrearTopicoDTO;
import com.foro.foroCurso.dto.TopicoDTO;
import com.foro.foroCurso.model.Topico;
import com.foro.foroCurso.model.Usuario;
import com.foro.foroCurso.repository.TopicoRepository;
import com.foro.foroCurso.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired private TopicoRepository topicoRepo;
    @Autowired private UsuarioRepository usuarioRepo;

    public TopicoDTO crear(CrearTopicoDTO dto) {
        Usuario autor = usuarioRepo.findById(dto.autorId()).orElseThrow();
        Topico topico = new Topico();
        topico.setTitulo(dto.titulo());
        topico.setMensaje(dto.mensaje());
        topico.setAutor(autor);
        topicoRepo.save(topico);
        return new TopicoDTO(topico.getId(), topico.getTitulo(), topico.getMensaje(), autor.getNombre());
    }

    public List<TopicoDTO> listar() {
        return topicoRepo.findAll().stream()
                .map(t -> new TopicoDTO(t.getId(), t.getTitulo(), t.getMensaje(), t.getAutor().getNombre()))
                .toList();
    }

    public TopicoDTO obtener(Long id) {
        Topico t = topicoRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return new TopicoDTO(t.getId(), t.getTitulo(), t.getMensaje(), t.getAutor().getNombre());
    }

    public TopicoDTO actualizar(Long id, CrearTopicoDTO dto) {
        Topico t = topicoRepo.findById(id).orElseThrow();
        t.setTitulo(dto.titulo());
        t.setMensaje(dto.mensaje());
        topicoRepo.save(t);
        return new TopicoDTO(t.getId(), t.getTitulo(), t.getMensaje(), t.getAutor().getNombre());
    }

    public void eliminar(Long id) {
        topicoRepo.deleteById(id);
    }
}