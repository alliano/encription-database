package com.databaseconverter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.databaseconverter.models.entities.UserDetail;
import com.databaseconverter.services.UserDetailService;

public @RestController @RequestMapping(path = "/",method = RequestMethod.GET) class UserDetailController {
   
   private @Autowired UserDetailService userDetailService;

   
   public @PostMapping(path = "") UserDetail save(@RequestBody UserDetail userdetail ) {

      return userDetailService.save(userdetail);

   }

   public @GetMapping(path = "") List<UserDetail> findAll(){
      
      return userDetailService.findAll();

   }
}
