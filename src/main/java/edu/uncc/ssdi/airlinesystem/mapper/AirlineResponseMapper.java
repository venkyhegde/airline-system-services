/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uncc.ssdi.airlinesystem.dto.BookingHistoryResponseDto;
import edu.uncc.ssdi.airlinesystem.dto.CityDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightSearchDto;
import edu.uncc.ssdi.airlinesystem.dto.ItineraryDetailsDto;
import edu.uncc.ssdi.airlinesystem.dto.UserDto;
import edu.uncc.ssdi.airlinesystem.dto.ViewTicketDto;
import edu.uncc.ssdi.airlinesystem.exception.AirlineException;
import edu.uncc.ssdi.airlinesystem.util.AirlineUtil;
import ssdi.uncc.edu.airlinesystemschema.AirlineType;
import ssdi.uncc.edu.airlinesystemschema.BookingHistoryDetailType;
import ssdi.uncc.edu.airlinesystemschema.BookingHistoryResponse;
import ssdi.uncc.edu.airlinesystemschema.BookingInfoType;
import ssdi.uncc.edu.airlinesystemschema.CityType;
import ssdi.uncc.edu.airlinesystemschema.ConfirmationDetailType;
import ssdi.uncc.edu.airlinesystemschema.FlightDetailType;
import ssdi.uncc.edu.airlinesystemschema.FlightInfoType;
import ssdi.uncc.edu.airlinesystemschema.FlightSearchResponse;
import ssdi.uncc.edu.airlinesystemschema.GetCityResponse;
import ssdi.uncc.edu.airlinesystemschema.GetSeatResponse;
import ssdi.uncc.edu.airlinesystemschema.LoginResponse;
import ssdi.uncc.edu.airlinesystemschema.PaymentInfoType;
import ssdi.uncc.edu.airlinesystemschema.RegistrationResponse;
import ssdi.uncc.edu.airlinesystemschema.StatusType;
import ssdi.uncc.edu.airlinesystemschema.ViewTicketResponse;

/**
 * @author venky
 *
 */
@Component
public class AirlineResponseMapper {

	@Autowired
	private AirlineUtil airlineUtil;

	public RegistrationResponse mapRegResponse(UserDto newUser) {
		RegistrationResponse regResponse = new RegistrationResponse();
		if (!StringUtils.isBlank(newUser.getAddress())) {
			regResponse.setAddress(newUser.getAddress());
		}
		if (!StringUtils.isBlank(newUser.getDob())) {
			regResponse.setDob(newUser.getDob());
		}
		if (!StringUtils.isBlank(newUser.getEmail())) {
			regResponse.setEmail(newUser.getEmail());
		}
		if (!StringUtils.isBlank(newUser.getFirstName())) {
			regResponse.setFirstName(newUser.getFirstName());
		}
		if (!StringUtils.isBlank(newUser.getLastName())) {
			regResponse.setLastName(newUser.getLastName());
		}
		if (!StringUtils.isBlank(newUser.getPassword())) {
			regResponse.setPassword(newUser.getPassword());
		}
		if (null != new Integer(newUser.getId())) {
			regResponse.setId(newUser.getId());
		}

		regResponse.setIsAdmin(newUser.isAdmin());
		StatusType status = new StatusType();
		status.setStatus("Success");
		status.setStatusCode("200");
		status.setStatusDes("Registration Successful");
		regResponse.setStatus(status);
		return regResponse;
	}

	/**
	 * 
	 * @param newUser
	 * @return
	 */
	public LoginResponse mapLoginResponse(UserDto newUser) {

		LoginResponse loginResponse = new LoginResponse();
		if (!StringUtils.isBlank(newUser.getAddress())) {
			loginResponse.setAddress(newUser.getAddress());
		}
		if (!StringUtils.isBlank(newUser.getDob())) {
			loginResponse.setDob(newUser.getDob());
		}
		if (!StringUtils.isBlank(newUser.getEmail())) {
			loginResponse.setEmail(newUser.getEmail());
		}
		if (!StringUtils.isBlank(newUser.getFirstName())) {
			loginResponse.setFirstName(newUser.getFirstName());
		}
		if (!StringUtils.isBlank(newUser.getLastName())) {
			loginResponse.setLastName(newUser.getLastName());
		}
		if (!StringUtils.isBlank(newUser.getPassword())) {
			loginResponse.setPassword(newUser.getPassword());
		}
		if (null != new Integer(newUser.getId())) {
			loginResponse.setId(newUser.getId());
		}

		loginResponse.setIsAdmin(newUser.isAdmin());
		StatusType status = new StatusType();
		status.setStatus("Success");
		status.setStatusCode("200");
		status.setStatusDes("Login Successful");
		loginResponse.setStatus(status);
		return loginResponse;

	}

	/**
	 * Get city list response mapper
	 * 
	 * @param cityDtoList
	 * @return
	 */
	public GetCityResponse mapGetCityResponse(List<CityDto> cityDtoList) {
		GetCityResponse getCityResponse = new GetCityResponse();
		List<CityType> cityList = new ArrayList<>();

		for (CityDto cityDto : cityDtoList) {
			CityType city = new CityType();
			city.setCityId(cityDto.getCityId());
			city.setCityName(cityDto.getCityName());
			city.setCountryId(cityDto.getCountryId());
			cityList.add(city);

		}
		getCityResponse.getCities().addAll(cityList);
		StatusType status = new StatusType();
		status.setStatus("Success");
		status.setStatusCode("200");
		status.setStatusDes("Returning list of cities");
		getCityResponse.setStatus(status);
		return getCityResponse;
	}

	/**
	 * 
	 * @param flightSearchedList
	 * @return flightSearchResponse
	 * @throws AirlineException
	 */
	public FlightSearchResponse mapFlightSearchResponse(List<FlightSearchDto> flightSearchedList) {
		FlightSearchResponse flightSearchResponse = new FlightSearchResponse();

		for (FlightSearchDto flightSearchDto : flightSearchedList) {
			FlightDetailType flightDetailType = new FlightDetailType();

			ItineraryDetailsDto itineraryDetailDto = flightSearchDto.getItineraryDetailsDto();
			// itinarrayId
			flightDetailType.setItineraryId(itineraryDetailDto.getId());

			//to time and from time
			
			flightDetailType.setDepartureTime(itineraryDetailDto.getFromTime().doubleValue());
			flightDetailType.setArrivalTime(itineraryDetailDto.getToTime().doubleValue());
			// logo
			if (StringUtils.isNotBlank(flightSearchDto.getLogo())) {
				flightDetailType.setLogo(flightSearchDto.getLogo());
			}
			// flight id
			flightDetailType.setFlightId(itineraryDetailDto.getFlightId());

			// flightNumber
			if (StringUtils.isNotBlank(itineraryDetailDto.getFlightNumber())) {
				flightDetailType.setFlightNumber(itineraryDetailDto.getFlightNumber());
			}

			// flightName
			if (StringUtils.isNotBlank(flightSearchDto.getAirLineName())) {
				flightDetailType.setAirlineName(flightSearchDto.getAirLineName());
			}

			// Date of journey
			if (null != itineraryDetailDto.getDate()) {
				flightDetailType.setDateOfJourney(airlineUtil.dateToString(itineraryDetailDto.getDate()));
			}
			flightDetailType.setPricePerSeat(itineraryDetailDto.getTicketPrice());
			flightDetailType.setNumberOfSeats(flightSearchDto.getNumberOfSeats());
			flightDetailType.setTotalPrice(itineraryDetailDto.getTicketPrice() * flightSearchDto.getNumberOfSeats());
			flightDetailType.setFrom(airlineUtil.getCityById(itineraryDetailDto.getSourceId()).getCityName());
			flightDetailType.setTo(airlineUtil.getCityById(itineraryDetailDto.getDestinationId()).getCityName());
			flightDetailType.setDuration(
					airlineUtil.getDuration(itineraryDetailDto.getFromTime(), itineraryDetailDto.getToTime()));
			flightSearchResponse.getFlightDetails().add(flightDetailType);
		}

		StatusType status = new StatusType();
		status.setStatus("Success");
		status.setStatusCode("200");
		flightSearchResponse.setStatus(status);
		return flightSearchResponse;
	}

	/**
	 * 
	 * @param bookingHistoryList
	 * @return
	 */
	public BookingHistoryResponse mapBookingHistoryRs(List<BookingHistoryResponseDto> bookingHistoryList) {

		BookingHistoryResponse bookingHistoryResponse = new BookingHistoryResponse();

		for (BookingHistoryResponseDto bookingHistoryResponseDto : bookingHistoryList) {

			BookingHistoryDetailType bookingHistoryDetail = new BookingHistoryDetailType();

			if (null != bookingHistoryResponseDto.getDateOfBooking()) {
				bookingHistoryDetail
						.setDateOfBooking(airlineUtil.dateToString(bookingHistoryResponseDto.getDateOfBooking()));
			}
			bookingHistoryDetail.setBokingId(bookingHistoryResponseDto.getBookingId());
			bookingHistoryDetail.setItineraryId(bookingHistoryResponseDto.getItineraryId());
			bookingHistoryDetail.setTotalCost(bookingHistoryResponseDto.getTotalCost());
			bookingHistoryDetail.setNumberOfSeats(bookingHistoryResponseDto.getNumberOfSeats());
			bookingHistoryDetail.setFrom(airlineUtil.getCityById(bookingHistoryResponseDto.getFromId()).getCityName());
			bookingHistoryDetail.setTo(airlineUtil.getCityById(bookingHistoryResponseDto.getToId()).getCityName());
			bookingHistoryDetail.setFlightNumber(bookingHistoryResponseDto.getFlightNumber());
			AirlineType airlineType = new AirlineType();
			airlineType.setAirlineName(bookingHistoryResponseDto.getAirlineName());
			airlineType.setAirlineLogo(bookingHistoryResponseDto.getAirlineLogo());
			bookingHistoryDetail.setAirline(airlineType);

			bookingHistoryResponse.getBookingHistoryDetails().add(bookingHistoryDetail);
		}
		StatusType statusType = new StatusType();
		statusType.setStatus("Success");
		statusType.setStatusCode("Booking history list");
		bookingHistoryResponse.setStatus(statusType);
		return bookingHistoryResponse;
	}

	/**
	 * 
	 * @param seatList
	 * @return
	 */
	public GetSeatResponse mapSeatList(List<Boolean> seatList) {
		
		GetSeatResponse getSeatResponse = new GetSeatResponse();
		
		for (Boolean boolean1 : seatList) {
			getSeatResponse.getSeats().add(boolean1);
		}
		
		
		StatusType status = new StatusType();
		status.setStatus("Success");
		status.setStatusCode("Seat layout");
		getSeatResponse.setStatus(status);
		return getSeatResponse;
	}

	/**
	 * 
	 * 
	 * @param viewTicketDto
	 * @return
	 */
	public ViewTicketResponse mapViewTicketRs(ViewTicketDto viewTicketDto) {
		
		
		ViewTicketResponse viewTicketResponse = new ViewTicketResponse();
		ConfirmationDetailType confirmationDetail = new ConfirmationDetailType();
		
		FlightInfoType flightInfoType = new FlightInfoType();
		
		flightInfoType.setOperator(viewTicketDto.getOperator());
		flightInfoType.setLogo(viewTicketDto.getLogo());
		flightInfoType.setFlightNumber(viewTicketDto.getFlightNumber());
		flightInfoType.setDateOfJourney(airlineUtil.dateToString(viewTicketDto.getDateOfJourney()));
		flightInfoType.setDuration(airlineUtil.getDuration(viewTicketDto.getFromTime(), viewTicketDto.getToTime()));
		flightInfoType.setSource(airlineUtil.getCityById(viewTicketDto.getSourceId()).getCityName());
		flightInfoType.setDestination(airlineUtil.getCityById(viewTicketDto.getDestinationId()).getCityName());
		
		confirmationDetail.setFlightInfo(flightInfoType);
		
		PaymentInfoType paymentInfoType = new PaymentInfoType();
		paymentInfoType.setPricePerTicket(airlineUtil.doubleToString(viewTicketDto.getTicketPrice()));
		paymentInfoType.setTotalPrice(airlineUtil.doubleToString(viewTicketDto.getTotalPrice()));
		paymentInfoType.setModeOfPayment("Online");
		paymentInfoType.setBookingStatus("Confirmed");
		paymentInfoType.setNumberOfSeats(String.valueOf(viewTicketDto.getNumberOfSeats()));
		paymentInfoType.setSeatNumber(viewTicketDto.getSeats());
		confirmationDetail.setPaymentInfo(paymentInfoType);
		
		BookingInfoType bookingInfoType = new BookingInfoType();
		bookingInfoType.setName(viewTicketDto.getFirstName()+" "+viewTicketDto.getLastName());
		bookingInfoType.setEmail(viewTicketDto.getEmail());
		bookingInfoType.setBookingId(viewTicketDto.getBookingId());
		confirmationDetail.setBookingInfo(bookingInfoType);
		
		viewTicketResponse.setConfirmationDetail(confirmationDetail);
		
		StatusType statusType = new StatusType();
		statusType.setStatus("Succes");
		statusType.setStatusCode("Booking Detail");
		
		viewTicketResponse.setStatus(statusType);
		
		return viewTicketResponse;
	}

}
