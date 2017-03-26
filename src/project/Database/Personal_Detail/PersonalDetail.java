package project.Database.Personal_Detail;
import java.io.Serializable;
/**
 * Created by Osama Khaliq
 * Edited by Aman Gohel on 23/03/2017
 *
 * Version (03/03/2016)
 * PersonalDetail object Class
 *
 * @Author Osama Khaliq
 * @version (25/03/2017)
 */
public class PersonalDetail implements Serializable {
    private String username;
    private String surname;
    private String name;
    private String DOB;
    private String address;
    private String townCity;
    private String county;
    private String postcode;
    private String telephoneNumber;
    private String mobileNumber;
    private String emergencyContactName;
    private String emergencyContactNumber;

    /**
     * Constructor class
     * Empty
     */
    public PersonalDetail()
    {

    }
    /**
     * getUsername
     * @return gets username
     */
    public String getUsername() {
        return username;
    }
    /**
     * setUsername
     * @param username sets the username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * getSurname
     * @return gets surname
     */
    public String getSurname() {
        return surname;
    }
    /**
     * setSurname
     * @param surname sets the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * getName
     * @return gets name
     */
    public String getName() {
        return name;
    }
    /**
     * setName
     * @param name sets name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getDOB
     * @return gets DOB
     */
    public String getDOB() {
        return DOB;
    }
    /**
     * setDOB
     * @param DOB sets the date of birth
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    /**
     * getAddress
     * @return gets address
     */
    public String getAddress() {
        return address;
    }
    /**
     * setAddress
     * @param address sets the address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * getTownCity
     * @return gets the town city
     */
    public String getTownCity() {
        return townCity;
    }
    /**
     * setTownCity
     * @param townCity sets the city
     */
    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }
    public String getCounty() {
        return county;
    }
    /**
     * setCounty
     * @param county sets the county
     */
    public void setCounty(String county) {
        this.county = county;
    }
    /**
     * getPostcode
     * @return gets the postcode
     */
    public String getPostcode() {
        return postcode;
    }
    /**
     * setPostcode
     * @param postcode sets the postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    /**
     * getTelephoneNumber
     * @return gets telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    /**
     * setTelephoneNumber
     * @param telephoneNumber sets the telephone number
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    /**
     * getMobileNumber
     * @return gets mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }
    /**
     * setMobileNumber
     * @param mobileNumber sets the mobile number
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    /**
     * getEmergencyContactName
     * @return gets emergencyContactName
     */
    public String getEmergencyContactName() {
        return emergencyContactName;
    }
    /**
     * setEmergencyContactName
     * @param emergencyContactName sets the emergency contact
     */
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }
    /**
     * getEmergencyContactNumber
     * @return gets emergencyContactNumber
     */
    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }
    /**
     * setEmergencyContactNumber
     * @param emergencyContactNumber sets the emergency contact number
     */
    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }
}