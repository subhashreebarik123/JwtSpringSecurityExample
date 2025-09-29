package com.JwtExample.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtRequest {

    private String Email;
    private  String Password;
}

