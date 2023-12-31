package com.ghulam.microchat.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoints.base-url}")
@CrossOrigin("*")
public class DemoController {

    @GetMapping("/public")
    public String forPublic() {
        return "This endpoint can be accessed by EVERYONE.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String forUser() {
        return "This endpoint can be accessed by ONLY USER.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String forAdmin() {
        return "This endpoint can be accessed by ONLY ADMIN.";
    }

}
