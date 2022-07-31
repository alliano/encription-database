package com.databaseconverter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databaseconverter.models.entities.UserDetail;
import com.databaseconverter.models.repositories.UserDetailRepository;


public @Service class UserDetailService {
   
   private @Autowired UserDetailRepository userDetailRepository;

   public UserDetail save(UserDetail userDetail){

      return userDetailRepository.save(userDetail);

   }

   public List<UserDetail> findAll(){

      return userDetailRepository.findAll();
      
   }
}
