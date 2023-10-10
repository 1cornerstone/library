package com.akindev.library.controller;


import com.akindev.library.service.implementation.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private AuthServiceImpl authService;




}
