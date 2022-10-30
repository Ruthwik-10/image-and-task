package com.springbootdemo.crudExample.service;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springbootdemo.crudExample.entity.Profile;
import com.springbootdemo.crudExample.repository.ProfileRepository;


@Service
public class ProfileService {
    @Autowired
    private ProfileRepository repository;
    
    
    public void uploadProfile(int profileId ,String name, MultipartFile file) throws IOException
    {
    
        Profile profile=new Profile();
        String fileName=file.getOriginalFilename();
        if(fileName.contains("..")) {
            System.out.println("Not a valid File");
        }
        profile.setProfileId(profileId);
        profile.setName(name);
        profile.setImage(file.getBytes());
        repository.save(profile);
    }

    public Profile saveProfile(Profile profile) {

    	return repository.save(profile);
			
//		} catch (IllegalArgumentException e) {
//			throw new BusinessException("602","Object shouldn't be empty"+e.getMessage());
//			
//		}
//    	catch(Exception e)
//    	{
//    		throw new BusinessException("603","Problem with service layer"+e.getMessage());
//    	}
    	
    }

    public List<Profile> saveProfiles(List<Profile> profile) {
        return repository.saveAll(profile);
    }

    public List<Profile> getProfiles() {
        return repository.findAll();
    }

    public Profile getProfileById(int id) {
        return repository.findById(id).orElse(null);
    }
    
//
//    public Optional<Profile> getProfileByName(String name) {
//        return repository.findByName(name);
//    }
    

    public String deleteProfile(int id) {
        repository.deleteById(id);
        return "Profile Removed !! " + id;
    }
    
//    public List<Profile> getProfileByRole(String role)
//    {
//    	return repository.findByRole(role);
//    }

    public Profile updateProfile(Profile profile) {
        Profile existingProfile = repository.findById(profile.getProfileId()).orElse(null);
        existingProfile.setName(profile.getName());
//        existingProfile.setRole(profile.getRole());
        return repository.save(existingProfile);
    }


}