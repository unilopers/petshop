package com.petshop.controller;
import com.petshop.service.PetService;
import com.petshop.model.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/pets")
public class PetMvcController {
    private final PetService service;
    public PetMvcController(PetService service){ this.service = service; }
    @GetMapping
    public String list(Model model){ model.addAttribute("items", service.listar()); return "pets/lista"; }
    @GetMapping("/novo")
    public String novo(Model model){ model.addAttribute("item", new Pet()); return "pets/form"; }
    @PostMapping("/salvar")
    public String salvar(Pet item){ service.salvar(item); return "redirect:/pets"; }
}