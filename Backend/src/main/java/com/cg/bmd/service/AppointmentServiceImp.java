package com.cg.bmd.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.bmd.dto.AppointmentDTO;
import com.cg.bmd.entities.Appointment;
import com.cg.bmd.exception.AppointmentException;
import com.cg.bmd.repository.IAppointmentRepository;
import com.cg.bmd.utils.Util;

@Service
public class AppointmentServiceImp implements IAppointmentService {

	/*
	 *
	 * @Author : Pradhyumn Sharma Description : Service implementation for
	 * Appointment Created : 07-06-2021 Last Modified : 09-06-2021
	 *
	 */

	@Autowired
	IAppointmentRepository repo;

	Logger logger = LoggerFactory.getLogger(IAppointmentService.class);

	@Override
	public AppointmentDTO addAppointment(AppointmentDTO appointmentDto) throws AppointmentException {
		Appointment appointment = Util.AppointmentDtoToEntity(appointmentDto);
		return Util.AppointmentEntityToDto(repo.save(appointment));
	}

	@Override
	public List<AppointmentDTO> getAllAppointments() throws AppointmentException {
		List<Appointment> appointments = repo.findAll();
		if (appointments.isEmpty()) {
			logger.error("No appointments in DB");
			throw new AppointmentException("No appointments in DB");
		}
		return Util.AppointmentEntityToDtoList(appointments);
	}

	@Override
	public AppointmentDTO getAppointmentById(int appointmentId) throws AppointmentException {
		Appointment appointment = repo.findById(appointmentId).orElse(null);
		if (appointment == null) {
			logger.error("Appointment not found with given id");
			throw new AppointmentException("Appointment not found with given id");
		}
		return Util.AppointmentEntityToDto(appointment);
	}

	@Override
	public void deleteAppointmentById(int appointmentId) throws AppointmentException {
		Appointment appointment = repo.findById(appointmentId).orElse(null);
		if (appointment == null) {
			logger.error("Appointment not found with given id");
			throw new AppointmentException("Appointment not found with given id");
		}
		repo.deleteById(appointmentId);
		logger.warn("Removing Appointment");
	}

	@Override
	public AppointmentDTO updateAppointment(AppointmentDTO appointmentDto) throws AppointmentException {
		Appointment appointment = repo.findById(appointmentDto.getAppointmentId()).orElse(null);
		if (appointment == null) {
			logger.error("Appointment not found with given id");
			throw new AppointmentException("Appointment not found with given id");
		}
		appointment = Util.AppointmentDtoToEntity(appointmentDto);
		Appointment appointments = repo.save(appointment);
		return Util.AppointmentEntityToDto(appointments);
	}

	@Override
	public List<AppointmentDTO> getAppointmentsByDoctor(int doctorId) throws AppointmentException {
		List<Appointment> appointments = repo.findAppointmentByDoctor(doctorId);
		if (appointments.isEmpty()) {
			logger.error("No appointments for given doctor found");
			throw new AppointmentException("No appointments for given doctor found");
		}
		return Util.AppointmentEntityToDtoList(appointments);
	}

	@Override
	public List<AppointmentDTO> getAppointmentsByDate(String date) throws AppointmentException {
		List<Appointment> appointments;
		boolean validDate = ValidationService.validateDate(LocalDate.parse(date));
		if (validDate == false) {
			logger.error("Date format wrong. Must be (yyyy-mm-dd)");
			throw new AppointmentException("Date format wrong. Must be (yyy-mm-dd)");
		}
		appointments = repo.findAppointmentByAppointmentDate(LocalDate.parse(date));
		if (appointments.isEmpty()) {
			logger.error("No appointments for given date found");
			throw new AppointmentException("No appointments for date doctor found");
		}
		return Util.AppointmentEntityToDtoList(appointments);
	}

	@Override
	public AppointmentDTO approveAppointment(int patientId) throws AppointmentException {
		Appointment appointment = repo.findByPatientId(patientId);
		if (appointment == null) {
			logger.error("Appointment for given id not found");
			throw new AppointmentException("Appointment for given id not found");
		}
		appointment.setStatus("Approved");
		return Util.AppointmentEntityToDto(repo.save(appointment));
	}

	@Override
	public AppointmentDTO cancelAppointment(int patientId) throws AppointmentException {
		Appointment appointment = repo.findByPatientId(patientId);
		if (appointment == null) {
			logger.error("Appointment for given id not found");
			throw new AppointmentException("Appointment for given id not found");
		}
		appointment.setStatus("Cancelled");
		return Util.AppointmentEntityToDto(repo.save(appointment));
	}

	@Override
	public void deleteAppointmentsByDoctorId(int doctorId) throws AppointmentException {
		List<Appointment> appointments = repo.findAppointmentByDoctor(doctorId);
		if (appointments.isEmpty()) {
			logger.error("Appointments for given id not found");
			throw new AppointmentException("Appointments for given id not found");
		}
		repo.deleteAppointmentByDoctor(doctorId);
	}

	@Override
	public void deleteAppointmentByPatientId(int patientId) throws AppointmentException {
		Appointment appointment = repo.findByPatientId(patientId);
		if (appointment == null) {
			logger.error("Appointment for given id not found");
			throw new AppointmentException("Appointment for given id not found");
		}
		repo.deleteAppointmentByPatient(patientId);
	}

	@Override
	public String getAppointmentStatus(int patientId) throws AppointmentException {
		if (repo.existsByPatientId(patientId) == null) {
			logger.error("Patient for given id not found");
			throw new AppointmentException("Patient for given id not found");
		}
		return repo.findStatusByPatientId(patientId);
	}

}
