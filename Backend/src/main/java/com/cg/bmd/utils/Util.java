package com.cg.bmd.utils;

import java.util.*;

import com.cg.bmd.dto.*;
import com.cg.bmd.entities.*;

import org.modelmapper.ModelMapper;

public class Util {

    static ModelMapper modelMapper = new ModelMapper();

    public static Feedback FeedbackDtoToEntity(FeedbackDTO feedbackDto) {
        return modelMapper.map(feedbackDto, Feedback.class);
    }

    public static FeedbackDTO FeedbackEntityToDto(Feedback feedback) {
        return modelMapper.map(feedback, FeedbackDTO.class);
    }

    public static List<FeedbackDTO> FeedbackEntityToDtoList(List<Feedback> feedbackList) {
        List<FeedbackDTO> list = new ArrayList<>();
        for (Feedback temp : feedbackList) {
            list.add(modelMapper.map(temp, FeedbackDTO.class));
        }
        return list;
    }

    public static Admin AdminDtoToEntity(AdminDTO adminDto) {
        return modelMapper.map(adminDto, Admin.class);
    }

    public static AdminDTO AdminEntityToDto(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }

    public static Doctor DoctorDtoToEntity(DoctorDTO doctorDto) {
        return modelMapper.map(doctorDto, Doctor.class);
    }

    public static DoctorDTO DoctorEntityToDto(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    public static Appointment AppointmentDtoToEntity(AppointmentDTO appointmentDto) {
        return modelMapper.map(appointmentDto, Appointment.class);
    }

    public static AppointmentDTO AppointmentEntityToDto(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentDTO.class);
    }

    public static List<AppointmentDTO> AppointmentEntityToDtoList(List<Appointment> appointmentList) {
        List<AppointmentDTO> list = new ArrayList<>();
        for (Appointment temp : appointmentList) {
            list.add(modelMapper.map(temp, AppointmentDTO.class));
        }
        return list;
    }

    public static AvailabilityDate AvailabilityDateDtoToEntity(AvailabilityDateDTO dateDto) {
        return modelMapper.map(dateDto, AvailabilityDate.class);
    }

    public static AvailabilityDateDTO AvailabilityDateEntityToDto(AvailabilityDate date) {
        return modelMapper.map(date, AvailabilityDateDTO.class);
    }

    public static Patient PatientDtoToEntity(PatientDTO patientDto) {
        return modelMapper.map(patientDto, Patient.class);
    }

    public static PatientDTO PatientEntityToDto(Patient patient) {
        return modelMapper.map(patient, PatientDTO.class);
    }

    public static List<PatientDTO> PatientEntityToDtoList(List<Patient> patientList) {
        List<PatientDTO> list = new ArrayList<>();
        for (Patient temp : patientList) {
            list.add(modelMapper.map(temp, PatientDTO.class));
        }
        return list;
    }

    public static List<DoctorDTO> DoctorEntityToDtoList(List<Doctor> doctorList) {
        List<DoctorDTO> list = new ArrayList<>();
        for (Doctor temp : doctorList) {
            list.add(modelMapper.map(temp, DoctorDTO.class));
        }
        return list;
    }

}
