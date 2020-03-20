package com.example.security.securitydbexample.Controller;

import com.example.security.securitydbexample.models.User;
import com.example.security.securitydbexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/all")
    public String allAccess(){
        return "Public Content";
    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public String userAccess(){
        return "User Content";
    }


//    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String adminAccess(){
//        return "Admin Board";
//    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String printUser(ModelMap model){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String name=auth.getName();

        model.addAttribute("username",name);
        return "Hi My username is  "+name;
    }

}
