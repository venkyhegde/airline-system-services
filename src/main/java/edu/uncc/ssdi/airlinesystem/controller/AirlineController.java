package edu.uncc.ssdi.airlinesystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssdi.uncc.edu.airlinesystemschema.BookingConfirmationRequest;
import ssdi.uncc.edu.airlinesystemschema.BookingHistoryResponse;
import ssdi.uncc.edu.airlinesystemschema.FlightSearchRequest;
import ssdi.uncc.edu.airlinesystemschema.FlightSearchResponse;
import ssdi.uncc.edu.airlinesystemschema.GetCityResponse;
import ssdi.uncc.edu.airlinesystemschema.GetSeatResponse;
import ssdi.uncc.edu.airlinesystemschema.LoginRequest;
import ssdi.uncc.edu.airlinesystemschema.LoginResponse;
import ssdi.uncc.edu.airlinesystemschema.RegistrationRequest;
import ssdi.uncc.edu.airlinesystemschema.RegistrationResponse;
import ssdi.uncc.edu.airlinesystemschema.ViewTicketResponse;

public interface AirlineController {

	/**
	 * 
	 * @return
	 */
	String testService();

	/**
	 * Registration Service
	 * 
	 * @param RegistrationRequest
	 *            request
	 * @return RegistrationResponse response
	 */
	RegistrationResponse registerUser(RegistrationRequest regRequest);

	LoginResponse userLogin(LoginRequest loginRequest);

	/**
	 * Get City service
	 * @return
	 */
	GetCityResponse getCityList();

	/**
	 * 
	 * @param flightSearchRequest
	 * @return flightSearchResponse
	 */
	FlightSearchResponse searchFlight(FlightSearchRequest flightSearchRequest);

	/**
	 * Service to get seat layout for a flight
	 * @param id
	 * @return List<Boolean>
	 */
	GetSeatResponse getSeatsByFlightId(int itineraryId);

	/**
	 * Get booking history for a user
	 * @param userId
	 * @return bookingHistoryResponse
	 */
	BookingHistoryResponse getBookingHistory(int userId);

	/**
	 * View Ticket
	 * @param bookingId
	 * @return
	 */
	ViewTicketResponse ViewTicket(int bookingId);

	ViewTicketResponse bookingConfirmation(BookingConfirmationRequest bookingConfirmationRequest);

}