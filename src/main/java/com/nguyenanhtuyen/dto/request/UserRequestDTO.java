package com.nguyenanhtuyen.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nguyenanhtuyen.util.EnumPattern;
import com.nguyenanhtuyen.util.EnumValue;
import com.nguyenanhtuyen.util.Gender;
import com.nguyenanhtuyen.util.GenderSubset;
import com.nguyenanhtuyen.util.PhoneNumber;
import com.nguyenanhtuyen.util.UserStatus;
import com.nguyenanhtuyen.util.UserType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserRequestDTO implements Serializable {

	@NotBlank(message = "firstName is required")
	private String firstName;
	
	@NotNull(message = "lastName must be not null")
	private String lastName;
	
	//@Pattern(regexp = "^\\d{10}$", message = "phone invalid format")
	@PhoneNumber
	private String phone;
	
	@Email(message = "email invalid format")
	private String email;
	
	@NotNull(message = "dateOfBirth must be not null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date dateOfBirth;
	
	@NotNull(message = "username must be not null")
	private String username;
	
	@NotNull(message = "password must be not null")
	private String password;
	
	@EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
	private UserStatus status;
	
	@GenderSubset(anyOf = {Gender.MALE, Gender.FEMALE, Gender.OTHER})
	private Gender gender;
	
	@NotNull(message = "type must be not null")
	@EnumValue(name = "type", enumClass = UserType.class)
	private String type;
	
	@NotEmpty(message = "address can not empty")
	private Set<Address> address;
	
	public UserRequestDTO(String firstName, String lastName, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
	
	public static class Address {
		private String apartmentNumber;
		private String floor;
		private String building;
		private String streetNumber;
		private String street;
		private String city;
		private String country;
		private Integer addressType;
		
		public String getApartmentNumber() {
			return apartmentNumber;
		}
		
		public void setApartmentNumber(String apartmentNumber) {
			this.apartmentNumber = apartmentNumber;
		}
		
		public String getFloor() {
			return floor;
		}
		
		public void setFloor(String floor) {
			this.floor = floor;
		}
		
		public String getBuilding() {
			return building;
		}
		
		public void setBuilding(String building) {
			this.building = building;
		}
		
		public String getStreetNumber() {
			return streetNumber;
		}
		
		public void setStreetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
		}
		
		public String getStreet() {
			return street;
		}
		
		public void setStreet(String street) {
			this.street = street;
		}
		
		public String getCity() {
			return city;
		}
		
		public void setCity(String city) {
			this.city = city;
		}
		
		public String getCountry() {
			return country;
		}
		
		public void setCountry(String country) {
			this.country = country;
		}
		
		public Integer getAddressType() {
			return addressType;
		}
		
		public void setAddressType(Integer addressType) {
			this.addressType = addressType;
		}
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public String getType() {
		return type;
	}

}
