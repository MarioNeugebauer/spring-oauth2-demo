package org.htwdresden.informatik.pkademo.springoauth2demo.restservice;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        // It’s not a great idea to return a whole OAuth2User in an endpoint since it might
        // contain information you would rather not reveal to a browser client.
        return Collections.singletonMap("login", principal.getAttribute("login"));
    }

}
