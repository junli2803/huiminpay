package com.huiminpay.common.cache.util;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    public static final String  SIGN_ALGORITHMS = "SHA1WithRSA";


    public static String sign(String content, String privateKey, String input_charset)
    {
        try
        {
            PKCS8EncodedKeySpec priPKCS8    = new PKCS8EncodedKeySpec( Base64.decode(privateKey) );
            KeyFactory keyf                 = KeyFactory.getInstance("RSA");
            PrivateKey priKey               = keyf.generatePrivate(priPKCS8);

            Signature signature = Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update( content.getBytes(input_charset) );

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public static boolean verify(String content, String sign, String public_key, String input_charset)
    {
        try
        {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(public_key);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            Signature signature = Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update( content.getBytes(input_charset) );

            boolean bverify = signature.verify( Base64.decode(sign) );
            return bverify;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public static String decrypt(String content, String private_key, String input_charset) throws Exception {
        PrivateKey prikey = getPrivateKey(private_key);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, prikey);

        InputStream ins = new ByteArrayInputStream(Base64.decode(content));
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        byte[] buf = new byte[128];
        int bufl;

        while ((bufl = ins.read(buf)) != -1) {
            byte[] block = null;

            if (buf.length == bufl) {
                block = buf;
            } else {
                block = new byte[bufl];
                for (int i = 0; i < bufl; i++) {
                    block[i] = buf[i];
                }
            }

            writer.write(cipher.doFinal(block));
        }

        return new String(writer.toByteArray(), input_charset);
    }

    public static PrivateKey getPrivateKey(String key) throws Exception {

        byte[] keyBytes;

        keyBytes = Base64.decode(key);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        return privateKey;
    }



    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        KeyPair keyPair = keyGen.generateKeyPair();
        return keyPair;
    }

    public static final String depository_publicKey ="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJKcP4TjCb9+OKf0uvHkDO6njI8b9KKlu3ZdCkom4SONf8KkZ1jVl6A7XWnJ33gBLnbTGVUm5I+XvFEG5bSWVbkCAwEAAQ==";

    public static final String depository_privateKey ="MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAkpw/hOMJv344p/S68eQM7qeMjxv0oqW7dl0KSibhI41/wqRnWNWXoDtdacnfeAEudtMZVSbkj5e8UQbltJZVuQIDAQABAkBrkkVw5X0DikNbyM9aKG/ss/cIEgT/SgcwI7gnDDvo7wntxxPuVZ7P+gkhFqb1ByCLdH/GlsXEZW88HCA9M2ZhAiEA65BsW0uGPhnVRS7hJhLZpuuugKVNyJBBO6jGATe0g/UCIQCfVEZ0bvYd5pA165XwXs7ZFGU99rG410EEh7JRxzx0NQIgdNL9ShGck/PP1y22r2Et3CCKPHa+qrcQAvxipnvv5HkCIBITUoblC8DqplOnrXP+nYLdIHs+IH1y1ip4Zo+GheI9AiBdsG0ql4Unbt1ctYm6XdmqE5rdFD+iDFQRS1FFmUVNUQ==";

    public static final String p2p_publicKey ="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKZKjaBEvudPDolCyuVCBLmfVsSFBu3wfdldLxItRcjSYMzHNoIuYcvHhnMmMi1iXRLeYdbwvI3JQoBHDGN5ad0CAwEAAQ==";

    public static final String p2p_privateKey ="MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEApkqNoES+508OiULK5UIEuZ9WxIUG7fB92V0vEi1FyNJgzMc2gi5hy8eGcyYyLWJdEt5h1vC8jclCgEcMY3lp3QIDAQABAkAUhQia6UDBXEEH8QUGazIYEbBsSZoETHPLGbOQQ6Pj1tb6CVC57kioBjwtNBnY2jBDWi5K815LnOBcJSSjJPwhAiEA2eO6VZMTkdjQAkpB5dhy/0C3i8zs0c0M1rPoTA/RpkUCIQDDYHJPqHLkQyd//7sEeYcm8cMBTvDKBXyiuGk8eLRauQIgQo6IlalGmg+Dgp+SP5Z9kjD/oCmp0XB0UoVEGS/f140CIQCsG9YXHgi31ACD3T9eHcBVKjvidyveix7UKSdrQdl+4QIgNCtRVLV+783e7PX5hRXD+knsWTQxDEMEsHi1KsAWtPk=";



    public static void main(String [] args) throws Exception{


       String content = "加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890加密原文1234567890";

        System.out.println("-----------------P2P sends data to depository--------------------- ");
        String signature = RSAUtil.sign(content, p2p_privateKey, "utf-8");
        System.out.println("Signature generated, original content: " + content);
        if (RSAUtil.verify(content, signature, p2p_publicKey, "utf-8")) {
            System.out.println("Signature verification successful: " + signature);
        } else {
            System.out.println("Signature verification failed!");
        }

        System.out.println("-----------------Depository returns data to P2P--------------------- ");
        String signature1 = RSAUtil.sign(content, depository_privateKey, "utf-8");
        System.out.println("Signature generated, original content: " + content);
        if (RSAUtil.verify(content, signature1, depository_publicKey, "utf-8")) {
            System.out.println("Signature verification successful: " + signature1);
        } else {
            System.out.println("Signature verification failed!");
        }






    }


}
