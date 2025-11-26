package com.petshop.service;
import com.petshop.model.Produto;
import com.petshop.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ProdutoService {
    private final ProdutoRepository repo;
    public ProdutoService(ProdutoRepository repo){ this.repo = repo; }
    public List<Produto> listar(){ return repo.findAll(); }
    public Optional<Produto> buscar(Long id){ return repo.findById(id); }
    public Produto salvar(Produto obj){ return repo.save(obj); }
    public void deletar(Long id){ repo.deleteById(id); }
}