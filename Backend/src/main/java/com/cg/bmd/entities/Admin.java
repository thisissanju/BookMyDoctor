package com.cg.bmd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "admins")
public class Admin {

	/*
	 *
	 * @Author : Sanjay Kumar Description : Admin Entity added Created : 05-06-2021
	 * Last Modified : -------
	 *
	 */

	// attributes

	@Id
	@GeneratedValue(generator = "admin_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "admin_seq", sequenceName = "admin_sequence", allocationSize = 1)
	private int adminId;

	@NotEmpty(message = "Name can't be empty") // validation for name
	private String adminName;

	@NotEmpty(message = "Email can't be empty")
	@Column(unique = true)
	private String email;

	@NotEmpty(message = "Password can't be empty")
	private String password;

	@NotEmpty(message = "Phone can't be empty")
	@Column(unique = true)
	private String adminPhone;

	// getters and setters

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
