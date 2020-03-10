package com.banking.Controller.form;

import com.banking.Model.Branches;
import com.banking.Model.Number_Generator;
import com.banking.Model.Users;
import com.banking.Repository.BranchesRepository;
import com.banking.Repository.Interface.ServicesInterface;
import com.banking.Repository.Number_GeneratorRepository;
import com.banking.Repository.UserRepository;
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
@RequestMapping("/admin/dashboard")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BranchesRepository branchesRepository;

    @Autowired
    private Number_GeneratorRepository number_generatorRepository;

    @Autowired
    private ServicesInterface servicesInterface;

    @GetMapping(value = "/addUserForm")
    private String getUserForm(Model model) {
        List<Branches> allBranches= branchesRepository.findAll();
        model.addAttribute("allBranches", allBranches);

        List<Users> users= userRepository.findAll();
        model.addAttribute("users", new Users());
        Number_Generator number_generator= number_generatorRepository.findById(1).get();
        model.addAttribute("documentNumbering", number_generator);
        return "admin/form/addUser";
    }

    @GetMapping(value = "/userList")
    private String getUserList(Model model) {
        List<Users> users= userRepository.UnArchivedUsers();
        model.addAttribute("users", users);
        return "admin/table/userTable";
    }
    @GetMapping(value = "/archivedUserList")
    private String getArchivedUserList(Model model) {
        List<Users> users= userRepository.ArchivedUser();
        model.addAttribute("users", users);
        return "admin/table/userTable";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                byte[].class,
                new ByteArrayMultipartFileEditor());
    }

    @PostMapping(value = "/addUser")
    private String addUser(@RequestParam("photo") MultipartFile photo, Model model, @Valid Users user, BindingResult bindingResult)  {

        if (photo.isEmpty() == false){
            String photo_name = user.getEmp_code()+user.getFirst_name()+"."+photo.getOriginalFilename().split("\\.")[1];
            System.out.println(photo_name);
        try {
            servicesInterface.uploadImage(photo,photo_name,"users");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error while uploading");
        }
        user.setPhoto(photo_name);
        }
        else {
            try {
                Users users = userRepository.findById(user.getEmp_code()).get();
                    user.setPhoto(users.getPhoto());
            }
            catch (Exception e){

            }
        }
        user.setArchived(false);
        user.setUsername(user.getFirst_name()+'.'+user.getLast_name());
        String firstname = user.getFirst_name();
        int index = firstname.indexOf(firstname);
        String lastname = user.getLast_name();
        user.setPassword(firstname.substring(0,firstname.indexOf(firstname)-2)+'#'+lastname.substring(0,1)+'@');
        userRepository.save(user);
        //      ++++++  For updating Document numbering +++++++
        Number_Generator no1 = number_generatorRepository.findById(1).get();

        no1.setStartingPrefixNo(no1.getStartingPrefixNo()+1);

        int prefixAmt = no1.getPrefixNo();
        int prefixStartingNum = no1.getStartingPrefixNo();
        String prefixStr = String.format("%0" + prefixAmt + "d", prefixStartingNum);

        String display = no1.getPrefixWord()+"-"+prefixStr;
        no1.setDisplayNo(display);

        number_generatorRepository.save(no1);

        model.addAttribute("success","           User has been Updated Successfully              ");
        model.addAttribute("num", number_generatorRepository.findById(1).get().getDisplayNo());
        List<Users> users= userRepository.findAll();
        model.addAttribute("users", users);
        return "admin/table/userTable";
    }

    @RequestMapping(value = "/updateUserData/{id}")
    public String updateUsersData(@PathVariable("id") String id, Model model){
        Users retData = userRepository.findById(id).get();
        System.out.println(retData.getPhoto());
        model.addAttribute("del",true);
        model.addAttribute("users", retData);
        return "admin/form/addUser";
    }
    @RequestMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") String emp_code,Model model){
        Users ret_data = userRepository.findById(emp_code).get();
        try {
            userRepository.delete(ret_data);
        }
        catch (Exception e){
            System.out.println("User cannot be deleted");
        }
        model.addAttribute("users",userRepository.UnArchivedUsers());
        return "admin/table/userTable";

    }

}
