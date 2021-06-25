package com.cg.bmd.service;

import com.cg.bmd.dto.AdminDTO;
import com.cg.bmd.exception.AdminException;

public interface IAdminService {

	/*
	 *
	 * @Author : Sanjay Kumar Description : Admin service interface added Created :
	 * 07-06-2021 Last Modified : ------ Parameters : AdminDTO/adminId/String Return
	 * types : AdminDTO/String/
	 *
	 */

	AdminDTO addAdmin(AdminDTO adminDto) throws AdminException;

	void removeAdminById(int AdminId) throws AdminException;

	AdminDTO updateAdmin(AdminDTO adminDto) throws AdminException;

	AdminDTO getAdminById(int adminId) throws AdminException;

	String login(String email, String password) throws AdminException;
}
