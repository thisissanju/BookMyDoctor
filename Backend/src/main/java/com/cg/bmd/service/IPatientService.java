package com.cg.bmd.service;

import java.util.List;

import com.cg.bmd.dto.PatientDTO;

public interface IPatientService {

	/*
	 *
	 * @Author1 : Chetna
	 * 
	 * @Author2 : Shireesha Uppari Description : Added service interface for Patient
	 * Created : 05-06-2021 Last Modified : 06-06-2021
	 *
	 */

	public PatientDTO addPatient(PatientDTO patientDto);

	public PatientDTO editPatient(PatientDTO patientDto);

	public PatientDTO getPatientById(int patientId);

	public List<PatientDTO> getAllPatients();

	public List<PatientDTO> getPatientListByDoctor(int doctorId);

	public List<PatientDTO> getPatientListByDate(String appointmentDate);

	public String removePatientById(int patientId);

	String login(String email, String password);

}
