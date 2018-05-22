/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.validator;



import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;



import edu.uncc.ssdi.airlinesystem.exception.AirlineException;
import ssdi.uncc.edu.airlinesystemschema.BookingConfirmationRequest;
import ssdi.uncc.edu.airlinesystemschema.FlightSearchRequest;
import ssdi.uncc.edu.airlinesystemschema.LoginRequest;
import ssdi.uncc.edu.airlinesystemschema.RegistrationRequest;

/**
 * @author venky
 *
 */
@Component
public class RequestValidator {

	/**
	 * 
	 * @param request
	 * @throws AirlineException
	 */
	public void registerReqValidator(RegistrationRequest request) throws AirlineException {
		StringBuffer errorMessage=new StringBuffer("");  
		boolean isValid = true;
		
		if(StringUtils.isBlank(request.getFirstName())) {
			isValid = false;
			errorMessage.append("First Name is empty\n");
		}
		if(StringUtils.isBlank(request.getEmail())) {
			isValid = false;
			errorMessage.append("Email is empty\n");
		}
		if(StringUtils.isBlank(request.getPassword())) {
			isValid = false;
			errorMessage.append("Password is empty\n");
		}
		if(!isValid) {
			throw new AirlineException(errorMessage.toString());
		}
	}

	/**
	 * 
	 * @param loginRequest
	 * @throws AirlineException 
	 */
	public void loginReqValidator(LoginRequest loginRequest) throws AirlineException {
		StringBuffer errorMessage=new StringBuffer("");  
		boolean isValid = true;
		
		if(StringUtils.isBlank(loginRequest.getUserName())) {
			isValid = false;
			errorMessage.append("Email is empty\n");
		}
		if(StringUtils.isBlank(loginRequest.getPassword())) {
			isValid = false;
			errorMessage.append("Password is empty\n");
		}
		
		if(!isValid) {
			throw new AirlineException(errorMessage.toString());
		}
		
	}
	
	public void validateFlightSearchRq(FlightSearchRequest flightSearchRequest) throws AirlineException{
		StringBuffer errorMessage=new StringBuffer("");  
		boolean isValid = true;
		
		if(StringUtils.isBlank(flightSearchRequest.getFrom())) {
			isValid = false;
			errorMessage.append("From City empty\n");
		} if (StringUtils.isBlank(flightSearchRequest.getTo())) {
			isValid = false;
			errorMessage.append("To city empty\n");
		} if (StringUtils.isBlank(flightSearchRequest.getDate().toString())) {
			isValid = false;
			errorMessage.append("Date of Travel empty\n");
		} if(flightSearchRequest.getNumberOfSeats() < 0) {
			isValid = false;
			errorMessage.append("Number of seats empty\n");
		}
		if (!isValid) {
			throw new AirlineException(errorMessage.toString());
		}
	}

	
	/**
	 * 
	 * @param id
	 * @throws AirlineException 
	 */
	public void validateFlightId(int id) throws AirlineException {
		StringBuffer errorMessage=new StringBuffer("");  
		boolean isValid = true;
		
		Integer intId = id;
		
		if(intId == null || intId == 0) {
			isValid = false;
			errorMessage.append("flight can't be null or zero\n");
		}
		if (!isValid) {
			throw new AirlineException(errorMessage.toString());
		}
		
	}

	/**
	 * 
	 * @param userId
	 * @throws AirlineException 
	 */
	public void validateUserId(int userId) throws AirlineException {
		StringBuffer errorMessage=new StringBuffer("");  
		boolean isValid = true;
		
		Integer intId = userId;
		
		if(intId == null || intId == 0) {
			isValid = false;
			errorMessage.append("User Id can't be null or zero\n");
		}
		if (!isValid) {
			throw new AirlineException(errorMessage.toString());
		}
		
	}

	/**
	 * 
	 * @param bookingId
	 * @throws AirlineException 
	 */
	public void validateBookingId(int bookingId) throws AirlineException {
		
		StringBuffer errorMessage=new StringBuffer("");  
		boolean isValid = true;
		
		Integer intId = bookingId;
		
		if(intId == null || intId == 0) {
			isValid = false;
			errorMessage.append("Booking Id can't be null or zero\n");
		}
		if (!isValid) {
			throw new AirlineException(errorMessage.toString());
		}
	}

	/**
	 * 
	 * @param bookingConfirmationRequest
	 */
	public void validateBookingConfirmation(BookingConfirmationRequest bookingConfirmationRequest) {
		StringBuffer errorMessage=new StringBuffer("");  
		boolean isValid = true;
		
		
		
		if(bookingConfirmationRequest.getUpdatedSeats() == null) {
			isValid = false;
			errorMessage.append("No Seat selected");
		}
		
	}

}
