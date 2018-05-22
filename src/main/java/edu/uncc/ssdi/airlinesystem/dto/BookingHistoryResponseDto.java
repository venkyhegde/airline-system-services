/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.dto;

import java.sql.Date;

/**
 * @author venky
 *
 */
public class BookingHistoryResponseDto {
	
	private int bookingId;
	private int itineraryId;
	private Date dateOfBooking;
	private double totalCost;
	private int numberOfSeats;
	private String flightNumber;
	private String airlineName;
	private String airlineLogo;
	private int toId;
	private int fromId;
	/**
	 * @return the toId
	 */
	public int getToId() {
		return toId;
	}

	/**
	 * @param toId the toId to set
	 */
	public void setToId(int toId) {
		this.toId = toId;
	}

	/**
	 * @return the fromId
	 */
	public int getFromId() {
		return fromId;
	}

	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}

	/**
	 * 
	 */
	public BookingHistoryResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the dateOfBooking
	 */
	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	/**
	 * @param dateOfBooking
	 *            the dateOfBooking to set
	 */
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost
	 *            the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the numberOfSeats
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	/**
	 * @param numberOfSeats
	 *            the numberOfSeats to set
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * @param flightNumber
	 *            the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * @return the airlineName
	 */
	public String getAirlineName() {
		return airlineName;
	}

	/**
	 * @param airlineName
	 *            the airlineName to set
	 */
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	/**
	 * @return the airlineLogo
	 */
	public String getAirlineLogo() {
		return airlineLogo;
	}

	/**
	 * @param airlineLogo
	 *            the airlineLogo to set
	 */
	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}



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
	 * @return the itineraryId
	 */
	public int getItineraryId() {
		return itineraryId;
	}

	/**
	 * @param itineraryId the itineraryId to set
	 */
	public void setItineraryId(int itineraryId) {
		this.itineraryId = itineraryId;
	}

	/**
	 * @param bookingId
	 * @param itineraryId
	 * @param dateOfBooking
	 * @param totalCost
	 * @param numberOfSeats
	 * @param flightNumber
	 * @param airlineName
	 * @param airlineLogo
	 * @param toId
	 * @param fromId
	 */
	public BookingHistoryResponseDto(int bookingId, int itineraryId, Date dateOfBooking, double totalCost,
			int numberOfSeats, String flightNumber, String airlineName, String airlineLogo, int toId, int fromId) {
		super();
		this.bookingId = bookingId;
		this.itineraryId = itineraryId;
		this.dateOfBooking = dateOfBooking;
		this.totalCost = totalCost;
		this.numberOfSeats = numberOfSeats;
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.airlineLogo = airlineLogo;
		this.toId = toId;
		this.fromId = fromId;
	}



	
}
