package medical.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.Month;
import java.time.Year;
import java.util.Date;

public class InformationPeople {
    private int id;
    private String name;
    private Year yearOfBirth;
    private String gender;
    private String nationality;
    private String creditId;
    private String vehicle;
    private String numberVehicle;
    private String numberLocate;
//    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayEnd;
    private String cityTravel;
    private String cityAddress;
    private String districtAddress;
    private String wardAddress;
    private String address;
    private String phone;
    private String email;

    public InformationPeople() {
    }

    public InformationPeople(String name, Year yearOfBirth, String gender, String nationality, String creditId, String vehicle, String numberVehicle, String numberLocate, Date dayStart, Date dayEnd, String cityTravel, String cityAddress, String districtAddress, String wardAddress, String address, String phone, String email) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.creditId = creditId;
        this.vehicle = vehicle;
        this.numberVehicle = numberVehicle;
        this.numberLocate = numberLocate;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.cityTravel = cityTravel;
        this.cityAddress = cityAddress;
        this.districtAddress = districtAddress;
        this.wardAddress = wardAddress;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public InformationPeople(int id, String name, Year yearOfBirth, String gender, String nationality, String creditId, String vehicle, String numberVehicle, String numberLocate, Date dayStart, Date dayEnd, String cityTravel, String cityAddress, String districtAddress, String wardAddress, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.creditId = creditId;
        this.vehicle = vehicle;
        this.numberVehicle = numberVehicle;
        this.numberLocate = numberLocate;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.cityTravel = cityTravel;
        this.cityAddress = cityAddress;
        this.districtAddress = districtAddress;
        this.wardAddress = wardAddress;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Year yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(String numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public String getNumberLocate() {
        return numberLocate;
    }

    public void setNumberLocate(String numberLocate) {
        this.numberLocate = numberLocate;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getCityTravel() {
        return cityTravel;
    }

    public void setCityTravel(String cityTravel) {
        this.cityTravel = cityTravel;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public String getDistrictAddress() {
        return districtAddress;
    }

    public void setDistrictAddress(String districtAddress) {
        this.districtAddress = districtAddress;
    }

    public String getWardAddress() {
        return wardAddress;
    }

    public void setWardAddress(String wardAddress) {
        this.wardAddress = wardAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
