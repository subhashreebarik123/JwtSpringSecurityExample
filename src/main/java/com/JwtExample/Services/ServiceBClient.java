package com.JwtExample.Services;

import com.JwtExample.Security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceBClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtHelper jwtHelper;

    public String callServiceB(String jwtToken) {
        // Generate JWT for service account
        UserDetails serviceUser = org.springframework.security.core.userdetails.User
                .withUsername("ServiceA")
                .password("ServiceSecret")
                .roles("SERVICE")
                .build();

        String token = jwtHelper.generateToken(serviceUser);
        System.out.println("JWT Token: " + token); // debug

        // Set header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8081/home/users",
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}