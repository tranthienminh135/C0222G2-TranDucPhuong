package com.coffee.controller.simple_email;

import com.coffee.model.account.AppUser;
import com.coffee.model.jwt.JwtRequest;
import com.coffee.model.jwt.JwtResponse;
import com.coffee.service.impl.IAppUserService;
import com.coffee.util.EncrytedPasswordUtils;
import com.coffee.util.JwtTokenUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
public class SimpleEmailController {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private EncrytedPasswordUtils encrytedPasswordUtils;

    @Value("${spring.mail.username}")
    private String myEmail;

    private String token;

    @PostMapping("/sendSimpleEmail")
    public ResponseEntity<?> sendSimpleEmail(@RequestBody JwtRequest jwtRequest) {
        AppUser appUser = this.appUserService.findAppUserByUsername(jwtRequest.getUsername());
        if (appUser != null) {
            // Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(this.myEmail);
            message.setTo(appUser.getEmployee().getEmail());
            message.setSubject("Test Simple Email");
            this.token = jwtTokenUtil.generateToken(jwtRequest.getUsername());
            message.setText("http://localhost:8080/forgotPassword/" + this.token);

            // Send Message!
            this.emailSender.send(message);
            return ResponseEntity.ok(new JwtResponse(this.token));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/forgotPassword/{token}")
    public ResponseEntity<?> getUsernameForChangePassword(@PathVariable String token, HttpServletResponse response) throws IOException {
        if (this.token == null) {
            this.token = "";
        }
        if (this.token.equals(token)) {
            response.sendRedirect("http://localhost:4200/forgot/" + token);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        response.sendRedirect("http://localhost:4200/login");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody JwtRequest jwtRequest) {
        if (this.token.equals(jwtRequest.getToken())) {
            AppUser appUser = this.appUserService.findAppUserByUsername(jwtTokenUtil.getUsernameFromToken(jwtRequest.getToken()));
            appUser.setPassword(encrytedPasswordUtils.encrytePassword(jwtRequest.getPassword()));
            this.appUserService.save(appUser);
            this.token = "";
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
