package edu.uncc.ssdi.airlinesystem.service;

import edu.uncc.ssdi.airlinesystem.exception.AirlineException;
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

public interface AirlineService {

	RegistrationResponse addUser(RegistrationRequest request);

	/**
	 * 
	 * @param loginRequest
	 * @return
	 */
	LoginResponse userLogin(LoginRequest loginRequest);

	/**
	 * Get city list
	 * 
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
	 * service to get seats as array
	 * 
	 * @param id
	 * @return
	 */
	GetSeatResponse getSeatsByFlights(int id);

	/**
	 * 
	 * @param userId
	 * @return bookingHistoryResponse
	 */
	BookingHistoryResponse getBookingHistory(int userId);

	/**
	 * 
	 *
	 * @param bookingId
	 * @return
	 */
	ViewTicketResponse viewTicket(int bookingId);

	void sendMail(ViewTicketResponse viewTicketResponse) throws AirlineException;

	/**
	 * 
	 * @param bookingConfirmationRequest
	 * @return
	 */
	ViewTicketResponse bookingConfirmation(BookingConfirmationRequest bookingConfirmationRequest);

}