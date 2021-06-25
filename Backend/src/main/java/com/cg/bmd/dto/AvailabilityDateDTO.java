package com.cg.bmd.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component // remove if not adding data
public class AvailabilityDateDTO {

	/*
	 *
	 * @Author1 : Shivam Singh
	 * 
	 * @Author2 : Pradhyumn Sharma Description : Dto for AvailabilityDate Added
	 * Created : 05-06-2021 Last Modified : 06-06-2021
	 *
	 */

	private int availabilityId;
	private DoctorDTO doctorDto;
	private LocalDate fromDate;
	private LocalDate endDate;

	public AvailabilityDateDTO() {
	}

	public AvailabilityDateDTO(DoctorDTO doctorDto) {
		this.doctorDto = doctorDto;
	}

	public AvailabilityDateDTO(LocalDate fromDate, LocalDate endDate, DoctorDTO doctorDto) {
		this.fromDate = fromDate;
		this.endDate = endDate;
		this.doctorDto = doctorDto;
	}

	public int getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public DoctorDTO getDoctorDto() {
		return doctorDto;
	}

	public void setDoctorDto(DoctorDTO doctorDto) {
		this.doctorDto = doctorDto;
	}

	@Override
	public String toString() {
		return "AvailabilityDateDTO [availabilityId=" + availabilityId + ", doctorDto=" + doctorDto + ", fromDate="
				+ fromDate + ", endDate=" + endDate + "]";
	}

}
