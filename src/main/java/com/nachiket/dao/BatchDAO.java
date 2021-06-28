package com.nachiket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nachiket.model.Batch;

public interface BatchDAO extends JpaRepository<Batch, Integer>{

}
