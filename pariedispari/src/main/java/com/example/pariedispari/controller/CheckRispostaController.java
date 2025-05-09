package com.example.pariedispari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckRispostaController {
    
    @GetMapping("/")
    public String mostraHome() {
        return "home";
    }

    @PostMapping("/verificaNumero")
    public String verificaRisposta(@RequestParam("numero") String numero) {
        
        String numeroSanitized = numero.trim().toLowerCase();
        if (Integer.parseInt(numeroSanitized) % 2 == 0) {
            return "pari";
        } else {
            return "dispari";
        }
    }
}


