package com.petshop.controller;
import com.petshop.service.ClienteService;
import com.petshop.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/clientes")
public class ClienteMvcController {
    private final ClienteService service;
    public ClienteMvcController(ClienteService service){ this.service = service; }
    @GetMapping
    public String list(Model model){ model.addAttribute("items", service.listar()); return "clientes/lista"; }
    @GetMapping("/novo")
    public String novo(Model model){ model.addAttribute("item", new Cliente()); return "clientes/form"; }
    @PostMapping("/salvar")
    public String salvar(Cliente item){ service.salvar(item); return "redirect:/clientes"; }
}