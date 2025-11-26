package com.petshop.controller;
import com.petshop.model.Cliente;
import com.petshop.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/cliente")
public class ClienteApiController {
    private final ClienteService service;
    public ClienteApiController(ClienteService service){ this.service = service; }
    @GetMapping
    public List<Cliente> list(){ return service.listar(); }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Long id){ return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente obj){ Cliente saved = service.salvar(obj); return ResponseEntity.created(URI.create("/api/cliente/" + saved.getId())).body(saved); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.deletar(id); return ResponseEntity.noContent().build(); }
}