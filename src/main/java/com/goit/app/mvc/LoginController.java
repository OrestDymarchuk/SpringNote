package com.goit.app.mvc;

import com.goit.app.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationManager authenticationManager;
    @GetMapping("/login")
    public String showLoginForm() {
        return "login/login";
    }

    @PostMapping("/login")
    public RedirectView processLogin(@ModelAttribute UserEntity userEntity) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/");
    }
}
