package com.petshop.controller;
import com.petshop.model.Pet;
import com.petshop.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/pet")
public class PetApiController {
    private final PetService service;
    public PetApiController(PetService service){ this.service = service; }
    @GetMapping
    public List<Pet> list(){ return service.listar(); }
    @GetMapping("/{id}")
    public ResponseEntity<Pet> get(@PathVariable Long id){ return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping
    public ResponseEntity<Pet> create(@RequestBody Pet obj){ Pet saved = service.salvar(obj); return ResponseEntity.created(URI.create("/api/pet/" + saved.getId())).body(saved); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.deletar(id); return ResponseEntity.noContent().build(); }
}