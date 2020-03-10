package com.banking.Controller.form;

import com.banking.Model.Account;
import com.banking.Model.Customer;
import com.banking.Model.Number_Generator;
import com.banking.Model.users;
import com.banking.Repository.CustomerRepository;
import com.banking.Repository.Interface.ServicesInterface;
import com.banking.Repository.Number_GeneratorRepository;
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
@RequestMapping("/dashboard")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Number_GeneratorRepository number_generatorRepository;

    @Autowired
    private ServicesInterface servicesInterface;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                byte[].class,
                new ByteArrayMultipartFileEditor());
    }

    @GetMapping(value = "/addCustomerForm")
    private String getCustomerAddition(Model model) {
        model.addAttribute("customers",new Customer());
        Number_Generator number_generator= number_generatorRepository.findById(4).get();
        model.addAttribute("documentNumbering", number_generator);
        return "non-teller/form/addCustomer";
    }

    @GetMapping(value = "/listCustomer")
    private String listCustomer(Model model) {
       List<Customer> customers = customerRepository.findAll();
       model.addAttribute("customers",customers);
        return "non-teller/table/viewCustomer";
    }

    @PostMapping (value = "/AddCustomer")
    private String getAccountAdditionPage(@RequestParam("photo") MultipartFile photo,Model model, @Valid Customer customer, BindingResult bindingResult) {
        if (photo.isEmpty() == false){
            String photo_name = customer.getCustomer_code()+customer.getFirst_name()+"."+photo.getOriginalFilename().split("\\.")[1];
            System.out.println(photo_name);
            try {
                servicesInterface.uploadImage(photo,photo_name,"customers"+"\\"+customer.getFirst_name());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error while uploading");
            }
            customer.setPhoto(photo_name);
        }
        else {
            Customer customers = customerRepository.findById(customer.getCustomer_code()).get();
            customer.setPhoto(customers.getPhoto());
        }
        customerRepository.save(customer);

        //      ++++++  For updating Document numbering +++++++
        Number_Generator no1 = number_generatorRepository.findById(4).get();

        no1.setStartingPrefixNo(no1.getStartingPrefixNo()+1);

        int prefixAmt = no1.getPrefixNo();
        int prefixStartingNum = no1.getStartingPrefixNo();
        String prefixStr = String.format("%0" + prefixAmt + "d", prefixStartingNum);

        String display = no1.getPrefixWord()+"-"+prefixStr;
        no1.setDisplayNo(display);

        number_generatorRepository.save(no1);

        model.addAttribute("success","           Customer has been Added/Updated Successfully              ");
        model.addAttribute("documentNumbering", number_generatorRepository.findById(4).get().getDisplayNo());

        model.addAttribute("customer",customer);
        Account account = new Account();
        account.setCustomer1(customer);
        model.addAttribute("accounts",account);

        return "non-teller/form/addAccount";
    }

    @RequestMapping(value = "/updateCustomerData/{id}")
    public String updateCustomersData(@PathVariable("id") String id, Model model){
        Customer retData = customerRepository.findById(id).get();
        model.addAttribute("customers", retData);
        return "non-teller/form/addCustomer";
    }

}
