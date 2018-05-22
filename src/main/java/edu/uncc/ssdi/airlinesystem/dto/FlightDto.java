/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.dto;

/**
 * @author venky
 *
 */
public class FlightDto {
	private int id;
	private String name;
	private int totalSeats;
	private String flightType;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the totalSeats
	 */
	public int getTotalSeats() {
		return totalSeats;
	}
	/**
	 * @param totalSeats the totalSeats to set
	 */
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	/**
	 * @return the flightType
	 */
	public String getFlightType() {
		return flightType;
	}
	/**
	 * @param flightType the flightType to set
	 */
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	
	
}
