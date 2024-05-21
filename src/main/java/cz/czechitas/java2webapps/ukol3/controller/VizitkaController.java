package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import cz.czechitas.java2webapps.ukol3.service.VizitkaService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final VizitkaService service;

    public VizitkaController(VizitkaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("seznam", service.getAll());
        return result;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView result = new ModelAndView("detail");
        result.addObject("vizitka", service.getById(id));
        return result;
    }
   @RequestMapping("/nova")

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/nova");
        modelAndView.addObject("vizitka", new Vizitka());
        return modelAndView;
    }
    @PostMapping("")
    public Object form(@ModelAttribute("form") Vizitka vizitka, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/nova";
        }
        service.PridejVizitku(vizitka);
           ModelAndView result = new ModelAndView("seznam");
        result.addObject("seznam", service.getAll());
        return result;
        //.addObject("kod", Math.abs(random.nextInt()))
    }
    @PostMapping("/delete")
    public String delete(int id) {
        service.SmazVizitku(id);
        return "redirect:/";
    }
}

