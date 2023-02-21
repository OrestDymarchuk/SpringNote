//package com.goit.app.mvc;
//
//import com.goit.app.user.UserEntity;
//import com.goit.app.user.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.view.RedirectView;
//
//@Controller
//@RequiredArgsConstructor
//public class RegistrationController {
//    private final UserService userService;
//
//    @GetMapping("/register")
//    public String showRegistrationForm() {
//        return "login/register";
//    }
//
//    @PostMapping("/register")
//    public RedirectView processRegistrationForm(@ModelAttribute UserEntity userEntity) {
//        userEntity.setUsername(userEntity.getUsername());
//        userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
//        userEntity.setRole("USER");
//        userService.createUser(userEntity);
//        return new RedirectView("/login");
//    }
//}
