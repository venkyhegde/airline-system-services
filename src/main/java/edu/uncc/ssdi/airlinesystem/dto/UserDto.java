/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.dto;

/**
 * @author venky
 *
 */
public class UserDto {
private int id;
private String firstName;
private String lastName;
private String password;
private String email;
private String address;
private boolean isAdmin;
private String dob;
/**
 * @return the passwrd
 */
public String getPassword() {
	return password;
}
/**
 * @param passwrd the passwrd to set
 */
public void setPassword(String passwrd) {
	this.password = passwrd;
}
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
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}
/**
 * @return the password
 */

/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}
/**
 * @return the isAdmin
 */
public boolean isAdmin() {
	return isAdmin;
}
/**
 * @param isAdmin the isAdmin to set
 */
public void setAdmin(boolean isAdmin) {
	this.isAdmin = isAdmin;
}
/**
 * @return the dob
 */
public String getDob() {
	return dob;
}
/**
 * @param dob the dob to set
 */
public void setDob(String dob) {
	this.dob = dob;
}
}
