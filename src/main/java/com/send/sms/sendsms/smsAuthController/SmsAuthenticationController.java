package com.send.sms.sendsms.smsAuthController;

import com.send.sms.sendsms.Model.SmsAuthentication;
import com.send.sms.sendsms.service.SmsAuthenticationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sms/auth")

public class SmsAuthenticationController {

    private SmsAuthenticationService smsAuthenticationService;

    public SmsAuthenticationController(SmsAuthenticationService smsAuthenticationService) {
        this.smsAuthenticationService = smsAuthenticationService;
    }
    @ApiOperation(value="all users of of sms authentication")
    @GetMapping()
    public List<SmsAuthentication> getAllLogins(){
        return smsAuthenticationService.allLogins();
    }
    @ApiOperation(value="create user of sms authentication")
    @PostMapping()
    public ResponseEntity<SmsAuthentication> createSmsAuth(@RequestBody SmsAuthentication smsAuthentication){
                return new ResponseEntity<SmsAuthentication>(smsAuthenticationService.createSmsAuth(smsAuthentication), HttpStatus.CREATED);
    }
    @ApiOperation(value="update specific user of sms authentication")
    @PutMapping("/{id}")
    public ResponseEntity<SmsAuthentication> updateSmsAuth(@RequestBody SmsAuthentication smsAuthentication, @PathVariable("id") int id){
        return new ResponseEntity<SmsAuthentication>(smsAuthenticationService.update(smsAuthentication,id),HttpStatus.OK);
    }
    @ApiOperation(value="delete specific user of sms authentication")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") int id){
        smsAuthenticationService.deleteSmsAuth(id);
        return new ResponseEntity<String>("SmsAuth deletion succesfully!!!",HttpStatus.OK);
    }
}
