/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uncc.ssdi.airlinesystem.dto.BookingDetailDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightDto;
import edu.uncc.ssdi.airlinesystem.dto.ItineraryDetailsDto;
import edu.uncc.ssdi.airlinesystem.dto.UserDto;
import edu.uncc.ssdi.airlinesystem.util.AirlineUtil;
import edu.uncc.ssdi.airlinesystem.util.Mail;
import ssdi.uncc.edu.airlinesystemschema.BookingConfirmationRequest;
import ssdi.uncc.edu.airlinesystemschema.BookingInfoType;
import ssdi.uncc.edu.airlinesystemschema.ConfirmationDetailType;
import ssdi.uncc.edu.airlinesystemschema.FlightInfoType;
import ssdi.uncc.edu.airlinesystemschema.FlightSearchRequest;
import ssdi.uncc.edu.airlinesystemschema.LoginRequest;
import ssdi.uncc.edu.airlinesystemschema.PaymentInfoType;
import ssdi.uncc.edu.airlinesystemschema.RegistrationRequest;
import ssdi.uncc.edu.airlinesystemschema.ViewTicketResponse;

/**
 * @author venky
 *
 */
@Component
public class AirlineRequestMapper {

	@Autowired
	private AirlineUtil airlineUtil;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public UserDto mapRegRqMapper(RegistrationRequest request) {
		
		UserDto userDto = new UserDto();
		userDto.setFirstName(request.getFirstName());
		userDto.setEmail(request.getEmail());
		userDto.setPassword(request.getPassword());
		
		if(!StringUtils.isBlank(request.getLastName())) {
			userDto.setLastName(request.getLastName());
		}
		if(!StringUtils.isBlank(request.getAddress())) {
			userDto.setAddress(request.getAddress());
		}
		if(!StringUtils.isBlank(request.getDob())) {
			userDto.setDob(request.getDob());;
		}
		userDto.setAdmin(false);
		return userDto;
	}

	/**
	 * 
	 * @param loginRequest
	 * @return
	 */
	public UserDto mapLoginRqMapper(LoginRequest loginRequest) {
		UserDto userDto = new UserDto();
		userDto.setEmail(loginRequest.getUserName());
		userDto.setPassword(loginRequest.getPassword());
		return userDto;
	}

	/**
	 * 
	 * @param flightSearchRequest
	 * @return itineraryDetailsDto
	 */
	public ItineraryDetailsDto mapFlightSearchRq(FlightSearchRequest flightSearchRequest) {
		ItineraryDetailsDto itineraryDetailsDto = new ItineraryDetailsDto();
		
		itineraryDetailsDto.setSourceId(airlineUtil.getCityByName(flightSearchRequest.getFrom()).getCityId());
		itineraryDetailsDto.setDestinationId(airlineUtil.getCityByName(flightSearchRequest.getTo()).getCityId());
		itineraryDetailsDto.setDate(airlineUtil.gregorianToSql(flightSearchRequest.getDate()));
		
		return itineraryDetailsDto;
	}

	/**
	 * 
	 * @param flightSearchRequest
	 * @return flightDto
	 */
	public FlightDto mapFlightDtoForSearch(FlightSearchRequest flightSearchRequest) {
		
		FlightDto flightDto = new FlightDto();
		flightDto.setTotalSeats(flightSearchRequest.getNumberOfSeats());
		return flightDto;
	}

	/**
	 * 
	 * @param viewTicketResponse
	 * @return
	 */
	public Mail MailReqMapper(ViewTicketResponse viewTicketResponse) {
		
		Mail mail = new Mail();
		
		ConfirmationDetailType confirmationType = viewTicketResponse.getConfirmationDetail();
		
		BookingInfoType bookingInfo = confirmationType.getBookingInfo();
		
		FlightInfoType flightInfo = confirmationType.getFlightInfo();
		
		PaymentInfoType paymentInfo = confirmationType.getPaymentInfo();
		
		String subject = "Ticket Confirmation from "+flightInfo.getSource()+" to "+flightInfo.getDestination();
		
		//subject
		mail.setMailSubject(subject);
		mail.setMailTo(bookingInfo.getEmail());
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("name", StringUtils.capitalize(bookingInfo.getName()));
		model.put("email", bookingInfo.getEmail());
		//adding flight details
		model.put("operatorLogo", flightInfo.getLogo());
		model.put("operatorName", flightInfo.getOperator());
		model.put("flightNumber", flightInfo.getFlightNumber());
		model.put("dateOfJourney", flightInfo.getDateOfJourney());
		model.put("duration", flightInfo.getDuration());
		model.put("source", flightInfo.getSource());
		model.put("destination", flightInfo.getDestination());
		
		//adding payment detail
		model.put("pricePerSeat", paymentInfo.getPricePerTicket());
		model.put("totalPrice", paymentInfo.getTotalPrice());
		model.put("numberOfSeats", paymentInfo.getNumberOfSeats());
		model.put("seatNumbers", paymentInfo.getSeatNumber());
		model.put("modeOfPayment", paymentInfo.getModeOfPayment());
		model.put("bookingStatus", paymentInfo.getBookingStatus());
		
		mail.setModel(model);
		
		return mail;
	}

	/**
	 * 
	 * @param bookingConfirmationRequest
	 * @return
	 */
	public BookingDetailDto mapBookingDetail(BookingConfirmationRequest bookingConfirmationRequest) {
		BookingDetailDto bookingDetailDto = new BookingDetailDto();
		
		bookingDetailDto.setUserId(bookingConfirmationRequest.getUserId());
		bookingDetailDto.setItineraryId(bookingConfirmationRequest.getItineraryId());
		bookingDetailDto.setSeatsBooked(bookingConfirmationRequest.getNumberOfSeatBooked());
		bookingDetailDto.setTicketCost(bookingConfirmationRequest.getTicketCost());
		bookingDetailDto.setDateOfBooking(airlineUtil.gregorianToSql(bookingConfirmationRequest.getBookingDate()));
		bookingDetailDto.setBookedSeats(bookingConfirmationRequest.getBookedSeats());
		bookingDetailDto.setUpdatedSeats(airlineUtil.arryToString(bookingConfirmationRequest.getUpdatedSeats()));
		
		return bookingDetailDto;
	}

}
