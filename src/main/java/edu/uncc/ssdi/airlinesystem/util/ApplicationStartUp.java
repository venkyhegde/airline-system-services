/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import edu.uncc.ssdi.airlinesystem.dto.CityDto;
import edu.uncc.ssdi.airlinesystem.exception.AirlineException;
import edu.uncc.ssdi.airlinesystem.repository.AirlineRepository;

/**
 * @author venky
 *
 */
@Component
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {

	public static List<CityDto> cityList = new ArrayList<>();
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			cityList = Collections.unmodifiableList(airlineRepository.getCities());
		} catch (AirlineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
