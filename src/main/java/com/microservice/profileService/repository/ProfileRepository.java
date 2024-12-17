package com.microservice.profileService.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.microservice.profileService.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
