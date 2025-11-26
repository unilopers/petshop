package com.petshop.service;
import com.petshop.model.Venda;
import com.petshop.repository.VendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class VendaService {
    private final VendaRepository repo;
    public VendaService(VendaRepository repo){ this.repo = repo; }
    public List<Venda> listar(){ return repo.findAll(); }
    public Optional<Venda> buscar(Long id){ return repo.findById(id); }
    public Venda salvar(Venda obj){ return repo.save(obj); }
    public void deletar(Long id){ repo.deleteById(id); }
}