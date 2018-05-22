package edu.uncc.ssdi.airlinesystem.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.uncc.ssdi.airlinesystem.dto.CityDto;
import edu.uncc.ssdi.airlinesystem.dto.CountryDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightDto;
import edu.uncc.ssdi.airlinesystem.exception.AirlineException;


@Repository("airlinseUtilRepo")
public class AirlineUtilRepositoryImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * getFlightById
	 * @param id
	 * @return
	 * @throws AirlineException 
	 */
	public FlightDto getFlightById(int id) throws AirlineException {
		FlightDto flightDto = null;
		try {
			flightDto = (FlightDto) jdbcTemplate.queryForObject("SELECT * FROM FlightConfig where Id = ?",
					new Object[] { id }, new BeanPropertyRowMapper(FlightDto.class));
		}catch (EmptyResultDataAccessException e) {
			throw new AirlineException("Invalid flight id");
		}

		return flightDto;
	}
	
	/**
	 * getFlightByName
	 * @param name
	 * @return
	 * @throws AirlineException 
	 */
	public FlightDto getFlightByName(String name) throws AirlineException {
		FlightDto flightDto = null;
		try {
			flightDto = (FlightDto) jdbcTemplate.queryForObject("SELECT * FROM FlightConfig where Name = ?",
					new Object[] { name }, new BeanPropertyRowMapper(FlightDto.class));
		}catch (EmptyResultDataAccessException e) {
			throw new AirlineException("Invalid flight name");
		}

		return flightDto;
	}
	
	/**
	 * Return List of Flights
	 * @return List<CityDto>
	 * @throws AirlineException
	 */
	public List<FlightDto> getFlights() throws AirlineException{
		List<FlightDto> flightList = null;
		try {
			flightList	 = jdbcTemplate.query("SELECT * FROM FlightConfig", new RowMapper<FlightDto> (){

				@Override
				public FlightDto mapRow(ResultSet rs, int rowNum) throws SQLException {
					FlightDto flightDto = new FlightDto();
					flightDto.setId(rs.getInt("Id"));
					flightDto.setFlightType(rs.getString("FlightType"));
					flightDto.setName(rs.getString("Name"));
					flightDto.setTotalSeats(rs.getInt("TotalSeats"));
					return flightDto;
				}
				
			});
		} catch(DataAccessException e) {
			throw new AirlineException("Unable to get flights");
		}
		
		
		return flightList;
	}
	
	
	/**
	 * getCityById
	 * @param id
	 * @return
	 * @throws AirlineException 
	 */
	public CityDto getCityById(int id) throws AirlineException {
		CityDto cityDto = null;
		try {
			cityDto = (CityDto) jdbcTemplate.queryForObject("SELECT * FROM CityConfig where Id = ?",
					new Object[] { id }, new BeanPropertyRowMapper(CityDto.class));
		}catch (EmptyResultDataAccessException e) {
			throw new AirlineException("Invalid city id");
		}

		return cityDto;
	}
	
	
	/**
	 * getCityByName
	 * @param name
	 * @return
	 * @throws AirlineException 
	 */
	public CityDto getCityByName(String name) throws AirlineException {
		CityDto cityDto = null;
		try {
			cityDto = (CityDto) jdbcTemplate.queryForObject("SELECT * FROM CityConfig where Name = ?",
					new Object[] { name }, new BeanPropertyRowMapper(CityDto.class));
		}catch (EmptyResultDataAccessException e) {
			throw new AirlineException("Invalid City Name");
		}

		return cityDto;
	}

	public List<CountryDto> getCountryList() throws AirlineException {
		 List<CountryDto> countryList = null;
		 
		
			try {
				countryList	 = jdbcTemplate.query("SELECT * FROM CountryConfig", new RowMapper<CountryDto> (){

					@Override
					public CountryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						CountryDto countryDto = new CountryDto();
						countryDto.setId(rs.getInt("Id"));
						countryDto.setName(rs.getString("Name"));
						return countryDto;
					}
					
				});
			} catch(DataAccessException e) {
				throw new AirlineException("Unable to get Countries");
			}
		 
		return countryList;
	}
}
