package com.cg.bmd.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class PatientDTO {

	/*
	 *
	 * @Author1 : Chetna
	 * 
	 * @Author2 : Shireesha Uppari Description : Dto Class for Patient Created :
	 * 05-06-2021 Last Modified : 06-06-2021
	 *
	 */

	// attributes

	private int patientId;
	private String patientName;
	private String patientPhone;
	private String address;
	private String gender;
	int age;

	private String email; // credentials for login
	private String password;

	@JsonIgnore
	AppointmentDTO appointmentDto;

	@JsonIgnore
	FeedbackDTO feedbackDto;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AppointmentDTO getAppointmentDto() {
		return appointmentDto;
	}

	public void setAppointmentDto(AppointmentDTO appointmentDto) {
		this.appointmentDto = appointmentDto;
	}

	@Override
	public String toString() {
		return "PatientDTO [patientId=" + patientId + ", patientName=" + patientName + ", gender=" + gender
				+ ", appointmentDto=" + appointmentDto + "]";
	}

}
