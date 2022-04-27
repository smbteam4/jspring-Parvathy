package com.saviour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saviour.entity.Resources;

public interface ResourceRepository  extends JpaRepository<Resources, Integer> {

}
