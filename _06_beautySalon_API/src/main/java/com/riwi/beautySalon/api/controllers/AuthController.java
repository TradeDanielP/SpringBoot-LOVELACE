package com.riwi.beautySalon.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.beautySalon.api.dto.request.RegisterRequest;
import com.riwi.beautySalon.api.dto.response.AuthResponse;
import com.riwi.beautySalon.infraestructure.services.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;
    
    @PostMapping(path = "/auth/login")
    public String login(){
        return "DESDE LOGIN";
    }

    @PostMapping(path = "/auth/register")
    public ResponseEntity<AuthResponse> register(
        @Validated @RequestBody RegisterRequest request){
            return ResponseEntity.ok(this.authService.register(request));
    }

    



}
