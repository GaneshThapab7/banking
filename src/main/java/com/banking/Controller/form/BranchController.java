package com.banking.Controller.form;

import com.banking.Model.Branch_Manager;
import com.banking.Model.Branches;
import com.banking.Model.Number_Generator;
import com.banking.Repository.BranchesRepository;
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
@RequestMapping("/admin/dashboard")
public class BranchController {

    @Autowired
    private BranchesRepository branchesRepository;

    @Autowired
    private Number_GeneratorRepository number_generatorRepository;

    @GetMapping(value = "/addBranch")
    public String getAddBranchForm(Model model){
        Number_Generator number_generator= number_generatorRepository.findById(2).get();
        model.addAttribute("documentNumbering", number_generator);
        model.addAttribute("branch", new Branches());
        return "admin/form/addBranch";
    }

    @GetMapping(value = "/branchList")

    private String listBranch(Model model){
        List<Branches> branches = branchesRepository.unArchivedBranches();
        model.addAttribute("branches",branches);
        return "admin/table/branchTable";

    }
    @GetMapping(value = "/archivedBranchList")

    private String listArchivedBranch(Model model){
        List<Branches> branches = branchesRepository.archivedBranches();
        model.addAttribute("branches",branches);
        return "admin/table/branchTable";

    }


    @PostMapping(value = "/add")
    public String addBranch(Model model, Branches branches){
        branches.setArchived(false);
        branchesRepository.save(branches);
        model.addAttribute("success","           Branch has been Added/Updated Successfully              ");

        //      ++++++  For updating Document numbering +++++++

        Number_Generator no1 = number_generatorRepository.findById(2).get();
//      increment value for numbering
        no1.setStartingPrefixNo(no1.getStartingPrefixNo()+1);
//        no1.setStartingSuffixNo(no1.getStartingSuffixNo()+1);

        int prefixAmt = no1.getPrefixNo();
        int prefixStartingNum = no1.getStartingPrefixNo();
        String prefixStr = String.format("%0" + prefixAmt + "d", prefixStartingNum);
        String display = no1.getPrefixWord()+"-"+prefixStr;
        no1.setDisplayNo(display);

        number_generatorRepository.save(no1);
        //end of increment value for numbering
        model.addAttribute("num", number_generatorRepository.findById(2).get().getDisplayNo());
        model.addAttribute("branch", new Branches());
        List<Branches> branch = branchesRepository.findAll();
        model.addAttribute("branches",branch);
        return "admin/table/branchTable";
    }

    @RequestMapping(value = "/updateBranchData/{id}")
    public String updateBranchesData(@PathVariable("id") String id, Model model){
        Branches retData = branchesRepository.findById(id).get();
        model.addAttribute("branch", retData);
        model.addAttribute("del",true);

        Number_Generator numData = number_generatorRepository.findById(2).get();
        model.addAttribute("documentNumbering",numData);
        return "admin/form/addBranch";
    }

    @RequestMapping(value = "/deleteBranches/{id}")
    public String deleteBranches(@PathVariable("id") String branch_code,Model model){
        Branches ret_data = branchesRepository.findById(branch_code).get();
        try {
            branchesRepository.delete(ret_data);
        }
        catch (Exception e){
            System.out.println("branches cannot be deleted");
        }
        model.addAttribute("branches",branchesRepository.unArchivedBranches());
        return "admin/table/branchTable";

    }



}
