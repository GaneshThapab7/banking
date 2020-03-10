package com.banking.Controller.list;

import com.banking.Model.users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminDashboardController {
    @GetMapping(value = "/dashboard")
    private String getDashboard(Model model) {
        return "admin/index";
    }
}
