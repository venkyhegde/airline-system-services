/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.util;

import java.util.Map;

/**
 * @author venky
 *
 */
public class Mail {

	private String mailTo;
	private String mailSubject;
    private String mailContent;
    private Map < String, String > model;
	/**
	 * @return the mailTo
	 */
	public String getMailTo() {
		return mailTo;
	}
	/**
	 * @param mailTo the mailTo to set
	 */
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	/**
	 * @return the mailSubject
	 */
	public String getMailSubject() {
		return mailSubject;
	}
	/**
	 * @param mailSubject the mailSubject to set
	 */
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	/**
	 * @return the mailContent
	 */
	public String getMailContent() {
		return mailContent;
	}
	/**
	 * @param mailContent the mailContent to set
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	/**
	 * @return the model
	 */
	public Map<String, String> getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(Map<String, String> model) {
		this.model = model;
	}
    
}
