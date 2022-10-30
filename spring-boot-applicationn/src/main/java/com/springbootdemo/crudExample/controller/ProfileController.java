package com.springbootdemo.crudExample.controller;

import java.io.IOException;
import java.util.List;
//import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springbootdemo.crudExample.Exception.CustomException;
import com.springbootdemo.crudExample.Exception.ResourceAlreadyExists;
import com.springbootdemo.crudExample.Exception.ResourceNotFoundException;
import com.springbootdemo.crudExample.Exception.UnauthorizedException;
import com.springbootdemo.crudExample.entity.Profile;
//import com.springbootdemo.crudExample.payload.FileResponse;

import com.springbootdemo.crudExample.service.ProfileService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springbootdemo.crudExample.entity.Profile;
//import com.springbootdemo.crudExample.service.ProfileService;


@RestController
public class ProfileController {

    @Autowired
    private ProfileService service;
    @Autowired
    @Value("S{project.image}")
	private String path; 
    
    Logger logger = LoggerFactory.getLogger(ProfileController.class);
    
    @PostMapping("/upload")
    public String saveProfile(@RequestParam("file") MultipartFile file, @RequestParam String name, @RequestParam int profileId) throws IOException {
        service.uploadProfile(profileId, name, file);
        return "Prolife added";
    }

    @PostMapping("/addProfile")
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
    	try {
    		logger.info("Saving Profile");
    		profile = service.saveProfile(profile);
    		return new ResponseEntity<Profile>(profile,HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
    	
//    	logger.info("Saving Profile");
//        return service.saveProfile(profile);
    }

    @PostMapping("/addProfiles")
    public List<Profile> addProfiles(@RequestBody List<Profile> profiles) {
        return service.saveProfiles(profiles);
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> findAllProfiles() {
    	try {
        	logger.info("Getting Profiles");
			List<Profile>profiles = service.getProfiles();
			return new ResponseEntity<List<Profile>>(profiles,HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

//    	
//        return service.getProfiles();
    }

    @GetMapping("/profileById/{id}")
    public ResponseEntity<Profile> findProfileById(@PathVariable int id) {
    	try {
    		logger.info("Getting Profile with Profile Id");
    		Profile profile = service.getProfileById(id);
    		return new ResponseEntity<Profile>(profile,HttpStatus.FOUND);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
//        return service.getProfileById(id);
    }
//
//    @GetMapping("/profile/{name}")
//    public Profile findProductByName(@PathVariable String name) {
//        return service.getProfileByName(name);
//    }

    @PutMapping("/update")
    public Profile updateProfile(@RequestBody Profile profile) {
    	logger.info("Updating Profile");
        return service.updateProfile(profile);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProfile(@PathVariable int id) {
    	logger.info("Deleting Profile");
        return service.deleteProfile(id);
    }
    
//    @PostMapping("/upload")
//	public ResponseEntity<Profile> fileUpload(@RequestParam("image") MultipartFile image, @RequestParam(name = "name") String name)
//	{
//		
//		String fileName =  this.fileService.uploadImage(path, image);
//		return new ResponseEntity<>(new Profile(fileName,"Image upload success."),HttpStatus.OK);
//	}
//    
//    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
//    @GetMapping("/getProfileByRole/{role}")
//    public List<Profile> getProfileByRole(@PathVariable String role)
//    {
//    	return service.getProfileByRole(role);
//    }
    @RequestMapping(value = "/testExceptionHandling", method = RequestMethod.GET)
    public String testExceptionHandling(@RequestParam int code) {
    	switch (code) {
    	      case 401:
    	    	  throw new UnauthorizedException("You are not authorized");
    	      case 404:
    	    	  throw new ResourceNotFoundException("Requested resource is not found.");
    	      case 400:
    	    	  throw new CustomException("Please provide resource id.");
    	      case 409:
    	    	  throw new ResourceAlreadyExists("Resource already exists in DB.");
    	      default:
    	    	  return "Yeah...No Exception.";
    	 }
    }
}