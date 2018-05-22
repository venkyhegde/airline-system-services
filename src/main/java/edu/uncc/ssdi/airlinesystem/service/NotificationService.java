package edu.uncc.ssdi.airlinesystem.service;

import java.io.IOException;

import javax.mail.MessagingException;

import edu.uncc.ssdi.airlinesystem.util.Mail;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public interface NotificationService {

	void sendSimpleMessage(Mail mail) throws MessagingException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;

}