package com.banking.Controller.list;

import com.banking.Model.Transaction;
import com.banking.Model.Users;
import com.banking.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/non-teller/dashboard")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/transaction/{id}")
    private String getTransactionPage(@PathVariable("id") String id, Model model) {
        Transaction transaction = transactionRepository.findById(id).get();
        return "non-teller/form/ProcessTransaction";
    }


}
