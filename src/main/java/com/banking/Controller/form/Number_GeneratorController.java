package com.banking.Controller.form;



//import com.stockvendor.vendor.repository.DocumentNumberingRepository;
import com.banking.Model.Number_Generator;
import com.banking.Repository.Number_GeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/dashboard")
public class Number_GeneratorController {

    @Autowired
    private Number_GeneratorRepository Number_GeneratorRepository;

    @GetMapping(value = "/documentNumberingList")
    private String listDocumentNumbering(Model model){
        List<Number_Generator> numbering= Number_GeneratorRepository.findAll();
        model.addAttribute("numbering", numbering);
        return "admin/table/numberingList";
    }

    @RequestMapping(value = "/updateDocumentNumbering/{id}")
    public String updateNumbering(@PathVariable("id") int id, Model model){

        //DocumentNumbering retData = documentNumberingRepository.findById(id).get();
        Number_Generator retData = Number_GeneratorRepository.findById(id).get();
        model.addAttribute("numbering", retData);
        return "admin/form/DocumentNumbering";
    }

    @PostMapping(value = "/updateDocumentNumbering/{id}")
    public String updateNumbering(@PathVariable("id") int id,Model model, Number_Generator documentNumbering){

        int prefixAmt = documentNumbering.getPrefixNo();
        int prefixStartingNum = documentNumbering.getStartingPrefixNo();
        String prefixStr = String.format("%0" + prefixAmt + "d", prefixStartingNum);

        String display = documentNumbering.getPrefixWord()+"-"+prefixStr;
        documentNumbering.setDisplayNo(display);

        Number_GeneratorRepository.save(documentNumbering);
        model.addAttribute("success","           Number Generator Code has been Updated Successfully              ");
        model.addAttribute("numbering", Number_GeneratorRepository.findAll());
        return "admin/table/numberingList";
    }

}