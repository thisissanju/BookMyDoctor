package com.cg.bmd.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class DoctorDTO {

	/*
	 *
	 * @Author1 : Shivam Singh
	 * 
	 * @Author2 : Pradhyumn Sharma Description : Doctor Dto added Created :
	 * 05-06-2021 Last Modified : 06-06-2021
	 *
	 */

	// attributes

	private int doctorId;
	private String doctorName;
	private String doctorPhone;
	private int chargePerVisit;
	private String hospitalName;
	private String speciality;
	private String location;

	private String email; // credentials for login
	private String password;

	List<AppointmentDTO> appointmentDtoList;

	@JsonIgnore
	AvailabilityDateDTO availabilityDateDto;

	@JsonIgnore
	List<FeedbackDTO> feedbackDtoList;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public int getChargePerVisit() {
		return chargePerVisit;
	}

	public void setChargePerVisit(int chargePerVisit) {
		this.chargePerVisit = chargePerVisit;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public AvailabilityDateDTO getAvailabilityDateDto() {
		return availabilityDateDto;
	}

	public void setAvailabilityDateDto(AvailabilityDateDTO availabilityDateDto) {
		this.availabilityDateDto = availabilityDateDto;
	}

	@Override
	public String toString() {
		return "DoctorDTO [doctorName=" + doctorName + ", doctorPhone=" + doctorPhone + ", chargePerVisit="
				+ chargePerVisit + ", location=" + location + ", availabilityDateDto=" + availabilityDateDto + "]";
	}

}
