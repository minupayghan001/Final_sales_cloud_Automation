package com.sca.utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.ITestResult;

public class EmailNotification {

	public void sendEmail(ITestResult finalResult) throws EmailException {
		Email em=new SimpleEmail();
			em.setHostName("smtp.gmail.com");
			em.setSmtpPort(587);
			em.setAuthenticator(new DefaultAuthenticator("avanti.joshi7@gmail.com","Swami@898"));
			em.setSSLOnConnect(true);
			em.setFrom("avanti.joshi7@gmail.com");
			em.setSubject("Email of test" + finalResult);
			em.setMsg("Check result");
			em.addTo("avanti.joshi7@gmail.com");
			em.send();
		
	}
	
}
