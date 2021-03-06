//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.24 at 04:37:09 AM EDT 
//


package ssdi.uncc.edu.airlinesystemschema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BookingHistoryDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookingHistoryDetailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DateOfBooking" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TotalCost" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="NumberOfSeats" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="To" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FlightNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Airline" type="{http://edu.uncc.ssdi/AirlineSystemSchema}AirlineType"/&gt;
 *         &lt;element name="ItineraryId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="BokingId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookingHistoryDetailType", propOrder = {
    "dateOfBooking",
    "totalCost",
    "numberOfSeats",
    "from",
    "to",
    "flightNumber",
    "airline",
    "itineraryId",
    "bokingId"
})
public class BookingHistoryDetailType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "DateOfBooking", required = true)
    protected String dateOfBooking;
    @XmlElement(name = "TotalCost")
    protected double totalCost;
    @XmlElement(name = "NumberOfSeats")
    protected int numberOfSeats;
    @XmlElement(name = "From", required = true)
    protected String from;
    @XmlElement(name = "To", required = true)
    protected String to;
    @XmlElement(name = "FlightNumber", required = true)
    protected String flightNumber;
    @XmlElement(name = "Airline", required = true)
    protected AirlineType airline;
    @XmlElement(name = "ItineraryId")
    protected int itineraryId;
    @XmlElement(name = "BokingId")
    protected int bokingId;

    /**
     * Gets the value of the dateOfBooking property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfBooking() {
        return dateOfBooking;
    }

    /**
     * Sets the value of the dateOfBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfBooking(String value) {
        this.dateOfBooking = value;
    }

    /**
     * Gets the value of the totalCost property.
     * 
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the value of the totalCost property.
     * 
     */
    public void setTotalCost(double value) {
        this.totalCost = value;
    }

    /**
     * Gets the value of the numberOfSeats property.
     * 
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Sets the value of the numberOfSeats property.
     * 
     */
    public void setNumberOfSeats(int value) {
        this.numberOfSeats = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom(String value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo(String value) {
        this.to = value;
    }

    /**
     * Gets the value of the flightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the value of the flightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNumber(String value) {
        this.flightNumber = value;
    }

    /**
     * Gets the value of the airline property.
     * 
     * @return
     *     possible object is
     *     {@link AirlineType }
     *     
     */
    public AirlineType getAirline() {
        return airline;
    }

    /**
     * Sets the value of the airline property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirlineType }
     *     
     */
    public void setAirline(AirlineType value) {
        this.airline = value;
    }

    /**
     * Gets the value of the itineraryId property.
     * 
     */
    public int getItineraryId() {
        return itineraryId;
    }

    /**
     * Sets the value of the itineraryId property.
     * 
     */
    public void setItineraryId(int value) {
        this.itineraryId = value;
    }

    /**
     * Gets the value of the bokingId property.
     * 
     */
    public int getBokingId() {
        return bokingId;
    }

    /**
     * Sets the value of the bokingId property.
     * 
     */
    public void setBokingId(int value) {
        this.bokingId = value;
    }

}
