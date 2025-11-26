package com.petshop.controller;
import com.petshop.model.Servico;
import com.petshop.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/servico")
public class ServicoApiController {
    private final ServicoService service;
    public ServicoApiController(ServicoService service){ this.service = service; }
    @GetMapping
    public List<Servico> list(){ return service.listar(); }
    @GetMapping("/{id}")
    public ResponseEntity<Servico> get(@PathVariable Long id){ return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping
    public ResponseEntity<Servico> create(@RequestBody Servico obj){ Servico saved = service.salvar(obj); return ResponseEntity.created(URI.create("/api/servico/" + saved.getId())).body(saved); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.deletar(id); return ResponseEntity.noContent().build(); }
}