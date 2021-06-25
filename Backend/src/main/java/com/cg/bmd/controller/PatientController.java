package com.cg.bmd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bmd.dto.PatientDTO;
import com.cg.bmd.service.IPatientService;

@RestController
@RequestMapping("/bmd/patient")
public class PatientController {

	/*
	 *
	 * @Author1 : Chetna
	 * 
	 * @Author2 : Shireesha Uppari Description : Controller for Patient Created :
	 * 07-06-2021 Last Modified : 09-06-2021 Parameters : PatientDTO Return types :
	 * PatientDTO/String/List<PatientDTO>
	 *
	 */

	@Autowired
	IPatientService service;

	Logger logger = LoggerFactory.getLogger(PatientController.class);

	@PostMapping("/add")
	public PatientDTO addPatient(@RequestBody PatientDTO patientDto) {
		return service.addPatient(patientDto);
	}

	// get mappings
	@GetMapping("/getpatientbyid/{patientId}")
	public PatientDTO getPatientById(@PathVariable("patientId") int patientId) {
		return service.getPatientById(patientId);
	}

	@GetMapping("/login/{email}/{password}")
	public String login(@PathVariable("email") String email, @PathVariable("password") String password) {
		return service.login(email, password);
	}

	@GetMapping("/getlist")
	public List<PatientDTO> getAllPatients() {
		return service.getAllPatients();
	}

	@GetMapping("/getlist/bydoctorid/{doctorId}")
	public List<PatientDTO> getPatientListByDoctor(@PathVariable("doctorId") int doctorId) {
		return service.getPatientListByDoctor(doctorId);
	}

	@GetMapping("/getlist/byappointmentdate/{date}")
	public List<PatientDTO> getPatientListByDate(@PathVariable("date") String appointmentDate) {
		return service.getPatientListByDate(appointmentDate);
	}

	@PutMapping("/update")
	public PatientDTO editPatient(@RequestBody PatientDTO patientDto) {
		return service.editPatient(patientDto);
	}

	@DeleteMapping("/deletebyid/{patientId}")
	public String removePatient(@PathVariable("patientId") int patientId) {
		logger.warn("Patient deleted with id " + patientId);
		service.removePatientById(patientId);
		return "Deleted";
	}
}
