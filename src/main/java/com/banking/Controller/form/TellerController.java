package com.banking.Controller.form;

import com.banking.Model.*;
import com.banking.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "admin/dashboard")
public class TellerController {
@Autowired
     private TellerRepository tellerRepository;

    @Autowired
    private Number_GeneratorRepository number_generatorRepository;

    @Autowired
    private BranchesRepository branchesRepository;

    @Autowired
    private UserRepository userRepository;



    @GetMapping(value = "/addTellerForm")
    public String getAddBranchForm(Model model){
        model.addAttribute("teller", new Teller());

        List<Branches> allBranch = branchesRepository.findAll();
        model.addAttribute("allBranch",allBranch);
//
        Number_Generator number_generator= number_generatorRepository.findById(3).get();

        model.addAttribute("documentNumbering", number_generator);
        return "admin/form/addTellerToBranch";
    }
    @RequestMapping(value = "/deleteTeller/{id}")
    public String deleteTeller(@PathVariable("id") int id,Model model){
        Teller ret_data = tellerRepository.findById(id).get();
        tellerRepository.delete(ret_data);
        model.addAttribute("teller",tellerRepository.findAll());
        return "admin/table/tellerTable";

    }

    @GetMapping(value = "/tellerList")
    public String getTellerList(Model model){
        List<Teller> teller = tellerRepository.findAll();
        model.addAttribute("teller", teller);

        return "admin/table/tellerTable";
    }

    @PostMapping(value = "/addTeller")
    public String addTeller(Model model, Teller teller) {
        if(teller.getUsers() != null){
            teller.setFull_name(teller.getUsers().getFirst_name()+' '+teller.getUsers().getMiddle_name()+' '+teller.getUsers().getLast_name());
            tellerRepository.save(teller);
            model.addAttribute("success","           Teller has been Updated Successfully              ");
        }
        else  {
            tellerRepository.save(teller);
            model.addAttribute("success","           Teller has been Added Successfully              ");
        }

        Number_Generator no1 = number_generatorRepository.findById(3).get();

        no1.setStartingPrefixNo(no1.getStartingPrefixNo()+1);


        int prefixAmt = no1.getPrefixNo();
        int prefixStartingNum = no1.getStartingPrefixNo();
        String prefixStr = String.format("%0" + prefixAmt + "d", prefixStartingNum);

        String display = no1.getPrefixWord()+"-"+prefixStr;
        no1.setDisplayNo(display);

        number_generatorRepository.save(no1);
        List<Teller> tellers = tellerRepository.findAll();
        model.addAttribute("teller",tellers);
        return "admin/table/tellerTable";
    }
    @RequestMapping(value = "/updateTellerData/{id}")
    public String updateBranchesData(@PathVariable("id") Integer id, Model model){
        Teller retData = tellerRepository.findById(id).get();
        model.addAttribute("teller", retData);

        List<Users> users = userRepository.findAll();
        model.addAttribute("users",users);

        List<Branches> allBranch = branchesRepository.findAll();
        model.addAttribute("allBranch",allBranch);

        model.addAttribute("del",true);

        Number_Generator numData = number_generatorRepository.findById(3).get();
        model.addAttribute("documentNumbering",numData);

        return "admin/form/addTeller";
    }

}

