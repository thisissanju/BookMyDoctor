package com.cg.bmd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.cg.bmd.dto.AvailabilityDateDTO;
import com.cg.bmd.dto.DoctorDTO;
import com.cg.bmd.exception.DoctorException;
import com.cg.bmd.service.IDoctorService;

@RestController
@RequestMapping("/bmd/doctor")
public class DoctorController {

	/*
	 *
	 * @Author : Shivam Singh Description : Doctor controller added Created :
	 * 06-06-2021 Last Modified : 08-06-2021 Parameters : DoctorDTO Return type :
	 * DoctorDTO/String/List<DoctorDTO>
	 *
	 */

	@Autowired
	IDoctorService service;

	// AvailabilityDateDTO availabilityDateDto;

	Logger logger = LoggerFactory.getLogger(DoctorController.class);

	@PostMapping("/add")
	public DoctorDTO addDoctor(@RequestBody DoctorDTO doctorDto) {
		service.addDoctor(doctorDto);
		return doctorDto;
	}

	@PostMapping("/addavailability")
	public DoctorDTO addAvailability(@RequestBody AvailabilityDateDTO availabilityDateDto) {
		logger.info("Availability add for doctor " + availabilityDateDto.getDoctorDto().getDoctorId());
		return service.addAvailability(availabilityDateDto);
	}

	@GetMapping("/login/{email}/{password}")
	public String login(@PathVariable("email") String email, @PathVariable("password") String password) {
		return service.login(email, password);
	}

	@GetMapping("/getbyid/{doctorId}")
	public DoctorDTO getDoctorById(@PathVariable("doctorId") int doctorId) throws DoctorException {
		DoctorDTO doctorDto = service.getDoctorById(doctorId);
		if (doctorDto == null) {
			logger.error("DoctorController : Doctor with given id not found!!");
			throw new DoctorException("DoctorController : Doctor with given id not found!!");
		} else {
			logger.info("Fetching doctor by id " + doctorId);
		}
		return doctorDto;
	}

	@GetMapping("/getlist")
	public List<DoctorDTO> getDoctorList() throws DoctorException {
		List<DoctorDTO> doctorDtoList = service.getDoctorList();
		return doctorDtoList;
	}

	@GetMapping("/getbyspeciality/{speciality}")
	public List<DoctorDTO> getDoctorListBySpeciality(@PathVariable("speciality") String speciality)
			throws DoctorException {
		List<DoctorDTO> doctorDtoList = service.getDoctorBySpeciality(speciality);
		return doctorDtoList;
	}

	@GetMapping("/getbyname/{name}")
	public List<DoctorDTO> getDoctorByName(@PathVariable("name") String doctorName) throws DoctorException {
		List<DoctorDTO> doctorDto = service.getDoctorByName(doctorName);
		return doctorDto;
	}

	@PutMapping("/updateprofile")
	public DoctorDTO updateDoctor(@RequestBody DoctorDTO doctorDto) throws DoctorException {
		doctorDto = service.updateDoctorProfile(doctorDto);
		if (doctorDto == null) {
			logger.info("Failed to update doctor");
			throw new DoctorException("Failed to update doctor");
		} else
			return doctorDto;
	}

	@DeleteMapping("/deletedoctorbyid/{doctorId}")
	public String removeDoctorById(@PathVariable("doctorId") int doctorId) throws DoctorException {
		logger.warn("Doctor deleted with id " + doctorId);
		return service.removeDoctorById(doctorId);
	}
	
	@GetMapping("/getbylocation/{location}")
	public List<DoctorDTO> getDoctorListByLocation(@PathVariable("location") String location) 
			throws DoctorException {
		List<DoctorDTO> doctorDtoList = service.findDoctorByLocation(location);
		return doctorDtoList;
	}
	
	@GetMapping("/getbyspecialityandlocation/{speciality}/{location}")
	public List<DoctorDTO> getDoctorListBySpecialityAndLocation(@PathVariable("speciality") String speciality, 
			@PathVariable("location") String location) 
			throws DoctorException {
		List<DoctorDTO> doctorDtoList = service.findDoctorBySpecialityAndLocation(speciality, location);
		return doctorDtoList;
	}
	
	@GetMapping("/getbyspecialityandlocationandhospitalname/{speciality}/{location}/{hospitalName}")
	public List<DoctorDTO> getDoctorListBySpecialityAndLocationAndHospitalName(@PathVariable("speciality") String speciality, 
			@PathVariable("location") String location, @PathVariable("hospitalName") String hospitalName) 
			throws DoctorException {
		List<DoctorDTO> doctorDtoList = service.findDoctorBySpecialityAndLocationAndHospital(speciality, location, hospitalName);
		return doctorDtoList;
	}
	
	@GetMapping("/getbyspecialityandhospitalname/{speciality}/{hospitalName}")
	public List<DoctorDTO> getDoctorListBySpecialityAndHospitalName(@PathVariable("speciality") String speciality, 
			@PathVariable("hospitalName") String hospitalName) 
			throws DoctorException {
		List<DoctorDTO> doctorDtoList = service.findDoctorBySpecialityAndHospitalName(speciality, hospitalName);
		return doctorDtoList;
	}
	

}
