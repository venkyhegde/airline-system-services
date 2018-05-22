package edu.uncc.ssdi.airlinesystem.repository;

import java.util.List;

import edu.uncc.ssdi.airlinesystem.dto.BookingDetailDto;
import edu.uncc.ssdi.airlinesystem.dto.BookingHistoryResponseDto;
import edu.uncc.ssdi.airlinesystem.dto.CityDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightSearchDto;
import edu.uncc.ssdi.airlinesystem.dto.ItineraryDetailsDto;
import edu.uncc.ssdi.airlinesystem.dto.UserDto;
import edu.uncc.ssdi.airlinesystem.dto.ViewTicketDto;
import edu.uncc.ssdi.airlinesystem.exception.AirlineException;

public interface AirlineRepository {

	UserDto addUser(UserDto userDto);

	/**
	 * 
	 * @param userDto
	 * @return
	 * @throws AirlineException
	 */
	UserDto userLogin(UserDto userDto) throws AirlineException;

	/**
	 * Return List of Cities
	 * 
	 * @return List<CityDto>
	 * @throws AirlineException
	 */
	List<CityDto> getCities() throws AirlineException;

	/**
	 * 
	 * @param itineraryDetailsDto
	 * @param flightDto
	 * @return
	 * @throws AirlineException
	 */
	List<FlightSearchDto> searchFlights(ItineraryDetailsDto itineraryDetailsDto, FlightDto flightDto)
			throws AirlineException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	String getFlightSeatsById(int id);

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws AirlineException
	 */
	List<BookingHistoryResponseDto> getBookingHistory(int userId) throws AirlineException;

	ViewTicketDto getTicket(int bookingId) throws AirlineException;

	int updateSeat(String seats, int itId) throws AirlineException;

	int addBookingDetail(BookingDetailDto bookingDetailDto) throws AirlineException;

	/**
	 * 
	 * @param userId
	 * @param itineraryId
	 * @return
	 * @throws AirlineException 
	 */
	int getBookingId(int userId, int itineraryId) throws AirlineException;

}