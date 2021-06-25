package com.cg.bmd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.bmd.dto.FeedbackDTO;
import com.cg.bmd.exception.FeedbackException;
import com.cg.bmd.service.IFeedbackService;

@RestController
@RequestMapping("bmd/feedback")
public class FeedbackController {

	/*
	 *
	 * @Author : Pradhyumn Sharma Description : Controller for Feedback added
	 * Created : 08-06-2021 Last Modified : 09-06-2021 Parameters : FeedbackDTO
	 * Return type : FeedbackDTO
	 *
	 */

	@Autowired
	IFeedbackService service;

	Logger logger = LoggerFactory.getLogger(IFeedbackService.class);

	@PostMapping("/add")
	public FeedbackDTO addFeedback(@RequestBody FeedbackDTO feedbackDto) throws FeedbackException {
		feedbackDto = service.addFeedback(feedbackDto);
		if (feedbackDto != null) {
			logger.info("Feedback added");
			return feedbackDto;
		}
		return null;
	}

	@GetMapping("get/feedbackbyid/{id}")
	public FeedbackDTO getFeedback(@PathVariable("id") int feedbackId) throws FeedbackException {
		return service.getFeedbackById(feedbackId);
	}

	@GetMapping("get/feedbacksbydoctorid/{id}")
	public List<FeedbackDTO> getFeedbacksByDoctor(@PathVariable("id") int doctorId) throws FeedbackException {
		return service.getAllFeedbacksByDoctorId(doctorId);
	}

}
