package com.cg.bmd.dto;

import org.springframework.stereotype.Component;

@Component
public class FeedbackDTO {

	/*
	 *
	 * @Author : Pradhyumn Sharma Description : Dto for Feedback added Created :
	 * 08-06-2021 Last Modified : -------
	 *
	 */

	private int feedbackId;
	private int rating;
	private String feedback;
	private DoctorDTO doctorDto;
	private PatientDTO patientDto;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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

}
