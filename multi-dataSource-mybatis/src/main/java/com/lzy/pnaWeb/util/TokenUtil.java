package com.lzy.pnaWeb.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class TokenUtil {

    //sign is password

    public static String getToken(Long userId,String sign){
        return JWT.create().withAudience(String.valueOf(userId))
                .withExpiresAt(DateUtil.offsetHour(new Date(),2))// 2 hours
                .sign(Algorithm.HMAC256(sign));
    }

    public static DecodedJWT verify(String token,String sign) {
        return JWT.require(Algorithm.HMAC256(sign)).build().verify(token);
    }

    public static Map<String, Claim> getTokenInfo(String token,String sign) {
        return JWT.require(Algorithm.HMAC256(sign)).build().verify(token).getClaims();
    }
}
