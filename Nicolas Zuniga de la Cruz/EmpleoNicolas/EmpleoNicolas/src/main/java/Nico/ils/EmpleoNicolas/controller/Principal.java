package Nico.ils.EmpleoNicolas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Principal {
@GetMapping("/")
public String paginaInicial(Model model) {
model.addAttribute("nombre","Nicolas");
return "home";
}
}
