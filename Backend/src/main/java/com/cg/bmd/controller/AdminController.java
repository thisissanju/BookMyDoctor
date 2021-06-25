package com.cg.bmd.controller;

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

import com.cg.bmd.dto.AdminDTO;
import com.cg.bmd.exception.AdminException;
import com.cg.bmd.service.IAdminService;

@RestController
@RequestMapping("/bmd/admin")
public class AdminController {

	/*
	 *
	 * @Author : Sanjay Kumar Description : Admin controller added Created :
	 * 07-06-2021 Last Modified : 08-06-2021 Parameters : Admin Dto Return type :
	 * Admin Dto
	 *
	 */

	@Autowired
	IAdminService service;

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@PostMapping("/add")
	public AdminDTO addAdmin(@RequestBody AdminDTO adminDto) throws AdminException {
		adminDto = service.addAdmin(adminDto);
		if (adminDto != null) {
			logger.info("Admin added");
			return adminDto;
		}
		return null;
	}

	@GetMapping("/login/{email}/{password}")
	public String login(@PathVariable("email") String email, @PathVariable("password") String password)
			throws AdminException {
		return service.login(email, password);
	}

	@GetMapping("/getbyid/{id}")
	public AdminDTO getAdmin(@PathVariable("id") int adminId) throws AdminException {
		return service.getAdminById(adminId);
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteAdmin(@PathVariable("id") int adminId) throws AdminException {
		logger.warn("Admin deleted with id " + adminId);
		service.removeAdminById(adminId);
	}

	@PutMapping("/updateadmin")
	public AdminDTO updateAdmin(@RequestBody AdminDTO adminDto) throws AdminException {
		adminDto = service.updateAdmin(adminDto);
		if (adminDto != null) {
			logger.info("Admin updated");
			return adminDto;
		}
		return null;
	}

}
