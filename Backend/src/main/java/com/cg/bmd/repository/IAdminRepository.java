package com.cg.bmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bmd.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	
	/*
	 *
	 * @Author : Sanjay Kumar
	 * Description : Admin repository added
	 * Created : 07-06-2021
	 * Last Modified : 08-06-2021
	 *
	 */
	
	@Query("select a.password from Admin a where a.email=?1")
	String findPasswordByEmail(String email);
	
	@Query(value="select * from admins fetch first 1 rows only",nativeQuery=true)
	public Admin findFirstRow();


}
