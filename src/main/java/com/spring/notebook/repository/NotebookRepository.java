package com.spring.notebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.notebook.entity.Notebooks;


public interface NotebookRepository extends JpaRepository<Notebooks, Long> {

}
