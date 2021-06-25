package com.cg.bmd.dto;

import org.springframework.stereotype.Component;

@Component
public class AdminDTO {

	/*
	 *
	 * @Author : Sanjay Kumar Description : Admin Dto added Created : 05-06-2021
	 * Last Modified : -------
	 *
	 */

	private int adminId;
	private String adminName;
	private String email;
	private String password;
	private String adminPhone;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

}
