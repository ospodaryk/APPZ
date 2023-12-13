package com.project.appz.controller;

import com.project.appz.config.security.UserSecurityService;
import com.project.appz.models.dto.UserAuthDto;
import com.project.appz.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserSecurityService service;
    private final UserService userService;

    public AuthController(UserSecurityService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Retrieve CSRF token from HttpServletRequest
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

        if (csrfToken != null) {
            // Now you can include the CSRF token in the response body
            // TokenResponse is a hypothetical DTO that contains the CSRF token
            TokenResponse tokenResponse = new TokenResponse(csrfToken.getToken());
            if (auth == null) {
                return null;
            }
            Object principal = auth.getPrincipal();
            User user = (principal instanceof User) ? (User) principal : null;
            com.project.appz.models.entities.User usertmp = this.service.getByLogin(user.getUsername());
            UserAuthDto userAuthDto = UserAuthDto.builder()
                    .token(tokenResponse.getToken())
                    .profile(userService.findAll(usertmp.getEmail()))
                    .build();
            return ResponseEntity.ok(userAuthDto);
        }

        return ResponseEntity.status(401).body("Unauthorized");
    }

    // Hypothetical DTO for the token response
    public static class TokenResponse {
        private String csrfToken;

        public TokenResponse(String csrfToken) {
            this.csrfToken = csrfToken;
        }

        // Getter with correct name
        public String getToken() {
            return csrfToken;
        }

        // Setter
        public void setToken(String csrfToken) {
            this.csrfToken = csrfToken;
        }
    }
}
