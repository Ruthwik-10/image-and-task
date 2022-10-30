package com.springbootdemo.crudExample.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.crudExample.entity.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer>{



}
//@Repository
//public interface ProfileRepository extends JpaRepository<Profile, Integer> {
//
////	Profile findByName(String name);
//	public List<Profile> findByRole(String role);
//
//}
