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
 * <p>Java class for FlightDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlightDetailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FlightId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AirlineName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Logo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TotalPrice" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="DateOfJourney" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="To" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PricePerSeat" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="FlightNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NumberOfSeats" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ItineraryId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DepartureTime" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ArrivalTime" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlightDetailType", propOrder = {
    "flightId",
    "airlineName",
    "logo",
    "totalPrice",
    "dateOfJourney",
    "duration",
    "from",
    "to",
    "pricePerSeat",
    "flightNumber",
    "numberOfSeats",
    "itineraryId",
    "departureTime",
    "arrivalTime"
})
public class FlightDetailType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "FlightId")
    protected int flightId;
    @XmlElement(name = "AirlineName", required = true)
    protected String airlineName;
    @XmlElement(name = "Logo", required = true)
    protected String logo;
    @XmlElement(name = "TotalPrice")
    protected double totalPrice;
    @XmlElement(name = "DateOfJourney", required = true)
    protected String dateOfJourney;
    @XmlElement(name = "Duration", required = true)
    protected String duration;
    @XmlElement(name = "From", required = true)
    protected String from;
    @XmlElement(name = "To", required = true)
    protected String to;
    @XmlElement(name = "PricePerSeat")
    protected double pricePerSeat;
    @XmlElement(name = "FlightNumber", required = true)
    protected String flightNumber;
    @XmlElement(name = "NumberOfSeats")
    protected int numberOfSeats;
    @XmlElement(name = "ItineraryId")
    protected int itineraryId;
    @XmlElement(name = "DepartureTime")
    protected double departureTime;
    @XmlElement(name = "ArrivalTime")
    protected double arrivalTime;

    /**
     * Gets the value of the flightId property.
     * 
     */
    public int getFlightId() {
        return flightId;
    }

    /**
     * Sets the value of the flightId property.
     * 
     */
    public void setFlightId(int value) {
        this.flightId = value;
    }

    /**
     * Gets the value of the airlineName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirlineName() {
        return airlineName;
    }

    /**
     * Sets the value of the airlineName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirlineName(String value) {
        this.airlineName = value;
    }

    /**
     * Gets the value of the logo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Sets the value of the logo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogo(String value) {
        this.logo = value;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     */
    public void setTotalPrice(double value) {
        this.totalPrice = value;
    }

    /**
     * Gets the value of the dateOfJourney property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfJourney() {
        return dateOfJourney;
    }

    /**
     * Sets the value of the dateOfJourney property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfJourney(String value) {
        this.dateOfJourney = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuration(String value) {
        this.duration = value;
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
     * Gets the value of the pricePerSeat property.
     * 
     */
    public double getPricePerSeat() {
        return pricePerSeat;
    }

    /**
     * Sets the value of the pricePerSeat property.
     * 
     */
    public void setPricePerSeat(double value) {
        this.pricePerSeat = value;
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
     * Gets the value of the departureTime property.
     * 
     */
    public double getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the value of the departureTime property.
     * 
     */
    public void setDepartureTime(double value) {
        this.departureTime = value;
    }

    /**
     * Gets the value of the arrivalTime property.
     * 
     */
    public double getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the value of the arrivalTime property.
     * 
     */
    public void setArrivalTime(double value) {
        this.arrivalTime = value;
    }

}
