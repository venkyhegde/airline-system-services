package edu.uncc.ssdi.airlinesystem.dto;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author venky
 *
 */
public class ItineraryDetailsDto {

	/**
	 * @param id
	 * @param flightId
	 * @param ticketPrice
	 * @param date
	 * @param toTime
	 * @param fromTime
	 * @param sourceId
	 * @param destinationId
	 * @param flightNumber
	 */
	public ItineraryDetailsDto(int id, int flightId, String flightNumber,double ticketPrice, Date date, BigDecimal toTime,
			BigDecimal fromTime, int sourceId, int destinationId ) {
		super();
		this.id = id;
		this.flightId = flightId;
		this.ticketPrice = ticketPrice;
		this.date = date;
		this.toTime = toTime;
		this.fromTime = fromTime;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		FlightNumber = flightNumber;
	}
	
	public ItineraryDetailsDto() {
		super();
	}
	private int id;
	private int flightId;
	private double ticketPrice;
	private Date date;
	private BigDecimal toTime;
	private BigDecimal fromTime;
	private int sourceId;
	private int destinationId;
	private String FlightNumber;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the flightId
	 */
	public int getFlightId() {
		return flightId;
	}
	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return FlightNumber;
	}
	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		FlightNumber = flightNumber;
	}
	
	
	
}
