/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uncc.ssdi.airlinesystem.dto.BookingDetailDto;
import edu.uncc.ssdi.airlinesystem.dto.BookingHistoryResponseDto;
import edu.uncc.ssdi.airlinesystem.dto.CityDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightSearchDto;
import edu.uncc.ssdi.airlinesystem.dto.ItineraryDetailsDto;
import edu.uncc.ssdi.airlinesystem.dto.UserDto;
import edu.uncc.ssdi.airlinesystem.dto.ViewTicketDto;
import edu.uncc.ssdi.airlinesystem.exception.AirlineException;
import edu.uncc.ssdi.airlinesystem.mapper.AirlineRequestMapper;
import edu.uncc.ssdi.airlinesystem.mapper.AirlineResponseMapper;
import edu.uncc.ssdi.airlinesystem.repository.AirlineRepository;
import edu.uncc.ssdi.airlinesystem.util.AirlineUtil;
import edu.uncc.ssdi.airlinesystem.util.ApplicationStartUp;
import edu.uncc.ssdi.airlinesystem.util.Mail;
import edu.uncc.ssdi.airlinesystem.validator.RequestValidator;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
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
import ssdi.uncc.edu.airlinesystemschema.StatusType;
import ssdi.uncc.edu.airlinesystemschema.ViewTicketResponse;

/**
 * @author venky
 *
 */
@Service("airlineService")
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;

	@Autowired
	private RequestValidator reqValidator;

	@Autowired
	private AirlineRequestMapper reqMapper;

	@Autowired
	private AirlineResponseMapper resMapper;

	@Autowired
	private AirlineUtil airlineUtil;

	@Autowired
	private NotificationService notificationService;

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.AirlineService#addUser(ssdi.uncc.edu.airlinesystemschema.RegistrationRequest)
	 */
	@Override
	public RegistrationResponse addUser(RegistrationRequest request) {
		UserDto userDto = null;
		RegistrationResponse regResponse = null;

		try {
			// Validate the Request
			reqValidator.registerReqValidator(request);

			// map the request
			userDto = reqMapper.mapRegRqMapper(request);

			// call repo
			UserDto newUser = airlineRepository.addUser(userDto);

			// Map the response
			regResponse = resMapper.mapRegResponse(newUser);

		} catch (AirlineException e) {
			regResponse = new RegistrationResponse();
			StatusType status = new StatusType();
			status.setStatus("Error");
			status.setStatusCode(e.getMessage());
			status.setStatusDes(e.getCause().toString());
			regResponse.setStatus(status);
			e.printStackTrace();
		}

		return regResponse;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.AirlineService#userLogin(ssdi.uncc.edu.airlinesystemschema.LoginRequest)
	 */
	@Override
	public LoginResponse userLogin(LoginRequest loginRequest) {
		UserDto userDto = null;
		LoginResponse loginResponse = null;

		try {
			// Validate the Request
			reqValidator.loginReqValidator(loginRequest);

			// map the request
			userDto = reqMapper.mapLoginRqMapper(loginRequest);

			// call repo
			UserDto newUser = airlineRepository.userLogin(userDto);
			String loginPassword = loginRequest.getPassword();
			String newPass = newUser.getPassword();
			if (!loginPassword.equals(newPass)) {
				throw new AirlineException("Invalid Password");
			}

			// Map the response
			loginResponse = resMapper.mapLoginResponse(newUser);

		} catch (AirlineException e) {
			loginResponse = new LoginResponse();
			StatusType status = new StatusType();
			status.setStatus("Error");
			status.setStatusCode(e.getMessage());
			//status.setStatusDes(e.getCause().toString());
			loginResponse.setStatus(status);
			e.printStackTrace();
		}

		return loginResponse;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.AirlineService#getCityList()
	 */
	@Override
	public GetCityResponse getCityList() {

		GetCityResponse getCityResponse = null;

		try {
			// get the Dto list from repository
			@Deprecated
			/**
			 * List<CityDto> cityDtoList = airlineRepository.getCities();
			 */
			List<CityDto> cityDtoList = ApplicationStartUp.cityList;

			// validate list if not null
			if (cityDtoList.size() > 0) {
				// map the response to application response type
				getCityResponse = resMapper.mapGetCityResponse(cityDtoList);
			} else {
				// throw the exception with appropriate message
				throw new AirlineException("No cities found!");
			}
		} catch (AirlineException e) {
			getCityResponse = new GetCityResponse();
			StatusType status = new StatusType();
			status.setStatus("Error");
			status.setStatusCode(e.getMessage());
			status.setStatusDes(e.getCause().toString());
			getCityResponse.setStatus(status);
			e.printStackTrace();
		}

		return getCityResponse;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.AirlineService#searchFlight(ssdi.uncc.edu.airlinesystemschema.FlightSearchRequest)
	 */
	@Override
	public FlightSearchResponse searchFlight(FlightSearchRequest flightSearchRequest) {
		FlightSearchResponse flightSearchResponse = null;
		ItineraryDetailsDto itineraryDetailsDto = null;
		FlightDto flightDto = null;

		try {
			// validate the request
			reqValidator.validateFlightSearchRq(flightSearchRequest);

			// Map the request
			itineraryDetailsDto = reqMapper.mapFlightSearchRq(flightSearchRequest);
			flightDto = reqMapper.mapFlightDtoForSearch(flightSearchRequest);

			List<FlightSearchDto> flightSearchedList = airlineRepository.searchFlights(itineraryDetailsDto, flightDto);

			if (flightSearchedList.isEmpty()) {
				flightSearchResponse = new FlightSearchResponse();
				StatusType status = new StatusType();
				status.setStatus("Success!");
				status.setStatusCode("No flights found for the criteria");
				flightSearchResponse.setStatus(status);
			} else {
				// Map the response
				flightSearchResponse = resMapper.mapFlightSearchResponse(flightSearchedList);
			}

		} catch (AirlineException e) {
			flightSearchResponse = new FlightSearchResponse();
			StatusType status = new StatusType();
			status.setStatus("Error");
			status.setStatusCode(e.getMessage());
			// status.setStatusDes(e.getCause().toString());
			e.printStackTrace();
			flightSearchResponse.setStatus(status);
		}

		return flightSearchResponse;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.AirlineService#getSeatsByFlights(int)
	 */
	@Override
	public GetSeatResponse getSeatsByFlights(int id) {
		List<Boolean> seatList = new ArrayList<>();

		GetSeatResponse getSeatResponse = new GetSeatResponse();

		// validate
		try {
			reqValidator.validateFlightId(id);

			String seats = airlineRepository.getFlightSeatsById(id);

			seatList = airlineUtil.stringToSeatList(seats);

			getSeatResponse = resMapper.mapSeatList(seatList);

		} catch (AirlineException e) {
			StatusType status = new StatusType();
			status.setStatus("Error!");
			status.setStatusCode(e.getMessage());
			getSeatResponse.setStatus(status);
			e.printStackTrace();
		}

		return getSeatResponse;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.AirlineService#getBookingHistory(int)
	 */
	@Override
	public BookingHistoryResponse getBookingHistory(int userId) {
		BookingHistoryResponse bookingHistoryResponse = new BookingHistoryResponse();

		try {
			reqValidator.validateUserId(userId);

			List<BookingHistoryResponseDto> bookingHistoryList = airlineRepository.getBookingHistory(userId);

			if (bookingHistoryList.size() > 0) {
				// Map the response
				bookingHistoryResponse = resMapper.mapBookingHistoryRs(bookingHistoryList);
			}

		} catch (AirlineException e) {
			StatusType status = new StatusType();
			status.setStatus("Error");
			status.setStatusCode(e.getMessage());
			e.printStackTrace();
		}
		return bookingHistoryResponse;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.AirlineService#viewTicket(int)
	 */
	@Override
	public ViewTicketResponse viewTicket(int bookingId) {

		ViewTicketResponse viewTicketResponse = new ViewTicketResponse();

		try {
			reqValidator.validateBookingId(bookingId);
			ViewTicketDto viewTicketDto = airlineRepository.getTicket(bookingId);

			viewTicketResponse = resMapper.mapViewTicketRs(viewTicketDto);
			
		} catch (AirlineException e) {
			StatusType statusType = new StatusType();
			statusType.setStatus("Error");
			statusType.setStatusCode(e.getMessage());
			viewTicketResponse.setStatus(statusType);
			e.printStackTrace();
		}

		return viewTicketResponse;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.AirlineService#sendMail(ssdi.uncc.edu.airlinesystemschema.ViewTicketResponse)
	 */
	@Override
	public void sendMail(ViewTicketResponse viewTicketResponse) throws AirlineException {

		Mail mail = new Mail();

		mail = reqMapper.MailReqMapper(viewTicketResponse);

		try {
			notificationService.sendSimpleMessage(mail);
		} catch (TemplateNotFoundException e) {
			throw new AirlineException("Mail Template Not Found");
		} catch (MalformedTemplateNameException e) {
			throw new AirlineException("MalformedTemplateNameException");
		} catch (ParseException e) {
			throw new AirlineException("ParseException");
		} catch (MessagingException e) {
			throw new AirlineException("MessagingException");
		} catch (IOException e) {
			throw new AirlineException("IOException");
		} catch (TemplateException e) {
			throw new AirlineException("TemplateException");
		}
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.service.AirlineService#bookingConfirmation(ssdi.uncc.edu.airlinesystemschema.BookingConfirmationRequest)
	 */
	@Override
	public ViewTicketResponse bookingConfirmation(BookingConfirmationRequest bookingConfirmationRequest) {
		//validate the request
		ViewTicketDto viewTicketDto = new ViewTicketDto();
		ViewTicketResponse viewTicketResponse = new ViewTicketResponse();
		//reqValidator.validateBookingConfirmation(bookingConfirmationRequest);
		
		//map the data
		BookingDetailDto bookingDetailDto = new BookingDetailDto();
		bookingDetailDto = reqMapper.mapBookingDetail(bookingConfirmationRequest);
		
		try {
			int result = airlineRepository.updateSeat(bookingDetailDto.getUpdatedSeats(), bookingDetailDto.getItineraryId());
			int bookingId = airlineRepository.addBookingDetail(bookingDetailDto);
			
			if(bookingId > 1) {
//				int bookingId = airlineRepository.getBookingId(bookingDetailDto.getUserId(), bookingDetailDto.getItineraryId());
				
				viewTicketDto = airlineRepository.getTicket(bookingId);
			}
			viewTicketResponse = resMapper.mapViewTicketRs(viewTicketDto);
			sendMail(viewTicketResponse);
		} catch (AirlineException e) {
			StatusType statusType = new StatusType();
			statusType.setStatus("Error!");
			statusType.setStatusCode("Booking not confirmed");
			viewTicketResponse.setStatus(statusType);
			e.printStackTrace();
		}
		
		
		
		return viewTicketResponse;
	}
}
