package com.send.sms.sendsms.smsAuthController;

import com.send.sms.sendsms.service.SmsAuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/login")
public class SmsLoginAuthController {

    private SmsAuthService smsAuthService;

    public SmsLoginAuthController(SmsAuthService smsAuthService) {
        this.smsAuthService = smsAuthService;
    }
    @ApiOperation(value = "login to get token used for sending message")
    @GetMapping()
    public void login(){
        smsAuthService.authentication();
    }
    @ApiOperation(value = "update token used to send message")
    @GetMapping("/refresh")
    public void refreshToken(){
        smsAuthService.refreshToken();
    }
}
