package com.cg.bmd.service;

import java.util.List;

import com.cg.bmd.dto.FeedbackDTO;
import com.cg.bmd.exception.FeedbackException;

public interface IFeedbackService {

	/*
	 *
	 * @Author : Pradhyumn Sharma Description : Service interface for Feedback added
	 * Created : 08-06-2021 Last Modified : ------
	 *
	 */

	FeedbackDTO addFeedback(FeedbackDTO feedbackDto) throws FeedbackException;

	FeedbackDTO getFeedbackById(int feedbackId) throws FeedbackException;

	List<FeedbackDTO> getAllFeedbacksByDoctorId(int doctorId) throws FeedbackException;

}
