package com.huiminpay.common.cache.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

public class EncryptUtil {
    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    public static String encodeBase64(byte[] bytes){
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
    }

    public static byte[]  decodeBase64(String str){
        byte[] bytes = null;
        bytes = Base64.getDecoder().decode(str);
        return bytes;
    }

    public static String encodeUTF8StringBase64(String str){
        String encoded = null;
        try {
            encoded = URLEncoder.encode(str, "utf-8");
            encoded = Base64.getEncoder().encodeToString(encoded.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.warn("Unsupported encoding formats",e);
        }
        return encoded;

    }


    public static String  decodeUTF8StringBase64(String str){
        String decoded = null;
        byte[] bytes = Base64.getDecoder().decode(str);

        try {
            decoded = new String(bytes,"utf-8");
            decoded = URLDecoder.decode(decoded, "utf-8");
        }catch(UnsupportedEncodingException e){
            logger.warn("Unsupported encoding formats",e);
        }
        return decoded;
    }


    public static void main(String [] args){
        String str = "www.baidu.com?a=1&b=2+1&c=dfdasaf+%&&d=1";
        String encoded = EncryptUtil.encodeUTF8StringBase64(str);
        String decoded = EncryptUtil.decodeUTF8StringBase64(encoded);
        System.out.println(str);
        System.out.println(encoded);
        System.out.println(decoded);

    }


}
