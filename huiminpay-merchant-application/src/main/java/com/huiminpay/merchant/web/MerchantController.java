package com.huiminpay.merchant.web;

import com.huiminpay.merchant.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {
    @Autowired
    SmsService smsService;

    @GetMapping("/sms")
    public String getMsgCode(@RequestParam String phone) {

        return smsService.createVerifizierungsCode(phone);
    }
}



























//package com.huiminpay.merchant.web;
//
//import com.huiminpay.merchant.api.IMerchantService;
//import com.huiminpay.merchant.dto.MerchantDTO;
//import com.huiminpay.merchant.service.SmsService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.apache.dubbo.config.annotation.Reference;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//
//@Api(value = "/user")
//@RestController
//public class MerchantController {
//    @Reference
//    IMerchantService merchantService;
//    @Autowired
//    SmsService smsService;
//
//    @ApiParam(name = "id", value = "Merchant id", required = true)
//    @ApiOperation(value = "merchants/id")
//    @GetMapping("/merchants/{id}")
//    public MerchantDTO getDto(@PathVariable("id") Long id) {
//
//        MerchantDTO merchantDTO = merchantService.queryMerchantById(id);
//        return merchantDTO;
//    }
//
//    @GetMapping("/sms")
//    public String getMsgCode(@RequestParam String phone) {
//        return smsService.sendSms(phone);
//    }
//
//
//}
