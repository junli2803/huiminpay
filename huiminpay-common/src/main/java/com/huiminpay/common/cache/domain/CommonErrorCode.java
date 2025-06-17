package com.huiminpay.common.cache.domain;


import sun.management.resources.agent;

/**
 * 异常编码
 */
public enum CommonErrorCode implements ErrorCode {

    //PUBLIC EXCEPTION CODE
    E_100101(100101, "Input parameters do not match the interface"),
    E_100102(100102, "Verification code error"),
    E_100103(100103, "Verification code is empty"),
    E_100104(100104, "Query result is empty"),
    E_100105(100105, "ID format is incorrect or exceeds Long range"),
    E_100106(100106, "Upload error"),
    E_100107(100107, "Failed to send verification code"),
    E_100108(100108, "Input object is null"),
    E_100109(100109, "Invalid phone number format"),
    E_100110(100110, "Username is empty"),
    E_100111(100111, "Password is empty"),
    E_100112(100112, "Phone number is empty"),
    E_100113(100113, "Phone number already exists"),
    E_100114(100114, "Username already exists"),
    E_100115(100115, "Incorrect password"),


    //SAAS Service Exception Coding 110
    E_110001(110001, "Account does not exist"),
    E_110002(110002, "Role code already exists in the same tenant, cannot be duplicated"),
    E_110003(110003, "Role is empty"),
    E_110004(110004, "Role is bound to an account and cannot be deleted"),
    E_110005(110005, "Permission set is empty"),
    E_110006(110006, "Parameter is empty"),
    E_110007(110007, "No role associated with the tenant found"),
    E_110008(110008, "Account is used by another tenant and cannot be deleted"),


    //Merchant service exception code 200
    E_200001(200001, "Company name cannot be empty"),
    E_200002(200002, "Merchant does not exist"),
    E_200003(200003, "Merchant not yet approved, cannot create application"),
    E_200004(200004, "Application name already exists, please use another"),
    E_200005(200005, "Application does not belong to the current merchant"),
    E_200006(200006, "Store does not belong to the current merchant"),
    E_200007(200007, "QR code generation failed"),
    E_200008(200008, "Authorization code is empty"),
    E_200009(200009, "Order title is empty"),
    E_200010(200010, "Order amount is empty"),
    E_200011(200011, "Authorization code format is incorrect"),
    E_200012(200012, "Tenant does not exist"),
    E_200013(200013, "Employee does not exist"),
    E_200014(200014, "No root store set under merchant"),
    E_200015(200015, "Store not found"),
    E_200016(200016, "Qualification already approved, no need to reapply"),
    E_200017(200017, "Merchant already registered under current tenant"),


    //Transaction service exception code 300
    E_300001(300001, "Payment amount is empty"),
    E_300002(300002, "openId is empty"),
    E_300003(300003, "appId is empty"),
    E_300004(300004, "Merchant ID is empty"),
    E_300005(300005, "Service type code is empty"),
    E_300006(300006, "Order amount conversion error"),
    E_300007(300007, "Original payment channel is empty"),
    E_300008(300008, "Same payment parameter already exists, cannot be duplicated"),
    E_300009(300009, "Input object is null or lacks required parameters"),
    E_300010(300010, "Application not bound to service type, parameter configuration not allowed"),

    E_300110(300110, "Transaction number cannot be empty"),


    //Payment channel agent service exception code 400
    E_400001(400001, "WeChat payment confirmation failed"),
    E_400002(400002, "Alipay payment confirmation failed"),


    //Special Exception Code
    E_999991(999991, "Microservice call - Authorization service has been circuit broken"),
    E_999992(999992, "Microservice call - User service has been circuit broken"),
    E_999993(999993, "Microservice call - Resource service has been circuit broken"),
    E_999994(999994, "Microservice call - Sync service has been circuit broken"),

    E_999910(999910, "Microservice call - tenantId not provided"),
    E_999911(999911, "Microservice call - json-token not provided"),
    E_999912(999912, "Microservice call - json-token parsing error"),
    E_999913(999913, "Microservice call - json-token invalid - no current tenant info"),
    E_999914(999914, "Microservice call - json-token invalid - no permission info under tenant"),

    E_NO_AUTHORITY(999997, "No access permission"),
    CUSTOM(999998, "Custom exception"),
    UNKNOWN(999999, "Unknown error");


    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private CommonErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static CommonErrorCode setErrorCode(int code) {
        for (CommonErrorCode errorCode : CommonErrorCode.values()) {
            if (errorCode.getCode() == code) {
                return errorCode;
            }
        }
        return null;
    }
}
