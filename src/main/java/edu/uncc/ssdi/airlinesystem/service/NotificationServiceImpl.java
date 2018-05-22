/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import edu.uncc.ssdi.airlinesystem.util.Mail;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * @author venky
 *
 */
@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Configuration freeMakerConfig;

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.NotificationService#sendSimpleMessage(edu.uncc.ssdi.airlinesystem.util.Mail)
	 */
	@Override
	public void sendSimpleMessage(Mail mail) throws MessagingException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
		Template template = freeMakerConfig.getTemplate("email-template.ftl");

		String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, mail.getModel());
		
		helper.setTo(mail.getMailTo());
		helper.setSubject(mail.getMailSubject());
		helper.setText(html, true);
		
		mailSender.send(message);
		
		mailSender.send(message);
		
	}
}
