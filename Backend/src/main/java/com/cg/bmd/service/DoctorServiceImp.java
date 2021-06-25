package com.cg.bmd.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.bmd.dto.AvailabilityDateDTO;
import com.cg.bmd.dto.DoctorDTO;
import com.cg.bmd.entities.AvailabilityDate;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.exception.DoctorException;
import com.cg.bmd.repository.IAppointmentRepository;
import com.cg.bmd.repository.IAvailabilityDateRepository;
import com.cg.bmd.repository.IDoctorRepository;
import com.cg.bmd.repository.IFeedbackRepository;
import com.cg.bmd.utils.Util;

@Service
public class DoctorServiceImp implements IDoctorService {

	/*
	 *
	 * @Author1 : Shivam Singh
	 * 
	 * @Author2 : Pradhyumn Sharma Description : Service implementation for Doctor
	 * Created : 06-06-2021 Last Modified : 07-06-2021
	 *
	 */

	@Autowired
	IDoctorRepository doctorRepository;

	@Autowired
	IAppointmentRepository appointmentRepository;

	@Autowired
	IAvailabilityDateRepository availabilityDateRepository;

	@Autowired
	IFeedbackRepository feedbackRepository;

	Logger logger = LoggerFactory.getLogger(DoctorServiceImp.class);

	@Override
	public DoctorDTO addDoctor(DoctorDTO doctorDto) throws DoctorException {
		boolean validPhone = ValidationService.validatePhone(doctorDto.getDoctorPhone());
		boolean validEmail = ValidationService.validateEmail(doctorDto.getEmail());
		boolean validPassword = ValidationService.validatePassword(doctorDto.getPassword());
		Doctor doctor = null;
		if (validPhone && validEmail)
			doctor = doctorRepository.save(Util.DoctorDtoToEntity(doctorDto));

		else if (!validPhone)
			logger.warn("Please enter valid phone number");

		else if (!validEmail)
			logger.warn("Please enter valid email");

		else if (!validPassword)
			logger.warn("Please enter valid password");

		return Util.DoctorEntityToDto(doctor);
	}

	@Override
	public DoctorDTO updateDoctorProfile(DoctorDTO doctorDto) throws DoctorException {
		if (!doctorRepository.existsById(doctorDto.getDoctorId())) {
			logger.warn("No doctor found with given id");
			throw new DoctorException("No doctor found with given id");
		}
		Doctor doctor = Util.DoctorDtoToEntity(doctorDto);
		doctor = doctorRepository.save(doctor);
		return Util.DoctorEntityToDto(doctor);
	}

	@Override
	public List<DoctorDTO> getDoctorByName(String name) throws DoctorException {
		boolean validName = ValidationService.validateName(name);
		if (!validName) {
			logger.warn("Incorrect characters in name");
			throw new DoctorException("Incorrect characters in name");
		}
		List<Doctor> doctorList = doctorRepository.findByDoctorName(name);
		if (doctorList.isEmpty()) {
			logger.warn("No doctor found with given name");
			throw new DoctorException("No doctor found with given name in DB");
		}
		return Util.DoctorEntityToDtoList(doctorList);
	}

	@Override
	public DoctorDTO addAvailability(AvailabilityDateDTO availabilityDateDto) throws DoctorException {
		AvailabilityDate date = Util.AvailabilityDateDtoToEntity(availabilityDateDto);
		LocalDate end = date.getEndDate();
		LocalDate from = date.getFromDate();
		if (from.compareTo(end) > 0) {
			logger.warn("End date should be greater than from date");
			throw new DoctorException("End date should be greater than from date");
		}
		availabilityDateRepository.save(date);
		try {
			return Util.AvailabilityDateEntityToDto(date).getDoctorDto();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	/*
	 * @Override public DoctorDTO updateAvailability(AvailabilityDateDTO
	 * availabilityDateDto) throws DoctorException { return null; }
	 */

	@Override
	public DoctorDTO getDoctorById(int id) throws DoctorException {
		Doctor doctor = doctorRepository.findById(id).orElse(null);
		if (doctor == null) {
			logger.warn("No doctor found with given id");
			throw new DoctorException("NotFound!! Check id agaain");
		}
		return Util.DoctorEntityToDto(doctor);
	}

	@Override
	public String removeDoctorById(int doctorId) throws DoctorException {
		Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
		if (doctor == null) {
			logger.warn("No doctor found with given id");
			throw new DoctorException("NotFound!! Check doctor id again");
		}
		appointmentRepository.deleteByDoctor(doctorId);
		availabilityDateRepository.deleteDoctor(doctorId);
		feedbackRepository.deleteByDoctor(doctorId);
		doctorRepository.deleteById(doctorId);
		return "Deleted";
	}

	@Override
	public List<DoctorDTO> getDoctorList() throws DoctorException {
		List<Doctor> doctorList = doctorRepository.findAll();
		if (doctorList.isEmpty()) {
			logger.warn("No doctor in database");
			throw new DoctorException("Empty List returned");
		}
		return Util.DoctorEntityToDtoList(doctorList);
	}

	@Override
	public List<DoctorDTO> getDoctorBySpeciality(String speciality) throws DoctorException {
		List<Doctor> doctorList = doctorRepository.findBySpeciality(speciality);
		if (doctorList.isEmpty()) {
			logger.warn("No doctor found with given speciality");
			throw new DoctorException("NotFound!! No doctor with given speciality");
		}
		return Util.DoctorEntityToDtoList(doctorList);
	}

	/*
	 * @Override public Doctor addDoctor(Doctor doctor) { return
	 * doctorRepository.save(doctor); }
	 */

	@Override
	public String login(String email, String password) throws DoctorException {
		String result = doctorRepository.findPasswordByEmail(email);
		if (!result.equals(password)) {
			logger.error("Login failed!! Wrong credentials");
			throw new DoctorException("Login failed!! Wrong credentials");
		}
		return "Logged In";
	}

	@Override
	public DoctorDTO updateAvailability(AvailabilityDateDTO availabilityDateDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
