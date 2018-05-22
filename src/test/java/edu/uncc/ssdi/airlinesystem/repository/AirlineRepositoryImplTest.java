/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.repository;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uncc.ssdi.airlinesystem.config.AirlineSystemApplication;
import edu.uncc.ssdi.airlinesystem.dto.ViewTicketDto;
import edu.uncc.ssdi.airlinesystem.exception.AirlineException;
import edu.uncc.ssdi.airlinesystem.repository.AirlineRepositoryImpl;

/**
 * @author venky
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AirlineRepositoryImpl.class)
@ContextConfiguration(classes = AirlineSystemApplication.class)
public class AirlineRepositoryImplTest {

	@Autowired
	private AirlineRepository airlineRepository;
	
//	AirlineRepositoryImpl airlineRepository = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
//		  airlineRepository = new AirlineRepositoryImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ViewTicketDto viewTicketDto = null;
		try {
			 viewTicketDto = airlineRepository.getTicket(1);
		} catch (AirlineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(viewTicketDto);
	}

}
