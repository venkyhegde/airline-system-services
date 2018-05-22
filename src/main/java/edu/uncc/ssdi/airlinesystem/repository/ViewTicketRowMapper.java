/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.uncc.ssdi.airlinesystem.dto.ViewTicketDto;

/**
 * @author venky
 * @param <T>
 *
 */
public class ViewTicketRowMapper implements RowMapper{

	@Override
	public ViewTicketDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ViewTicketDto viewTicketDto = new ViewTicketDto();
		viewTicketDto.setBookingId(rs.getInt("BookingId"));
		viewTicketDto.setFromTime(rs.getBigDecimal("FromTime"));
		viewTicketDto.setToTime(rs.getBigDecimal("ToTime"));
		viewTicketDto.setOperator(rs.getString("Operator"));
		viewTicketDto.setLogo(rs.getString("Logo"));
		viewTicketDto.setFlightNumber(rs.getString("Flightnumber"));
		viewTicketDto.setDateOfJourney(rs.getDate("Date"));
		viewTicketDto.setSourceId(rs.getInt("SourceId"));
		viewTicketDto.setDestinationId(rs.getInt("DestinationId"));
		viewTicketDto.setTicketPrice(rs.getDouble("Ticketprice"));
		viewTicketDto.setTotalPrice(rs.getDouble("Totalprice"));
		viewTicketDto.setNumberOfSeats(rs.getInt("NumberOfSeats"));
		viewTicketDto.setSeats(rs.getString("Seats"));
		viewTicketDto.setFirstName(rs.getString("FirstName"));
		viewTicketDto.setLastName(rs.getString("LastName"));
		viewTicketDto.setEmail(rs.getString("Email"));
		return viewTicketDto;
	}

}
