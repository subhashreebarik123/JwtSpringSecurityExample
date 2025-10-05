package com.JwtExample.Models;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtResponse{

    private String jwtToken;
    private String userName;

}