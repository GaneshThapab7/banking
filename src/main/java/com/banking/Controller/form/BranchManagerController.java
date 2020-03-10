package com.banking.Controller.form;

import com.banking.Model.*;
import com.banking.Repository.BranchManagerRepository;
import com.banking.Repository.BranchesRepository;
import com.banking.Repository.Number_GeneratorRepository;
import com.banking.Repository.UserRepository;
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
public class BranchManagerController {
@Autowired
    private BranchManagerRepository branchManagerRepository;
@Autowired
    private BranchesRepository branchesRepository;
@Autowired
    private UserRepository userRepository;
@Autowired
    private Number_GeneratorRepository number_generatorRepository;

    @GetMapping(value = "/addManagerForm")
    public String getAddBranchForm(Model model){
        model.addAttribute("branch_manager", new Branch_Manager());

        List<Branches> branches = branchesRepository.findAll();
        model.addAttribute("branches", branches);

        List<users> users = userRepository.findAll();
        model.addAttribute("users",users);

        return "admin/form/addManager";
    }

    @GetMapping(value = "/ManagerList")
    public String getBranchList(Model model){
        List<Branch_Manager> branch_manager= branchManagerRepository.findAll();
        model.addAttribute("branch_manager",branch_manager);
        return "admin/table/branchManagertable";
    }

    @PostMapping(value = "/addManager")
    public String addBranchManager(Model model, Branch_Manager branch_manager){
    branch_manager.setFull_name(branch_manager.getUsers().getFirst_name()+' '+branch_manager.getUsers().getMiddle_name()+' '+branch_manager.getUsers().getLast_name());
        branchManagerRepository.save(branch_manager);
        model.addAttribute("branch_manager", new Branch_Manager());
        model.addAttribute("success","           Branch Manager has been Updated Successfully              ");
        model.addAttribute("branch_manager",branchManagerRepository.findAll());
        return "admin/table/branchManagertable";
    }

    @RequestMapping(value = "/updateManagerData/{id}")
    public String updateBranchesData(@PathVariable("id") Integer id, Model model){
        Branch_Manager retData = branchManagerRepository.findById(id).get();
        model.addAttribute("branch_manager", retData);

        List<users> users = userRepository.findAll();
        model.addAttribute("users",users);
        model.addAttribute("del",true);
        List<Branches> allBranch = branchesRepository.findAll();
        model.addAttribute("allBranch",allBranch);

        return "admin/form/addManager";
    }

    @RequestMapping(value = "/deleteManager/{id}")
    public String deleteManager(@PathVariable("id") int id,Model model){
        Branch_Manager ret_data = branchManagerRepository.findById(id).get();
        try {
            branchManagerRepository.delete(ret_data);
        }
        catch (Exception e){
            System.out.println("Branch Manager  cannot be deleted");
        }
        List<Branch_Manager> branch_manager= branchManagerRepository.findAll();
        model.addAttribute("branch_manager",branch_manager);
        return "admin/table/branchManagertable";

    }

}
