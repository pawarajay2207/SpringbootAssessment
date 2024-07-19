package com.project.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.assessment.entity.JsonModel;

public interface JsonModelRepository extends JpaRepository<JsonModel, Long> {
}
