package com.petshop.controller;
import com.petshop.service.AgendamentoService;
import com.petshop.model.Agendamento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/agendamentos")
public class AgendamentoMvcController {
    private final AgendamentoService service;
    public AgendamentoMvcController(AgendamentoService service){ this.service = service; }
    @GetMapping
    public String list(Model model){ model.addAttribute("items", service.listar()); return "agendamentos/lista"; }
    @GetMapping("/novo")
    public String novo(Model model){ model.addAttribute("item", new Agendamento()); return "agendamentos/form"; }
    @PostMapping("/salvar")
    public String salvar(Agendamento item){ service.salvar(item); return "redirect:/agendamentos"; }
}