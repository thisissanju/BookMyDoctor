package com.cg.bmd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.bmd.dto.AppointmentDTO;

import com.cg.bmd.service.IAppointmentService;

@RestController
@RequestMapping("/bmd/appointment")
public class AppointmentController {

	/*
	 *
	 * @Author : Pradhyumn Sharma Description : Appointment controller added Created
	 * : 07-06-2021 Last Modified : 09-06-2021 Parameters :
	 * AppointmentDTO/patientId/doctorId Return types :
	 * AppointmentDTO/List<AppointmentDTO>
	 *
	 */

	@Autowired
	IAppointmentService service;

	Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	@PostMapping("/add")
	public AppointmentDTO addAppointmentDto(@RequestBody AppointmentDTO appointmentDto) {
		logger.info("Appointment Added");
		return service.addAppointment(appointmentDto);
	}

	@GetMapping("/getlist")
	public List<AppointmentDTO> getAllAppointments() {
		logger.info("Fetching all appointments");
		return service.getAllAppointments();
	}

	@GetMapping("/getstatus/{patientId}")
	public String getAppointmentStatus(@PathVariable("patientId") int patientId) {
		return service.getAppointmentStatus(patientId);
	}

	@GetMapping("get/appointmentbyid/{id}")
	public AppointmentDTO getAppointmentById(@PathVariable("id") int appointmentId) {
		logger.info("Fetching appointment with id " + appointmentId);
		return service.getAppointmentById(appointmentId);
	}

	@GetMapping("get/appointmentbydate/{date}")
	public List<AppointmentDTO> getAppointmentByDate(@PathVariable("date") String date) {
		logger.info("Fetching appointments for date " + date);
		return service.getAppointmentsByDate(date);
	}

	@GetMapping("get/appointmentbydoctorid/{id}")
	public List<AppointmentDTO> getAppointmentByDoctorId(@PathVariable("id") int doctorId) {
		logger.info("Fetching appointments for doctor id " + doctorId);
		return service.getAppointmentsByDoctor(doctorId);
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteAppointmentById(@PathVariable("id") int appointmentId) {
		logger.warn("Appointment deleted with id " + appointmentId);
		service.deleteAppointmentById(appointmentId);
	}

	@PutMapping("/update")
	public AppointmentDTO updateAppointment(@RequestBody AppointmentDTO appointmentDto) {
		logger.info("Updated");
		return service.updateAppointment(appointmentDto);
	}

	@PutMapping("/cancel/{patientId}")
	public AppointmentDTO cancelAppointment(@PathVariable("patientId") int patientId) {
		AppointmentDTO appointmentDto = service.cancelAppointment(patientId);
		logger.warn("Appointment cancelled for patient id " + patientId);
		return appointmentDto;
	}

	@PutMapping("/approve/{patientId}")
	public AppointmentDTO approveAppointment(@PathVariable("patientId") int patientId) {
		AppointmentDTO appointmentDto = service.approveAppointment(patientId);
		logger.info("Appointment approved for patient id " + patientId);
		return appointmentDto;
	}

}
