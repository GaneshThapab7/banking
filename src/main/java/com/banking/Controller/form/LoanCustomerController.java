package com.banking.Controller.form;

import com.banking.Model.Customer;
import com.banking.Model.Loan_Customer;
import com.banking.Model.Number_Generator;
import com.banking.Repository.LoanCustomerRepository;
import com.banking.Repository.Number_GeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class LoanCustomerController {
    @Autowired
    private LoanCustomerRepository loanCustomerRepository;
    @Autowired
    private Number_GeneratorRepository number_generatorRepository;

    @GetMapping(value = "/addLoanCustomerForm")
    private String getCustomerAddition(Model model) {
        model.addAttribute("loan_customers",new Loan_Customer());
        Number_Generator number_generator= number_generatorRepository.findById(5).get();
        model.addAttribute("documentNumbering", number_generator);
        return "non-teller/form/addLoanCustomer";
    }

    @GetMapping(value = "/listLoanCustomer")
    private String listCustomer(Model model) {
        List<Loan_Customer> loan_customers = loanCustomerRepository.findAll();
        model.addAttribute("loan_customers",loan_customers);
        return "non-teller/table/viewLoanCustomer";
    }
    @RequestMapping(value = "/updateLoanCustomerData/{id}")
    public String updateCustomersData(@PathVariable("id") String id, Model model){
        Loan_Customer retData = loanCustomerRepository.findById(id).get();
        model.addAttribute("loan_customers", retData);
        return "non-teller/form/addLoanCustomer";
    }
}
