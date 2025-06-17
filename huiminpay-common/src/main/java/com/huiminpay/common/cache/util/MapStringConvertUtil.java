package com.huiminpay.common.cache.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStringConvertUtil {


    public static String getMapToString(Map<String, String> map) {
        Set<String> keySet = map.keySet();

        String[] keyArray = keySet.toArray(new String[keySet.size()]);

        Arrays.sort(keyArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {

            if (map.get(keyArray[i]).trim().length() > 0) {
                sb.append(keyArray[i]).append(":").append(map.get(keyArray[i]).trim());
            }
            if (i != keyArray.length - 1) {
                sb.append(",");
            }
        }
        String s = sb.toString();
        return s;
    }


    public static Map<String, String> getStringToMap(String str) {

        if (null == str || "".equals(str)) {
            return null;
        }

        String[] strings = str.split(",");

        int mapLength = strings.length;

        if ((strings.length % 2) != 0) {
            mapLength = mapLength + 1;
        }

        Map<String, String> map = new HashMap<>(mapLength);

        for (int i = 0; i < strings.length; i++) {

            String[] strArray = strings[i].split(":");
            //strArray[0]为KEY  strArray[1]为值
            map.put(strArray[0], strArray[1]);
        }
        return map;
    }

}
