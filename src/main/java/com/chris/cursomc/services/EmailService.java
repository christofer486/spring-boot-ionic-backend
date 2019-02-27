package com.chris.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.chris.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
