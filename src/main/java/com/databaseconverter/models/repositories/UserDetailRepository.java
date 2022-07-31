package com.databaseconverter.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.databaseconverter.models.entities.UserDetail;

public @Repository interface UserDetailRepository extends JpaRepository<UserDetail, Long> { }
