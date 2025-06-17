package com.huiminpay.merchant.service.impl;

import com.huiminpay.merchant.service.SmsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SmsServiceImpl implements SmsService {
    @Value("${sms.url}")
    private String sms_url;
    @Value("${sms.effectiveTime}")
    private String effectiveTime;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public String sendSms(String phone) {
        String url = sms_url + "/generate?name=sms&effectiveTime=" + effectiveTime;

        Map<String, Object> body = new HashMap<>();
        body.put("mobile", phone);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(body, headers);
        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
        Map responsMap = responseEntity.getBody();
        String key = null;
        if (responsMap != null && responsMap.get("result") != null) {
            Map result = (Map) responsMap.get("result");
            key = (String) result.get("key");
        } else {
            throw new RuntimeException("Query Exception");
        }
        return key;
    }
}