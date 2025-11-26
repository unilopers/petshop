package com.petshop.config;
import com.petshop.model.Cliente;
import com.petshop.model.Pet;
import com.petshop.model.Produto;
import com.petshop.repository.ClienteRepository;
import com.petshop.repository.PetRepository;
import com.petshop.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner init(ClienteRepository cr, ProdutoRepository pr, PetRepository prp){
        return args -> {
            Cliente c = new Cliente(); c.setNome("Alexandre"); cr.save(c);
            Produto p = new Produto(); p.setNome("Racao"); pr.save(p);
            Pet pet = new Pet(); pet.setNome("Rex"); pet.setCliente(c); prp.save(pet);
        };
    }
}
