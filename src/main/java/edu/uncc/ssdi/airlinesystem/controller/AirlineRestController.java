/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletContextAttributeListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uncc.ssdi.airlinesystem.service.AirlineService;
import edu.uncc.ssdi.airlinesystem.service.NotificationService;
import edu.uncc.ssdi.airlinesystem.util.Mail;
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
import ssdi.uncc.edu.airlinesystemschema.ViewTicketResponse;

@RestController
@RequestMapping("/airline/rest")
public class AirlineRestController implements AirlineController {

	@Autowired
	private AirlineService airlineService;
	
	@Autowired
	private NotificationService notification;

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.controller.AirlineController#testService()
	 */
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/testService", method = RequestMethod.GET)
	public String testService() {
		return "Rest Service up and running";
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.controller.AirlineController#registerUser(ssdi.uncc.edu.airlinesystemschema.RegistrationRequest)
	 */
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RegistrationResponse registerUser(@RequestBody RegistrationRequest regRequest) {
		RegistrationResponse regResponse = null;
		regResponse = airlineService.addUser(regRequest);
		return regResponse;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.controller.AirlineController#userLogin(ssdi.uncc.edu.airlinesystemschema.LoginRequest)
	 */
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse userLogin(@RequestBody LoginRequest loginRequest) {
		LoginResponse loginResponse = null;
		loginResponse = airlineService.userLogin(loginRequest);
		return loginResponse;

	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.controller.AirlineController#getCityList()
	 */
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getCityList", method = RequestMethod.GET)
	public GetCityResponse getCityList() {
		
				 GetCityResponse cityList = airlineService.getCityList();
		return cityList;
	}
	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.controller.AirlineController#searchFlight(ssdi.uncc.edu.airlinesystemschema.FlightSearchRequest)
	 */
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/searchFlight", method = RequestMethod.POST)
	public FlightSearchResponse searchFlight(@RequestBody FlightSearchRequest flightSearchRequest) {
		FlightSearchResponse flightSearchResponse = null;
		flightSearchResponse = airlineService.searchFlight(flightSearchRequest);
		
		return flightSearchResponse;
		
	}
	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.controller.AirlineController#getSeatsByFlightId(int)
	 */
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getSeats/{itineraryId}", method = RequestMethod.GET)
	public GetSeatResponse getSeatsByFlightId(@PathVariable("itineraryId") int itineraryId ){
		List<Boolean> seatList = new ArrayList<>();
		
		 GetSeatResponse getSeatResponse = airlineService.getSeatsByFlights(itineraryId);
		
		return getSeatResponse;
		
	}
	
	
	
	
	
	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.controller.AirlineController#getBookingHistory(int)
	 */
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/bookingHistory/{userId}", method = RequestMethod.GET)
	public BookingHistoryResponse getBookingHistory(@PathVariable("userId") int userId) {
		BookingHistoryResponse bookingHistoryResponse = new BookingHistoryResponse();
		
		bookingHistoryResponse = airlineService.getBookingHistory(userId);
		
		return bookingHistoryResponse;
	}
	
	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.controller.AirlineController#ViewTicket(int)
	 */
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/viewTicket/{bookingId}", method = RequestMethod.GET)
	public ViewTicketResponse ViewTicket(@PathVariable("bookingId") int bookingId) {
		
		ViewTicketResponse viewTicketResponse = new ViewTicketResponse();
		viewTicketResponse = airlineService.viewTicket(bookingId);
		return viewTicketResponse;
		
	}
	
	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.controller.AirlineController#bookingConfirmation(ssdi.uncc.edu.airlinesystemschema.BookingConfirmationRequest)
	 */
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/bookingConfirmation", method = RequestMethod.POST)
	public ViewTicketResponse bookingConfirmation(@RequestBody BookingConfirmationRequest bookingConfirmationRequest) {
		
		ViewTicketResponse viewTicketResponse = new ViewTicketResponse();
		
		viewTicketResponse = airlineService.bookingConfirmation(bookingConfirmationRequest);
		
		return viewTicketResponse;
		
	}
	
	/**
	 * Send mail need to be re factored. 
	 */
//	@CrossOrigin(origins = "*")
//	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
//	public void sendMail() {
//		Mail mail = new Mail();
//		
//		mail.setMailTo("venky.suh@gmail.com");
//		mail.setMailSubject("Test");
//		 Map model = new HashMap();
//		 model.put("name", "venky");
//		 
//		 mail.setModel(model);
//		 
//		 try {
//			notification.sendSimpleMessage(mail);
//		} catch (TemplateNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedTemplateNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TemplateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
