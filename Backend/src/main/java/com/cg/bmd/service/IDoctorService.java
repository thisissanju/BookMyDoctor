package com.cg.bmd.service;

import java.util.List;

import com.cg.bmd.dto.AvailabilityDateDTO;
import com.cg.bmd.dto.DoctorDTO;

public interface IDoctorService {

	/*
	 *
	 * @Author1 : Shivam Singh Description : Service interface added for Doctor
	 * Created : 06-06-2021 Last Modified : 07-06-2021
	 *
	 */

	List<DoctorDTO> getDoctorBySpeciality(String speciality);

	DoctorDTO getDoctorById(int id);

	public List<DoctorDTO> getDoctorByName(String name);

	String login(String email, String password);

	List<DoctorDTO> getDoctorList();

	public DoctorDTO addDoctor(DoctorDTO doctorDto);
	// public Doctor addDoctor(Doctor doctor);

	String removeDoctorById(int doctorId);

	DoctorDTO updateDoctorProfile(DoctorDTO doctorDto);

	DoctorDTO updateAvailability(AvailabilityDateDTO availabilityDateDto);

	DoctorDTO addAvailability(AvailabilityDateDTO availabilityDateDto);

}
