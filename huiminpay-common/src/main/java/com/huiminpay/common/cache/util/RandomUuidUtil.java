package com.huiminpay.common.cache.util;

import java.util.UUID;

public class RandomUuidUtil {

    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

}
