package com.edu.CollegeManagementApp.service;

import java.util.List;

import com.edu.CollegeManagementApp.entity.Announcement;

public interface AnnouncementService {

	void saveAnnouncement(Announcement ann);

	
	List<Announcement> getAllAnnounce();

	void deleteAnnouncement(long id);
	

}
