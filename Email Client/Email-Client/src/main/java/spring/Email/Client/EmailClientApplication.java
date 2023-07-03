package spring.Email.Client;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailClientApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(EmailClientApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		service.sendEmailWithAttachment("lavanya.kosana@imaginnovate.com",
				"This is Email Body with Attachment...",
				"This email has attachment",
				"/home/gnanesh/Pictures/pic.png");

	}

}
