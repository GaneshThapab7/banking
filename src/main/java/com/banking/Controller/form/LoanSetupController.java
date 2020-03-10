package com.banking.Controller.form;

import com.banking.Model.Branches;
import com.banking.Model.Loan_Customer;
import com.banking.Model.Loan_Setup;
import com.banking.Model.Number_Generator;
import com.banking.Repository.LoanCustomerRepository;
import com.banking.Repository.LoanSetupRespository;
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
public class LoanSetupController {
    @Autowired
    private LoanSetupRespository loanSetupRespository;

    @GetMapping(value = "/addLoanSetupForm")
    private String getCustomerAddition(Model model) {
        model.addAttribute("loan_setup",new Loan_Setup());
        return "admin/form/addLoanSetup";
    }

    @GetMapping(value = "/loanList")
    private String listLoan(Model model){
        List<Loan_Setup> loan_setups = loanSetupRespository.findAll();
        model.addAttribute("loan_setups",loan_setups);
        return "admin/table/loanSetupTable";

    }

    @RequestMapping(value = "/updateLoanSetupData/{id}")
    public String updateBranchesData(@PathVariable("id") int id, Model model){
        Loan_Setup retData = loanSetupRespository.findById(id).get();
        model.addAttribute("loan_setup", retData);
        model.addAttribute("del",true);
        return "admin/form/addLoanSetup";
    }

    @PostMapping(value = "/addLoanSetup")
    public String updateNumbering(Model model, Loan_Setup loan_setup){
        if(loan_setup.getCode() ==0)
            model.addAttribute("success","           Loan Setup has been Added Successfully              ");
        else
            model.addAttribute("success","           Loan Setup has been Updated Successfully               ");
        loanSetupRespository.save(loan_setup);
        List<Loan_Setup> loan_setups = loanSetupRespository.findAll();
        model.addAttribute("loan_setups",loan_setups);
        return "admin/table/loanSetupTable";
    }

    @RequestMapping(value = "/deleteLoanSetup/{id}")
    public String deleteUser(@PathVariable("id") int id,Model model){
        Loan_Setup ret_data = loanSetupRespository.findById(id).get();
        try {
            loanSetupRespository.delete(ret_data);
        }
        catch (Exception e){
            System.out.println("Loan cannot be deleted");
        }
        model.addAttribute("loan_setups",loanSetupRespository.findAll());
        return "admin/table/loanSetupTable";

    }
}
