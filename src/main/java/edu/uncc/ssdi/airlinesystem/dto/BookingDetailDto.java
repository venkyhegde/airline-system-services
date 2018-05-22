package edu.uncc.ssdi.airlinesystem.dto;

import java.sql.Date;

public class BookingDetailDto {

	/**
	 * @param userId
	 * @param itineraryId
	 * @param seatsBooked
	 * @param ticketCost
	 * @param dateOfBooking
	 * @param bookedSeats
	 * @param updatedSeats
	 */
	public BookingDetailDto(int userId, int itineraryId, int seatsBooked, double ticketCost, Date dateOfBooking,
			String bookedSeats, String updatedSeats) {
		super();
		this.userId = userId;
		this.itineraryId = itineraryId;
		this.seatsBooked = seatsBooked;
		this.ticketCost = ticketCost;
		this.dateOfBooking = dateOfBooking;
		this.bookedSeats = bookedSeats;
		this.updatedSeats = updatedSeats;
	}
	/**
	 * @param userId
	 * @param itineraryId
	 * @param seatsBooked
	 * @param ticketCost
	 * @param dateOfBooking
	 * @param bookedSeats
	 */
	public BookingDetailDto(int userId, int itineraryId, int seatsBooked, double ticketCost, Date dateOfBooking,
			String bookedSeats) {
		super();
		this.userId = userId;
		this.itineraryId = itineraryId;
		this.seatsBooked = seatsBooked;
		this.ticketCost = ticketCost;
		this.dateOfBooking = dateOfBooking;
		this.bookedSeats = bookedSeats;
	}
	/**
	 * 
	 */
	public BookingDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int userId;
	private int itineraryId;
	/**
	 * @return the updatedSeats
	 */
	public String getUpdatedSeats() {
		return updatedSeats;
	}
	/**
	 * @param updatedSeats the updatedSeats to set
	 */
	public void setUpdatedSeats(String updatedSeats) {
		this.updatedSeats = updatedSeats;
	}
	private int seatsBooked;
	private double ticketCost;
	private Date dateOfBooking;
	private String bookedSeats;
	private String updatedSeats;
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
	 * @return the seatsBooked
	 */
	public int getSeatsBooked() {
		return seatsBooked;
	}
	/**
	 * @param seatsBooked the seatsBooked to set
	 */
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	/**
	 * @return the ticketCost
	 */
	public double getTicketCost() {
		return ticketCost;
	}
	/**
	 * @param ticketCost the ticketCost to set
	 */
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	/**
	 * @return the dateOfBooking
	 */
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	/**
	 * @param dateOfBooking the dateOfBooking to set
	 */
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	/**
	 * @return the bookedSeats
	 */
	public String getBookedSeats() {
		return bookedSeats;
	}
	/**
	 * @param bookedSeats the bookedSeats to set
	 */
	public void setBookedSeats(String bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
}
