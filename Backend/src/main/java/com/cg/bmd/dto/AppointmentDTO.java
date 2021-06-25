package com.cg.bmd.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class AppointmentDTO {

	/*
	 *
	 * @Author : Pradhyumn Sharma Description : Appointment Dto added Created :
	 * 07-06-2021 Last Modified : -------
	 *
	 */

	private int appointmentId;
	private LocalDate appointmentDate;
	private DoctorDTO doctorDto;
	private PatientDTO patientDto;
	private String status = "Pending";
	private String remark;

	public AppointmentDTO() {
	}

	public AppointmentDTO(LocalDate appointmentDate, PatientDTO patient, String status, String remark) {
		this.appointmentDate = appointmentDate;
		this.patientDto = patient;
		this.status = status;
		this.remark = remark;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public DoctorDTO getDoctorDto() {
		return doctorDto;
	}

	public void setDoctorDto(DoctorDTO doctorDto) {
		this.doctorDto = doctorDto;
	}

	public PatientDTO getPatientDto() {
		return patientDto;
	}

	public void setPatientDto(PatientDTO patientDto) {
		this.patientDto = patientDto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "AppointmentDTO [appointmentId=" + appointmentId + ", doctorDto=" + doctorDto + ", patientDto="
				+ patientDto + "]";
	}

}
