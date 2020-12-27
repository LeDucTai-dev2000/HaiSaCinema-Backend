package com.Services;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import org.springframework.stereotype.Service;
import com.Entity.Ticket;

@Service
public interface EmailService {

	/**
	 * Send email with sender, receiver, content, attachments
	 * 
	 * @return void
	 */
	void sendMail(String to, String subject, String text, Multipart mp) throws Exception;

	/**
	 * The attachments can be send with function sendMail
	 * 
	 * @return Multipart
	 */
	Multipart setTextTicket(Ticket ticket, String filePath) throws IOException, MessagingException;
}