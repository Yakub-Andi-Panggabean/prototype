package com.idemia.prototype.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.idemia.prototype.domain.User;

public class BasicAuthEncoder {


  public static String encodeBasicAuthentication(User user) throws UnsupportedEncodingException {

    final String base64 = Base64.getEncoder()
        .encodeToString(new String(user.getName() + "" + user.getPassword()).getBytes("UTF-8"));

    return base64;


  }



  public static String decodeBasicAuthentication(String auth) throws Exception {

    return new String(Base64.getDecoder().decode(auth));

  }

}
