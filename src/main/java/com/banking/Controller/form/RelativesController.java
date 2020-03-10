package com.banking.Controller.form;


import com.banking.Model.Relative_Nominee;
import com.banking.Repository.RelativesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class RelativesController {

    @Autowired
    private RelativesRepository relativesRepository;

    @GetMapping(value = "/addRelativesForm")
    public String addRelativesForm(Model model){
        model.addAttribute("relatives", new Relative_Nominee());
        return null;
    }

    @PostMapping(value = "/addRelatives")
    public String addRelatives(Model model, Relative_Nominee relative_nominee){
        relativesRepository.save(relative_nominee);
        return null;
    }
}
