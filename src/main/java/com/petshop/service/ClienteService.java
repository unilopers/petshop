package com.petshop.service;
import com.petshop.model.Cliente;
import com.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ClienteService {
    private final ClienteRepository repo;
    public ClienteService(ClienteRepository repo){ this.repo = repo; }
    public List<Cliente> listar(){ return repo.findAll(); }
    public Optional<Cliente> buscar(Long id){ return repo.findById(id); }
    public Cliente salvar(Cliente obj){ return repo.save(obj); }
    public void deletar(Long id){ repo.deleteById(id); }
}