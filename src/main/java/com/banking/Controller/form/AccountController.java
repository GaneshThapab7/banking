package com.banking.Controller.form;

import com.banking.Model.Account;
import com.banking.Model.Customer;
import com.banking.Model.Number_Generator;
import com.banking.Model.users;
import com.banking.Repository.AccountRepository;
import com.banking.Repository.CustomerRepository;
import com.banking.Repository.Interface.ServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/dashboard/")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ServicesInterface servicesInterface;

    @Autowired
    private CustomerRepository customerRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                byte[].class,
                new ByteArrayMultipartFileEditor());
    }

    @GetMapping(value = "/addAccountForm")
    private String getAccountAddition(Model model) {
        model.addAttribute("accounts",new Account());
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers",customers);
        return "non-teller/form/addAccount";
    }

    @PostMapping(value = "/addAccount")
    private String addUser(@RequestParam("signature1") MultipartFile signature1,@RequestParam("endorsement") MultipartFile endorsement, Model model, @Valid Account account, BindingResult bindingResult)  {



        if (signature1.isEmpty() == false){


            String sig_1_name = account.getCustomer1().getCustomer_code()+account.getCustomer1().getFirst_name()+"."+signature1.getOriginalFilename().split("\\.")[1];

            try {
                servicesInterface.uploadImage(signature1,sig_1_name,"customers"+"\\"+sig_1_name);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error while uploading");
            }
            account.setSignature_1(sig_1_name);

        }
        else {
            try {
                Account accounts = accountRepository.findById(account.getAccount_no()).get();
                account.setSignature_1(accounts.getSignature_1());
            }
            catch (Exception e){}
        }



        if (endorsement.isEmpty() == false){


            String endorsement_name = account.getCustomer1().getCustomer_code()+account.getCustomer1().getFirst_name()+"."+endorsement.getOriginalFilename().split("\\.")[1];

            try {
                servicesInterface.uploadImage(endorsement,endorsement_name,"customers"+"\\"+account.getAccount_no());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error while uploading");
            }
            account.setEndorsement(endorsement_name);

        }
        else {
            try {
                Account accounts = accountRepository.findById(account.getAccount_no()).get();
                account.setEndorsement(accounts.getEndorsement());
            }catch (Exception e){}

        }
        account.setOn_loan(false);
        accountRepository.save(account);
        model.addAttribute("success","           Account has been Added/Updated Successfully              ");
        List<Account> accounts= accountRepository.findAll();
        model.addAttribute("account", accounts);
        return "non-teller/table/listAccount";
    }

    @GetMapping(value = "/listAccount")
    private String listAccount(Model model) {
        List<Account> accounts= accountRepository.findAll();
        model.addAttribute("account", accounts);
        return "non-teller/table/listAccount";
    }
    @RequestMapping(value = "/updateAccountData/{id}")
    public String updateCustomersData(@PathVariable("id") int id, Model model){
        Account retData = accountRepository.findById(id).get();
        model.addAttribute("account", retData);
        return "non-teller/form/addAccount";
    }
}
