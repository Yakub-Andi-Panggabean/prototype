package com.idemia.prototype.service.bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.function.Consumer;

import javax.crypto.SecretKey;

import com.idemia.prototype.domain.User;
import com.idemia.prototype.exception.ApplicationException;
import com.idemia.prototype.service.TokenService;
import com.idemia.prototype.util.Errors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

public class TokenServiceBean implements TokenService {

  private static final String ISSUER = "prototype-api";

  final static SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  @Override
  public void generateToken(User user, Consumer<String> token, Consumer<Exception> err) {

    try {

      final LocalDateTime createdAt = LocalDateTime.now();
      final LocalDateTime expiredAt = createdAt.plusHours(6);

      final String generatedToken =
          Jwts.builder().setIssuer(ISSUER).setSubject(String.valueOf(user.getId()))
              .claim("username", user.getName()).claim("country", user.getCountry())
              .setIssuedAt(Date.from(createdAt.toInstant(ZoneOffset.UTC)))
              .setExpiration(Date.from(expiredAt.toInstant(ZoneOffset.UTC)))
              .signWith(key, SignatureAlgorithm.HS256).compact();

      token.accept(generatedToken);

    } catch (final Exception ex) {

      err.accept(ex);

    }

  }


  @Override
  public void parseToken(String token, Consumer<Claims> isValid,
      Consumer<ApplicationException> err) {

    try {

      final String encodedKey = Encoders.BASE64.encode(key.getEncoded());

      final Jws<Claims> jws =
          Jwts.parser().setSigningKey(Decoders.BASE64.decode(encodedKey)).parseClaimsJws(token);

      final LocalDateTime expirationDate = jws.getBody().getExpiration().toInstant()
          .atZone(ZoneId.systemDefault()).toLocalDateTime();

      final LocalDateTime notBeforeDate = jws.getBody().getExpiration().toInstant()
          .atZone(ZoneId.systemDefault()).toLocalDateTime();

      if (LocalDateTime.now().isAfter(expirationDate)) {

        err.accept(new ApplicationException(Errors.EXPIRED_TOKEN_ERROR));

      }

      isValid.accept(jws.getBody());

    } catch (final Exception ex) {

      err.accept(new ApplicationException(ex));

    }

  }

}
