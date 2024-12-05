package com.ems.dto;




public class EmployeeDto {
	
	
	    private Long id;
	    private String firstName;
	    private String middleName;
	    private String lastName;
	    private String email;
	    private String mobileNumber;
	    private String dateofbirth;
	    private String gender;
	    private String country;
	    private String picture;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getDateofbirth() {
			return dateofbirth;
		}
		public void setDateofbirth(String dateofbirth) {
			this.dateofbirth = dateofbirth;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public EmployeeDto(Long id, String firstName, String middleName, String lastName, String email,
				String mobileNumber, String dateofbirth, String gender, String country, String picture) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.email = email;
			this.mobileNumber = mobileNumber;
			this.dateofbirth = dateofbirth;
			this.gender = gender;
			this.country = country;
			this.picture = picture;
		}
		public EmployeeDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "EmployeeDto [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
					+ lastName + ", email=" + email + ", mobileNumber=" + mobileNumber + ", dateofbirth=" + dateofbirth
					+ ", gender=" + gender + ", country=" + country + ", picture=" + picture + "]";
		}
	    
	    

}
