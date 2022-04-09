package com.edu.CollegeManagementApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.CollegeManagementApp.entity.Announcement;
import com.edu.CollegeManagementApp.repository.AnnouncementRepository;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	
	AnnouncementRepository annRepo;
	

	public AnnouncementServiceImpl(AnnouncementRepository annRepo) {
		super();
		this.annRepo = annRepo;
	}

	@Override
	public void saveAnnouncement(Announcement ann) {
		annRepo.save(ann);
		
	}

	
	@Override
	public List<Announcement> getAllAnnounce() {
		List<Announcement> anns = annRepo.findAll();
		return anns;
	}

	@Override
	public void deleteAnnouncement(long id) {
		annRepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}
	
	
	

}
