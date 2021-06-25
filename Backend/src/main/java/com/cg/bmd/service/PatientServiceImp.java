package com.cg.bmd.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.dto.PatientDTO;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.PatientException;
import com.cg.bmd.repository.IAppointmentRepository;
import com.cg.bmd.repository.IFeedbackRepository;
import com.cg.bmd.repository.IPatientRepository;
import com.cg.bmd.utils.Util;

@Service
public class PatientServiceImp implements IPatientService {

	/*
	 *
	 * @Author1 : Chetna
	 * 
	 * @Author2 : Shireesha Uppari Description : Service implmentation for Patient
	 * Created : 06-06-2021 Last Modified : 07-06-2021
	 *
	 */

	@Autowired
	IPatientRepository repo;

	@Autowired
	IAppointmentRepository appointmentRepository;

	@Autowired
	IFeedbackRepository feedbackRepository;

	Logger logger = LoggerFactory.getLogger(IPatientService.class);

	@Override
	public PatientDTO addPatient(PatientDTO patientDto) throws PatientException {
		boolean validPhone = ValidationService.validatePhone(patientDto.getPatientPhone());
		boolean validEmail = ValidationService.validateEmail(patientDto.getEmail());
		boolean validGender = ValidationService.validateGender(patientDto.getGender());

		if (validPhone && validGender && validEmail) {
			Patient patient = Util.PatientDtoToEntity(patientDto);
			patient = repo.save(patient);
			logger.info("Patient added successfully");
			return Util.PatientEntityToDto(patient);
		}

		if (validPhone == false)
			logger.error("Please enter valid phone number");

		if (validEmail == false)
			logger.error("Please enter valid email");

		if (validGender == false)
			logger.error("Please enter valid gender");

		else {
			throw new PatientException("Patient not added");
		}
		return null;
	}

	@Override
	public PatientDTO editPatient(PatientDTO patientDto) throws PatientException {
		Patient patient = Util.PatientDtoToEntity(patientDto);
		patient = repo.save(patient);
		return Util.PatientEntityToDto(patient);
	}

	@Override
	public String removePatientById(int patientId) throws PatientException {
		Patient patient = repo.findById(patientId).orElse(null);
		if (patient == null) {
			logger.error("Patient with given id not found!!");
			throw new PatientException("Patient with given id not found!!");
		}
		appointmentRepository.deleteByPatient(patientId);
		feedbackRepository.deleteByPatient(patientId);
		repo.deleteById(patientId);
		logger.warn("Patient deleted");
		return "Deleted";
	}

	@Override
	public PatientDTO getPatientById(int patientId) throws PatientException {
		Patient patient = repo.findById(patientId).orElse(null);
		if (patient == null) {
			logger.error("Patient with given id not found!!");
			throw new PatientException("Patient with given id not found!!");
		}
		return Util.PatientEntityToDto(patient);
	}

	@Override
	public List<PatientDTO> getAllPatients() throws PatientException {
		List<Patient> patientList = repo.findAll();
		if (patientList.isEmpty()) {
			logger.error("No patients in DB");
			throw new PatientException("No patients in DB");
		}
		return Util.PatientEntityToDtoList(patientList);
	}

	@Override
	public List<PatientDTO> getPatientListByDoctor(int doctorId) throws PatientException {
		List<Patient> patientList = repo.getPatientListByDoctorId(doctorId);
		if (patientList.isEmpty()) {
			logger.error("No patients found for given doctor id");
			throw new PatientException("No patients found for given doctor id");
		}
		return Util.PatientEntityToDtoList(patientList);
	}

	@Override
	public List<PatientDTO> getPatientListByDate(String date) throws PatientException {
		LocalDate appointmentDate = LocalDate.parse(date);
		List<Patient> patientList = repo.getPatientListByAppointmentDate(appointmentDate);
		if (patientList.isEmpty()) {
			logger.error("No patients for given date");
			throw new PatientException("No patients for given date");
		}
		return Util.PatientEntityToDtoList(patientList);
	}

	@Override
	public String login(String email, String password) throws PatientException {
		String result = repo.findPasswordByEmail(email);
		if (!result.equals(password)) {
			logger.error("Login failed!! Wrong credentials");
			throw new PatientException("Login failed!! Wrong credentials");
		}
		return "Logged In";
	}

}
