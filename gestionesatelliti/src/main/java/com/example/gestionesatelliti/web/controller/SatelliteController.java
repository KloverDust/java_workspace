package com.example.gestionesatelliti.web.controller;

import com.example.gestionesatelliti.model.Satellite;
import com.example.gestionesatelliti.service.SatelliteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/satellite")
public class SatelliteController {
    @Autowired
    private SatelliteService satelliteService;

    @GetMapping
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView();
        List<Satellite> results = satelliteService.listAllElements();
        mv.addObject("satellite_list_attribute", results);
        mv.setViewName("satellite/list");
        return mv;
    }

    @GetMapping("/search")
    public String search() {
        return "satellite/search";
    }

    @PostMapping("/list")
    public String listByExample(Satellite example, ModelMap model) {
        List<Satellite> results = satelliteService.findByExample(example);
        model.addAttribute("satellite_list_attribute", results);
        return "satellite/list";
    }

    @GetMapping("/insert")
    public String create(Model model) {
        model.addAttribute("insert_satellite_attr", new Satellite());
        return "satellite/insert";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("insert_satellite_attr") Satellite satellite, BindingResult result, RedirectAttributes redirectAttrs) {

        if (result.hasErrors())
            return "satellite/insert";

        satelliteService.inserisciNuovo(satellite);

        redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
        return "redirect:/satellite";
    }

    @GetMapping("/show/{idSatellite}")
    public String show(@PathVariable(required = true) Long idSatellite, Model model) {
        model.addAttribute("show_satellite_attr", satelliteService.caricaSingoloElemento(idSatellite));
        return "satellite/show";
    }

    @GetMapping("/delete/{idSatellite}")
    public String delete(@PathVariable(required = true) Long idSatellite, Model model, RedirectAttributes redirectAttrs) {
        Satellite imp = satelliteService.caricaSingoloElemento(idSatellite);
        model.addAttribute("delete_satellite_attr", imp);
        return "satellite/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("delete_satellite_attr") Satellite satellite, RedirectAttributes redirectAttrs) {
        satelliteService.rimuovi(satellite.getId());

        redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
        return "redirect:/satellite";
    }

    @GetMapping("/edit/{idSatellite}")
    public String edit(@PathVariable Long idSatellite, Model model) {
        Satellite imp = satelliteService.caricaSingoloElemento(idSatellite);
        model.addAttribute("edit_satellite_attr", imp);
        return "satellite/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("edit_satellite_attr") Satellite satellite, BindingResult result, RedirectAttributes redirectAttrs) {

        if (result.hasErrors()) {
            return "satellite/edit";
        }

        satelliteService.aggiorna(satellite);
        redirectAttrs.addFlashAttribute("successMessage", "Modifica eseguita correttamente");
        return "redirect:/satellite";
    }

    @GetMapping("/inorbitaDaPiuDi2anni")
    public String cercaLanciatiDaPiuDi2Anni(ModelMap model) throws Exception {
            List<Satellite> results = satelliteService.cercaLanciatiDaPiuDi2Anni();
            model.addAttribute("satellite_list_attribute", results);
            return "satellite/list";

    }

    @GetMapping("/disattivatiNonRientrati")
    public String cercaDisattivatiNonRientrati(ModelMap model) throws Exception {
        List<Satellite> results = satelliteService.cercaDisattivatiNonRientrati();
        model.addAttribute("satellite_list_attribute", results);
        return "satellite/list";
    }

    @GetMapping("/fissiDaPiuDi10anni")
    public String cercaFissiConOrbitaSuperioreA10Anni(ModelMap model) throws Exception {
        List<Satellite> results = satelliteService.cercaFissiConOrbitaSuperioreA10Anni();
        model.addAttribute("satellite_list_attribute", results);
        return "satellite/list";
    }
}

