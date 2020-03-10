package com.banking.Controller.list;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/non-teller")
public class NonTellerDashboardController {
    @GetMapping("/dashboard")
    private String getDashboard(Model model) {
        return "non-teller/index";
    }
}
