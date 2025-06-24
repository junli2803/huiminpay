package com.huiminpay.merchant.service.impl;

import com.huiminpay.merchant.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

// Indicates that this class is a Spring-managed service component
@Service
public class SmsServiceImpl implements SmsService {

    // Injects a RestTemplate bean for sending HTTP requests
    @Autowired
    RestTemplate restTemplate;

    // Reads the SMS service base URL from the application properties file (e.g., application.yml or application.properties)
    @Value("${sms.url}")
    String sms_url;

    // Reads the effective time (validity period) for the verification code from the application properties
    @Value("${sms.effectiveTime}")
    String effectiveTime;

    // Implements the method to create a verification code by sending a request to the SMS service
    @Override
    public String createVerifizierungsCode(String phone) {
        // Constructs the complete URL for the "generate" endpoint with query parameters
        String url = sms_url + "/generate?name=sms&effectiveTime=" + effectiveTime;

        // Prepares the body of the POST request as a JSON object
        Map<String, Object> body = new HashMap<>();
        body.put("mobile", phone); // adds the phone number to the request body

        // Sets the content type of the request to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Combines headers and body into a single HTTP entity
        HttpEntity entity = new HttpEntity(body, headers);

        // Sends the POST request to the SMS service and expects a response of type Map
        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        // Retrieves the response body
        Map entityBody = responseEntity.getBody();
        String key = null;

        // Checks whether the response body and its 'result' field are present
        if (entityBody != null && entityBody.get("result") != null) {
            // Extracts the 'result' map from the response body
            Map result = (Map) entityBody.get("result");

            // Gets the verification code 'key' from the result and converts it to string
            key = result.get("key").toString();
        } else {
            // Throws an exception if the response does not contain the expected data
            throw new RuntimeException("Query Exception");
        }

        // Returns the verification key to the caller
        return key;
    }





}
