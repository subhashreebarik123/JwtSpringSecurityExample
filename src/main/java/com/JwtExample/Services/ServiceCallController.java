package com.JwtExample.Services;

import com.JwtExample.Models.JwtResponse;
import com.JwtExample.Security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/call")
public class ServiceCallController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private ServiceBClient serviceBClient;
    @Autowired
    private JwtHelper jwtHelper;
    @GetMapping("/serviceB")

    public String callServiceB() {

        // 1️⃣ Prepare login request
        Map<String, String> loginRequest = new HashMap<>();
        loginRequest.put("email", "ServiceA");       // must match AppConfig username
        loginRequest.put("password", "ServiceSecret"); // must match AppConfig password

        // 2️⃣ Call Auth Service to get JWT
        ResponseEntity<JwtResponse> authResponse = restTemplate.postForEntity(
                "http://localhost:8080/auth/login",  // Auth Service URL
                loginRequest,
                JwtResponse.class
        );

        String jwtToken = authResponse.getBody().getJwtToken();
        System.out.println("Token received from Auth Service: " + jwtToken);

        // 3️⃣ Call Service B with this token
        return serviceBClient.callServiceB(jwtToken);
    }}