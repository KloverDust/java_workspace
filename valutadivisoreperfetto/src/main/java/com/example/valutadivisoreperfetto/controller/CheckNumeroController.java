package com.example.valutadivisoreperfetto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckNumeroController {

    @GetMapping("/")
    public String mostraHome() {
        return "home";
    }

    @PostMapping("/verificaDivisorePerfetto")
    public String verificaDivisorePerfetto(
            @RequestParam("dividendo") String dividendo,
            @RequestParam("divisore") String divisore,
            Model model) {

        int dividendoNum = Integer.parseInt(dividendo.trim());
        int divisoreNum = Integer.parseInt(divisore.trim());

        model.addAttribute("dividendo", dividendoNum);
        model.addAttribute("divisore", divisoreNum);

        if (divisoreNum == 0) {
            model.addAttribute("errore", "Divisione per zero non consentita");
            return "errore";
        }

        int resto = dividendoNum % divisoreNum;
        if (resto == 0) {
            int quoziente = dividendoNum / divisoreNum;
            model.addAttribute("quoziente", quoziente);
            return "multiplo";
        } else {
            model.addAttribute("resto", resto);
            return "divisioneconresto";
        }
    }
}
