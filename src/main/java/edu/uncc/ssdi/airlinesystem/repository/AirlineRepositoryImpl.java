/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import edu.uncc.ssdi.airlinesystem.dto.BookingDetailDto;
import edu.uncc.ssdi.airlinesystem.dto.BookingHistoryResponseDto;
import edu.uncc.ssdi.airlinesystem.dto.CityDto;
import edu.uncc.ssdi.airlinesystem.dto.CountryDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightDto;
import edu.uncc.ssdi.airlinesystem.dto.FlightSearchDto;
import edu.uncc.ssdi.airlinesystem.dto.ItineraryDetailsDto;
import edu.uncc.ssdi.airlinesystem.dto.UserDto;
import edu.uncc.ssdi.airlinesystem.dto.ViewTicketDto;
import edu.uncc.ssdi.airlinesystem.exception.AirlineException;

/**
 * @author venky
 *
 */
@Repository("airlineRepository")
public class AirlineRepositoryImpl implements AirlineRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#addUser(edu.uncc.ssdi.airlinesystem.dto.UserDto)
	 */
	@Override
	public UserDto addUser(UserDto userDto) {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.setGeneratedKeyName("id");

		// list columns
		List<String> columns = new ArrayList<>();
		columns.add("FirstName");
		columns.add("LastName");
		columns.add("Password");
		columns.add("Email");
		columns.add("Address");
		columns.add("Admin");
		columns.add("DOB");

		Map<String, Object> data = new HashMap<>();
		data.put("FirstName", userDto.getFirstName());
		data.put("LastName", userDto.getLastName());
		data.put("Password", userDto.getPassword());
		data.put("Email", userDto.getEmail());
		data.put("Address", userDto.getAddress());
		data.put("Admin", userDto.isAdmin());
		data.put("DOB", userDto.getDob());

		insert.setTableName("Users");
		insert.setColumnNames(columns);

		Number id = insert.executeAndReturnKey(data);

		// Now get the inserted user

		UserDto newUser = (UserDto) jdbcTemplate.queryForObject("SELECT * FROM Users WHERE id = ?",
				new Object[] { id.intValue() }, new BeanPropertyRowMapper(UserDto.class));

		return newUser;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#userLogin(edu.uncc.ssdi.airlinesystem.dto.UserDto)
	 */
	@Override
	public UserDto userLogin(UserDto userDto) throws AirlineException {

		String email = userDto.getEmail();
		UserDto newUser = null;
		try {
			newUser = (UserDto) jdbcTemplate.queryForObject("SELECT * FROM Users where Email = ?",
					new Object[] { email }, new BeanPropertyRowMapper(UserDto.class));

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			throw new AirlineException("Invalid Username");
		}

		return newUser;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#getCities()
	 */
	@Override
	public List<CityDto> getCities() throws AirlineException {
		List<CityDto> cityList = null;
		System.out.println("==============INVOKING CITI==============");
		try {
			cityList = jdbcTemplate.query("SELECT * FROM CityConfig", new RowMapper<CityDto>() {

				@Override
				public CityDto mapRow(ResultSet rs, int rowNum) throws SQLException {
					CityDto cityDto = new CityDto();
					cityDto.setCityId(rs.getInt("Id"));
					cityDto.setCityName(rs.getString("Name"));
					cityDto.setCountryId(rs.getInt("country_Id"));
					return cityDto;
				}

			});
		} catch (DataAccessException e) {
			throw new AirlineException("Unable to get cities");
		}

		return cityList;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#searchFlights(edu.uncc.ssdi.airlinesystem.dto.ItineraryDetailsDto, edu.uncc.ssdi.airlinesystem.dto.FlightDto)
	 */
	@Override
	public List<FlightSearchDto> searchFlights(ItineraryDetailsDto itineraryDetailsDto, FlightDto flightDto)
			throws AirlineException {
		List<FlightSearchDto> flightSearchedList = new ArrayList<>();

		String query = "SELECT t1.id as itineryId, t1.FlightId, t1.Flightnumber, t2.Name as AirlineName, t1.Ticketprice as PricePerSeat, t1.Date, t1.ToTime, t1.FromTime, t1.SourceId, t1.DestinationId, t2.URL as Logo FROM ItineraryDetails as t1 JOIN FlightConfig as t2 ON t1.FlightId = t2.Id where t1.Date = ? and t1.SourceId= ? and t1.DestinationId = ? and t2.TotalSeats > ?";
		try {
			jdbcTemplate
					.query(query, new Object[] {
							itineraryDetailsDto.getDate(), itineraryDetailsDto.getSourceId(),
							itineraryDetailsDto.getDestinationId(), flightDto.getTotalSeats() },
							(rs, rowNum) -> new FlightSearchDto(rs.getString("AirlineName"), rs.getString("Logo"),
									new ItineraryDetailsDto(rs.getInt("itineryId"), rs.getInt("FlightId"),
											rs.getString("Flightnumber"), rs.getDouble("PricePerSeat"),
											rs.getDate("Date"), rs.getBigDecimal("ToTime"),
											rs.getBigDecimal("FromTime"), rs.getInt("SourceId"),
											rs.getInt("DestinationId")),
									flightDto.getTotalSeats()))
					.forEach(flightSearchDto -> flightSearchedList.add(flightSearchDto));
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new AirlineException("Unable to Fetch flights");
		}

		return flightSearchedList;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#getFlightSeatsById(int)
	 */
	@Override
	public String getFlightSeatsById(int id) {
		String seats = null;

		seats = jdbcTemplate.queryForObject("SELECT Seats FROM ItineraryDetails where id = ? ", new Object[] { id },
				String.class);

		return seats;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#getBookingHistory(int)
	 */
	@Override
	public List<BookingHistoryResponseDto> getBookingHistory(int userId) throws AirlineException {
		List<BookingHistoryResponseDto> bookingHistoryList = new ArrayList<>();

		String query = "select t1.Id as BookingId, t2.id as ItineraryId, t1.DateOfBooking, t1.TicketCost, t1.SeatsBooked, t2.SourceId, t2.DestinationId, t2.Flightnumber, t3.Name as AirlineName, t3.URL as AirlineLogo from BookingDetails as t1 join ItineraryDetails as t2 on t1.ItineraryId = t2.id join FlightConfig as t3 on t2.FlightId = t3.id where t1.UserId = ?";

		try {
			jdbcTemplate
					.query(query, new Object[] { userId },
							(rs, rowNum) -> new BookingHistoryResponseDto(rs.getInt("BookingId"),
									rs.getInt("ItineraryId"), rs.getDate("DateOfBooking"), rs.getDouble("TicketCost"),
									rs.getInt("SeatsBooked"), rs.getString("Flightnumber"), rs.getString("AirlineName"),
									rs.getString("AirlineLogo"), rs.getInt("DestinationId"), rs.getInt("SourceId")))
					.forEach(bookingHistoryResponseDto -> bookingHistoryList.add(bookingHistoryResponseDto));
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new AirlineException("Unable to Fetch booking history");
		}

		return bookingHistoryList;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#getTicket(int)
	 */
	@Override
	public ViewTicketDto getTicket(int bookingId) throws AirlineException {
		ViewTicketDto viewTicketDto = new ViewTicketDto();

		String query = "select t3.Id as BookingId, t2.FromTime,t2.ToTime,t1.Name as Operator, t1.URL as Logo, t2.Flightnumber, t2.Date, t2.SourceId, t2.DestinationId, t2.Ticketprice, t3.TicketCost as Totalprice, t3.SeatsBooked as NumberOfSeats, t3.BookedSeats as Seats,t4.FirstName, t4.LastName, t4.Email from FlightConfig as t1 join ItineraryDetails as t2 on t1.Id = t2.FlightId join BookingDetails as t3 on t3.ItineraryId = t2.Id join Users as t4 on t4.Id = t3.UserId where t3.Id = ?";

		try {
			viewTicketDto = (ViewTicketDto) jdbcTemplate.queryForObject(query, new Object[] { bookingId },
					new ViewTicketRowMapper());

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			throw new AirlineException("Invalid Booking ID");
		}

		return viewTicketDto;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#updateSeat(java.lang.String, int)
	 */
	@Override
	public int updateSeat(String seats, int itId) throws AirlineException {

		String query = "UPDATE ItineraryDetails SET Seats = ? WHERE id= ?";
		int result;
		try {
			result = jdbcTemplate.update(query, seats, itId);
		} catch (DataAccessException e) {
			throw new AirlineException("Failed in upate seats");
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#addBookingDetail(edu.uncc.ssdi.airlinesystem.dto.BookingDetailDto)
	 */
	@Override
	public int addBookingDetail(BookingDetailDto bookingDetailDto) throws AirlineException {
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.setGeneratedKeyName("id");
		
		List<String> columns = new ArrayList<>();
		columns.add("UserId");
		columns.add("ItineraryId");
		columns.add("SeatsBooked");
		columns.add("TicketCost");
		columns.add("DateOfBooking");
		columns.add("BookedSeats");
	
		Map<String, Object> data = new HashMap<>();
		data.put("UserId", bookingDetailDto.getUserId());
		data.put("ItineraryId", bookingDetailDto.getItineraryId());
		data.put("SeatsBooked", bookingDetailDto.getSeatsBooked());
		data.put("TicketCost", bookingDetailDto.getTicketCost());
		data.put("DateOfBooking", bookingDetailDto.getDateOfBooking());
		data.put("BookedSeats", bookingDetailDto.getBookedSeats());
		
		insert.setTableName("BookingDetails");
		insert.setColumnNames(columns);
		
		Number id = insert.executeAndReturnKey(data);
		int bookingId = id.intValue();
		
		return bookingId;
		
//		String query = "INSERT INTO BookingDetails (UserId, ItineraryId, SeatsBooked, TicketCost, DateOfBooking, BookedSeats) VALUES (?, ?, ?, ?, ?,?)";
//		int noOfRowsAffected;
//		try {
//			noOfRowsAffected = jdbcTemplate.update(query,
//					new Object[] { bookingDetailDto.getUserId(), bookingDetailDto.getItineraryId(),
//							bookingDetailDto.getSeatsBooked(), bookingDetailDto.getTicketCost(),
//							bookingDetailDto.getDateOfBooking(), bookingDetailDto.getBookedSeats() });
//		} catch (DataAccessException e) {
//			throw new AirlineException("Failed to book");
//		}
//return noOfRowsAffected;
	}

	/* (non-Javadoc)
	 * @see edu.uncc.ssdi.airlinesystem.repository.AirlineRepository#getBookingId(int, int)
	 */
	@Override
	public int getBookingId(int userId, int itineraryId) throws AirlineException {
		
		
		
		
		String query = "	select Id from BookingDetails where UserId = ? and ItineraryId = ?";
		int bookingId;
		try {
			 bookingId = jdbcTemplate.queryForObject(query, new Object[] {userId, itineraryId}, Integer.class);
		}catch (DataAccessException e) {
			e.printStackTrace();
			throw new AirlineException("Failed to get bookingId");
		}
		
		return bookingId;
	}

}
