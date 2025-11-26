package com.petshop.controller;
import com.petshop.service.ServicoService;
import com.petshop.model.Servico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/servicos")
public class ServicoMvcController {
    private final ServicoService service;
    public ServicoMvcController(ServicoService service){ this.service = service; }
    @GetMapping
    public String list(Model model){ model.addAttribute("items", service.listar()); return "servicos/lista"; }
    @GetMapping("/novo")
    public String novo(Model model){ model.addAttribute("item", new Servico()); return "servicos/form"; }
    @PostMapping("/salvar")
    public String salvar(Servico item){ service.salvar(item); return "redirect:/servicos"; }
}