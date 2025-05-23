package it.prova.gestioneimpiegati.web.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.gestioneimpiegati.model.Impiegato;
import it.prova.gestioneimpiegati.service.ImpiegatoService;

@Controller
@RequestMapping(value = "/impiegato")
public class ImpiegatoController {

	@Autowired
	private ImpiegatoService impiegatoService;

	@GetMapping
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView();
		List<Impiegato> results = impiegatoService.listAllElements();
		mv.addObject("impiegato_list_attribute", results);
		mv.setViewName("impiegato/list");
		return mv;
	}

	@GetMapping("/search")
	public String search() {
		return "impiegato/search";
	}

	@PostMapping("/list")
	public String listByExample(Impiegato example, ModelMap model) {
		List<Impiegato> results = impiegatoService.findByExample(example);
		model.addAttribute("impiegato_list_attribute", results);
		return "impiegato/list";
	}

	@GetMapping("/insert")
	public String create(Model model) {
		model.addAttribute("insert_impiegato_attr", new Impiegato());
		return "impiegato/insert";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("insert_impiegato_attr") Impiegato impiegato, BindingResult result,
			RedirectAttributes redirectAttrs) {

		if (result.hasErrors())
			return "impiegato/insert";

		impiegatoService.inserisciNuovo(impiegato);

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/impiegato";
	}

	@GetMapping("/show/{idImpiegato}")
	public String show(@PathVariable(required = true) Long idImpiegato, Model model) {
		model.addAttribute("show_impiegato_attr", impiegatoService.caricaSingoloElemento(idImpiegato));
		return "impiegato/show";
	}

	@GetMapping("/delete/{idImpiegato}")
	public String delete(@PathVariable(required = true) Long idImpiegato, Model model, RedirectAttributes redirectAttrs) {
		Impiegato imp = impiegatoService.caricaSingoloElemento(idImpiegato);
		model.addAttribute("delete_impiegato_attr", imp);
		return "impiegato/delete";
	}

	@PostMapping("/delete")
	public String delete(@ModelAttribute("delete_impiegato_attr") Impiegato impiegato, RedirectAttributes redirectAttrs) {
		impiegatoService.rimuovi(impiegato.getId());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/impiegato";
	}

	@GetMapping("/edit/{idImpiegato}")
	public String edit(@PathVariable Long idImpiegato, Model model) {
		Impiegato imp = impiegatoService.caricaSingoloElemento(idImpiegato);
		model.addAttribute("edit_impiegato_attr", imp);
		return "impiegato/edit";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("edit_impiegato_attr") Impiegato impiegato, BindingResult result, RedirectAttributes redirectAttrs) {

		if (result.hasErrors()) {
			return "impiegato/edit";
		}

		impiegatoService.aggiorna(impiegato);
		redirectAttrs.addFlashAttribute("successMessage", "Modifica eseguita correttamente");
		return "redirect:/impiegato";
	}




}
