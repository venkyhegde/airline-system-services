/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.dto;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author venky
 *
 */
public class FlightSearchDto {

	
	public FlightSearchDto(String airLineName, String logo, ItineraryDetailsDto itineraryDetailsDto, int numberOfSeats) {
		super();
		this.numberOfSeats = numberOfSeats;
		this.airLineName = airLineName;
		this.itineraryDetailsDto = itineraryDetailsDto;
		this.logo =logo;
	}
	public FlightSearchDto() {
		super();
	}
	/**
	 * @return the numberOfSeats
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	/**
	 * @param numberOfSeats the numberOfSeats to set
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	private int numberOfSeats;
	private String airLineName;
	private String logo;
	
	private ItineraryDetailsDto itineraryDetailsDto;

	/**
	 * @return the airLineName
	 */
	public String getAirLineName() {
		return airLineName;
	}

	/**
	 * @param airLineName the airLineName to set
	 */
	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the itineraryDetailsDto
	 */
	public ItineraryDetailsDto getItineraryDetailsDto() {
		return itineraryDetailsDto;
	}

	/**
	 * @param itineraryDetailsDto the itineraryDetailsDto to set
	 */
	public void setItineraryDetailsDto(ItineraryDetailsDto itineraryDetailsDto) {
		this.itineraryDetailsDto = itineraryDetailsDto;
	}

}
