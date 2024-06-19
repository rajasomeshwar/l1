package com.spring_mail.MailSenderPart.verfity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VertyController {
     @Autowired
    private VerfityService service;
	 @PostMapping("/verify")
	 public Boolean verifyByCode(@RequestBody VerifyDto verifyDetails )
	 {
		   
		 return service.check(verifyDetails.email(),verifyDetails.code());
	 }
	 @PostMapping("/resend")
	 public Boolean SentTodMail(@RequestBody Email email)
	 {
		  
		 return service.resendMail(email.email());
	 }
}
 record VerifyDto(String email, long code) {}