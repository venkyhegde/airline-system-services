/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.util;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uncc.ssdi.airlinesystem.dto.CityDto;
import edu.uncc.ssdi.airlinesystem.dto.CountryDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightDto;
import edu.uncc.ssdi.airlinesystem.exception.AirlineException;
import edu.uncc.ssdi.airlinesystem.repository.AirlineRepository;
import edu.uncc.ssdi.airlinesystem.repository.AirlineUtilRepositoryImpl;

/**
 * @author venky
 *
 */
@Component
public class AirlineUtil {

	private static final Logger LOG = Logger.getLogger(AirlineUtil.class.getName());
	
	@Autowired
	private AirlineRepository airlineRepository;

	@Autowired
	private AirlineUtilRepositoryImpl airlinseUtilRepo;

	/**
	 * getFlightById
	 * 
	 * @param id
	 * @return
	 * @throws AirlineException
	 */
	public FlightDto getFlightById(int id) throws AirlineException {
		FlightDto flightDto = new FlightDto();

		flightDto = airlinseUtilRepo.getFlightById(id);

		return flightDto;
	}

	/**
	 * getFlightByName
	 * 
	 * @param name
	 * @return
	 * @throws AirlineException
	 */
	public FlightDto getFlightByName(String name) throws AirlineException {
		FlightDto flightDto = new FlightDto();
		flightDto = airlinseUtilRepo.getFlightByName(name);
		return flightDto;
	}

	/**
	 * getFlightList
	 * 
	 * @return flightList
	 * @throws AirlineException
	 */
	public List<FlightDto> getFlightList() throws AirlineException {
		List<FlightDto> flightList = new ArrayList<>();
		flightList = airlinseUtilRepo.getFlights();
		return flightList;
	}

	/**
	 * getCityById
	 * 
	 * @param id
	 * @return cityDto
	 * @throws AirlineException
	 */
	public CityDto getCityById(int id)  {
		CityDto cityDto = new CityDto();
		// cityDto = airlinseUtilRepo.getCityById(id);
		for (CityDto cityDto2 : ApplicationStartUp.cityList) {

			if (cityDto2.getCityId() == id) {
				cityDto.setCityId(cityDto2.getCityId());
				cityDto.setCityName(cityDto2.getCityName());
				cityDto.setCountryId(cityDto2.getCountryId());
				break;
			}

		}
		return cityDto;
	}

	/**
	 * getCityByName
	 * 
	 * @param name
	 * @return
	 * @throws AirlineException
	 */
	public CityDto getCityByName(String name) {
		CityDto cityDto = new CityDto();
		// cityDto = airlinseUtilRepo.getCityByName(name);

		for (CityDto cityDto2 : ApplicationStartUp.cityList) {

			if (StringUtils.equalsIgnoreCase(cityDto2.getCityName(), name)) {
				cityDto.setCityId(cityDto2.getCityId());
				cityDto.setCityName(cityDto2.getCityName());
				cityDto.setCountryId(cityDto2.getCountryId());
				break;
			}

		}

		return cityDto;
	}

	/**
	 * getCityList
	 * 
	 * @return
	 * @throws AirlineException
	 */
	public List<CityDto> getCityList() throws AirlineException {
		List<CityDto> cityList = new ArrayList<>();

		cityList = airlineRepository.getCities();

		return cityList;

	}

	/**
	 * getCountryList
	 * 
	 * @return
	 * @throws AirlineException
	 */
	public List<CountryDto> getCountryList() throws AirlineException {
		List<CountryDto> countryList = new ArrayList<>();

		countryList = airlinseUtilRepo.getCountryList();

		return countryList;

	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public Date gregorianToSql(XMLGregorianCalendar date) {
		Calendar calendar = new GregorianCalendar(date.getYear(), date.getMonth() - 1, date.getDay());
		java.sql.Date date2 = new java.sql.Date(calendar.getTimeInMillis());
		LOG.info("Date:"+date2);
		return date2;
//		java.util.Date date2 = date.toGregorianCalendar().getTime();
//		return new Date(date2.getTime());
	}

	public XMLGregorianCalendar sqlDateTogrogarian(Date date) {
	
		 XMLGregorianCalendar xmlGregorianCalendar = null;
		 GregorianCalendar gregorianCalendar = new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay());
		
		 DatatypeFactory dataTypeFactory = null;
		try {
			dataTypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 xmlGregorianCalendar = dataTypeFactory.newXMLGregorianCalendar(gregorianCalendar);
		 LOG.info("DateofTravel:"+xmlGregorianCalendar);
		 return xmlGregorianCalendar;
	}

	/**
	 * 
	 * @param fromTime
	 * @param toTime
	 * @return
	 */
	public String getDuration(BigDecimal fromTime, BigDecimal toTime) {
	
		int fromMins = fromTime.remainder(BigDecimal.ONE).movePointRight(fromTime.scale()).abs().toBigInteger().intValue();
		int toMins = toTime.remainder(BigDecimal.ONE).movePointRight(fromTime.scale()).abs().toBigInteger().intValue();
		
		int fromHr = fromTime.toBigInteger().intValue();
		int toHr = toTime.toBigInteger().intValue();
		
		if(fromMins > toMins) {
			toMins = toMins + 60;
			toHr = toHr - 1;
		}
		
		int durMin = toMins - fromMins;
		int durHr = toHr - fromHr;
		
		if(durMin > 60) {
			durMin = durMin - 60;
			durHr = durHr + 1;
		}
		String duration = Integer.toString(durHr)+"h"+" "+Integer.toString(durMin)+"m";
		return duration;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public List<Boolean> stringToSeatList(String str){
		
		List<String> list = new ArrayList<>();
		List<Integer> seatList = new ArrayList<>();
		List<Boolean> booleanList = new ArrayList<>();
		list = Arrays.asList( str.split(","));
		
		for (String s : list) {
//			seatList.add(Integer.parseInt(s));
			if(s.equalsIgnoreCase("0")) {
				booleanList.add(false);
			} else {
				booleanList.add(true);
			}
		}
//		System.out.println(seatList.get(1));
		return booleanList;
		
	}

	/**
	 * 
	 * @param dateOfBooking
	 * @return
	 */
	public String dateToString(Date dateOfBooking) {
		
		SimpleDateFormat dateformatJava = new SimpleDateFormat("MM-dd-yyyy");
		
		String dateToStrig = dateformatJava.format(dateOfBooking);
		LOG.info("Date to String:"+dateToStrig);
		return dateToStrig;
		
		
	}
	
	public String doubleToString(double doubleValue) {
		return String.valueOf(doubleValue);
		
	}

	/**
	 * 
	 * @param updatedSeats
	 * @return
	 */
	public String arryToString(List<Boolean> updatedSeats) {
		String separator = ",";
		List<String> stringList = new ArrayList<>();
		StringBuilder updatedSeatsStr = new StringBuilder();
		for (Boolean boolean1 : updatedSeats) {
			if(boolean1) {
				stringList.add("1");
			} else {
				stringList.add("0");
			}
		}
		
		for (String string : stringList) {
			updatedSeatsStr.append(string);
			updatedSeatsStr.append(separator);
		}
		
		String updatedSeats1 = updatedSeatsStr.toString();
		
		updatedSeats1 = updatedSeats1.substring(0, updatedSeats1.length() - separator.length());
		return updatedSeats1;
	}
}
