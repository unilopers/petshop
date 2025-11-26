package com.petshop.controller;
import com.petshop.model.Agendamento;
import com.petshop.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoApiController {
    private final AgendamentoService service;
    public AgendamentoApiController(AgendamentoService service){ this.service = service; }
    @GetMapping
    public List<Agendamento> list(){ return service.listar(); }
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> get(@PathVariable Long id){ return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody Agendamento obj){ Agendamento saved = service.salvar(obj); return ResponseEntity.created(URI.create("/api/agendamento/" + saved.getId())).body(saved); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.deletar(id); return ResponseEntity.noContent().build(); }
}