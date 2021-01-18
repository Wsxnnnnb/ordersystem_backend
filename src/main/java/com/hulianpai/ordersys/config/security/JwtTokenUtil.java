package com.hulianpai.ordersys.config.security;

import com.hulianpai.ordersys.config.AudienceConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created with ordersys.
 * Date: 2020/12/19.
 * Time: 10:04 下午.
 *
 */
public class JwtTokenUtil {
    private final AudienceConfig audienceConfig;

    public JwtTokenUtil(AudienceConfig audienceConfig) {
        this.audienceConfig = audienceConfig;
    }

    /**
     * 从Token中获取用户名
     *
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }


    /**
     * 获取Token的过期时间
     *
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * 按类型获取声明
     *
     * @param token
     * @param claimsResolver
     * @param <T>
     * @return
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * 获取声明
     *
     * @param token
     * @return
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(audienceConfig.getBase64Secret()).parseClaimsJws(token).getBody();
    }

    /**
     * 检查Token过期
     *
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 生成Token
     *
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        return doGenerateToken(new HashMap<>(), userDetails.getUsername());
    }

    /**
     * 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID<br/>
     * 2. Sign the JWT using the HS512 algorithm and secret key.<br/>
     * 3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1) compaction of the JWT to a URL-safe string<br/>
     *
     * @param claims
     * @param subject
     * @return
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(audienceConfig.getExpiresSecond())))
                .signWith(SignatureAlgorithm.HS512, audienceConfig.getBase64Secret()).compact();
    }

    /**
     * 验证Token
     *
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
