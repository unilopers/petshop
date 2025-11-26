package com.petshop.service;
import com.petshop.model.Pet;
import com.petshop.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PetService {
    private final PetRepository repo;
    public PetService(PetRepository repo){ this.repo = repo; }
    public List<Pet> listar(){ return repo.findAll(); }
    public Optional<Pet> buscar(Long id){ return repo.findById(id); }
    public Pet salvar(Pet obj){ return repo.save(obj); }
    public void deletar(Long id){ repo.deleteById(id); }
}