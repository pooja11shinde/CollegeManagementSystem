package com.edu.CollegeManagementApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.CollegeManagementApp.entity.Announcement;

public interface AnnouncementRepository  extends JpaRepository<Announcement, Long>{

}
