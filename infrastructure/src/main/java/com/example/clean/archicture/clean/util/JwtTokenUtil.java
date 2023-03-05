package com.example.clean.archicture.clean.util;

import com.example.clean.archicture.clean.dto.ClientDTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {
    public static String addToken(ClientDTO clientDTO) {
        String sign = "4^:s]6E5VMA3{ozdY@*";
        long EXPIRATION_DATE = 28_800_000;
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("user", clientDTO);
        return JWT.create()
                .withSubject(clientDTO.getFullName())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
                .sign(Algorithm.HMAC256(sign));
    }
}
