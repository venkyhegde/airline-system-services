/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.dto;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author venky
 *
 */
public class ViewTicketDto {

	
	

	/**
	 * @param operator
	 * @param logo
	 * @param flightNumber
	 * @param dateOfJourney
	 * @param sourceId
	 * @param destinationId
	 * @param ticketPrice
	 * @param totalPrice
	 * @param numberOfSeats
	 * @param seats
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param toTime
	 * @param fromTime
	 * @param bookingId
	 */
	public ViewTicketDto(String operator, String logo, String flightNumber, Date dateOfJourney, int sourceId,
			int destinationId, double ticketPrice, double totalPrice, int numberOfSeats, String seats, String firstName,
			String lastName, String email, BigDecimal toTime, BigDecimal fromTime, int bookingId) {
		super();
		this.operator = operator;
		this.logo = logo;
		this.flightNumber = flightNumber;
		this.dateOfJourney = dateOfJourney;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		this.ticketPrice = ticketPrice;
		this.totalPrice = totalPrice;
		this.numberOfSeats = numberOfSeats;
		this.seats = seats;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.toTime = toTime;
		this.fromTime = fromTime;
		this.bookingId = bookingId;
	}
	/**
	 * 
	 */
	public ViewTicketDto() {
		
	}
	private String operator;
	private String logo;
	private String flightNumber;
	private Date dateOfJourney;
	private int sourceId;
	private int destinationId;
	private double ticketPrice;
	private double totalPrice;
	private int numberOfSeats;
	private String seats;
	private String firstName;
	private String lastName;
	private String email;
	private BigDecimal toTime;
	private BigDecimal fromTime;
	private int bookingId;
	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @return the toTime
	 */
	public BigDecimal getToTime() {
		return toTime;
	}
	/**
	 * @param toTime the toTime to set
	 */
	public void setToTime(BigDecimal toTime) {
		this.toTime = toTime;
	}
	/**
	 * @return the fromTime
	 */
	public BigDecimal getFromTime() {
		return fromTime;
	}
	/**
	 * @param fromTime the fromTime to set
	 */
	public void setFromTime(BigDecimal fromTime) {
		this.fromTime = fromTime;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	/**
	 * @return the dateOfJourney
	 */
	public Date getDateOfJourney() {
		return dateOfJourney;
	}
	/**
	 * @param dateOfJourney the dateOfJourney to set
	 */
	public void setDateOfJourney(Date date) {
		this.dateOfJourney = date;
	}
	/**
	 * @return the sourceId
	 */
	public int getSourceId() {
		return sourceId;
	}
	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	/**
	 * @return the destinationId
	 */
	public int getDestinationId() {
		return destinationId;
	}
	/**
	 * @param destinationId the destinationId to set
	 */
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}
	/**
	 * @return the ticketPrice
	 */
	public double getTicketPrice() {
		return ticketPrice;
	}
	/**
	 * @param ticketPrice the ticketPrice to set
	 */
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @return the numberOfSeats
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	/**
	 * @param numberOfSeats the numberOfSeats to set
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	/**
	 * @return the seats
	 */
	public String getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(String seats) {
		this.seats = seats;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
