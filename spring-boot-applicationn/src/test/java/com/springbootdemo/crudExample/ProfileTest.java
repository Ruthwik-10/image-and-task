package com.springbootdemo.crudExample;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.intThat;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
//import java.util.List;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springbootdemo.crudExample.controller.ProfileController;
import com.springbootdemo.crudExample.entity.Profile;
//import com.springbootdemo.crudExample.entity.Profile;
import com.springbootdemo.crudExample.repository.ProfileRepository;
import com.springbootdemo.crudExample.service.ProfileService;


@SpringBootTest
public class ProfileTest {
	
	@Mock
	private ProfileService profileService;
	
	@InjectMocks
	ProfileController profileController;
	
	
	List<Profile> profiles;
	Profile profile;
	
	@Test
	public void testGetProfiles()
	{
		profiles  = new ArrayList<Profile>();
		profiles.add(new Profile(1,"Saketh"));
		profiles.add(new Profile(2,"Rajesh"));
		when(profileService.getProfiles()).thenReturn(profiles);
		ResponseEntity<List<Profile>> pro = profileController.findAllProfiles();
		
		assertEquals(HttpStatus.FOUND, pro.getStatusCode());
		assertEquals(2,pro.getBody().size());
	
	}
	
	
	@Test
	public void testGetProfileById()
	{
		profile = new Profile(1,"Raju");
		int profileId = 1;
		
		when(profileService.getProfileById(profileId)).thenReturn(profile);
		ResponseEntity<Profile> pro = profileController.findProfileById(profileId);
		assertEquals(HttpStatus.FOUND, pro.getStatusCode());
		assertEquals(1, pro.getBody().getProfileId());
	}
	
	
	@Test
	public void testAddProfile()
	{
		profile  = new Profile(3,"Rajath");
		when(profileService.saveProfile(profile)).thenReturn(profile);
		ResponseEntity<Profile> pro = profileController.addProfile(profile);
		assertEquals(HttpStatus.CREATED,pro.getStatusCode());
		assertEquals(profile, pro.getBody());
		
	}
	
    @Test
    public void testDelete()
    {
    	profile = new Profile(2,"Likith");
    	int profileId  = 2;
    	String str = profileController.deleteProfile(profileId);
    	assertEquals(null, str);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@MockBean
//	private ProfileRepository repository;
	
//	@BeforeEach
//	void setup()
//	{
//		Optional<Profile> profile = Optional.of(new Profile(1, "Yuva"));
//		Mockito.when(repository.findById(1)).thenReturn(profile);
//	}
//	@Test
//	public void testGetProfileById()
//	{
//		String name = "Yuva";
//		Profile profile = profileService.getProfileById(1);
//		assertEquals(name,profile.getName());
//	}
//	
//	

	
//	@Test
//	public void testAddProfile()
//	{
//		Profile p = new Profile();
//		p.setProfileId(7);
//		p.setName("Suvuarn");
//		repository.save(p);
//		assertNotNull(repository.findById(7).get());
//	}
//	
//	@Test
//	public void testReadAll()
//	{
//		List<Profile> list = repository.findAll();
//		assertThat(list).size().isGreaterThan(0);
//	}
//	
//	@Test
//	public void testOneProfile()
//	{
//		 Profile profile = repository.findById(2).get();
//		 assertEquals("Ruthwik",profile.getName());
//	}
//	
//	@Test
//	public void testUpdate()
//	{
//		Profile profile = repository.findById(2).get();
//		profile.setName("Riddi");
//		repository.save(profile);
//		assertNotEquals("Satvik",repository.findById(2).get().getName());
//	}
//	
//	@Test
//	public void testDelete()
//	{
//		repository.deleteById(5);
//		assertThat(repository.existsById(5)).isFalse();
//	}

}
