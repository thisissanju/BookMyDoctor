package com.cg.bmd.service;

import java.util.List;

import com.cg.bmd.dto.AppointmentDTO;

public interface IAppointmentService {

	/*
	 *
	 * @Author : Pradhyumn Sharma Description : Appointment service interface added
	 * Created : 07-06-2021 Last Modified : 08-06-2021
	 *
	 */

	public AppointmentDTO addAppointment(AppointmentDTO appointmentDto);

	// public Appointment addAppointment(Appointment appointment);
	public List<AppointmentDTO> getAllAppointments();

	public AppointmentDTO getAppointmentById(int appointmentId);

	public void deleteAppointmentById(int appointmentId);

	public void deleteAppointmentsByDoctorId(int doctorId);

	public void deleteAppointmentByPatientId(int patientId);

	public AppointmentDTO updateAppointment(AppointmentDTO appointmentDto);

	public List<AppointmentDTO> getAppointmentsByDoctor(int doctorId);

	List<AppointmentDTO> getAppointmentsByDate(String string);

	AppointmentDTO approveAppointment(int patientId);

	AppointmentDTO cancelAppointment(int patientId);

	String getAppointmentStatus(int patientId);

}
