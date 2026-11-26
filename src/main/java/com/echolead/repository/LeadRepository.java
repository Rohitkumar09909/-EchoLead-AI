package com.echolead.repository;
import com.echolead.model.Lead; import org.springframework.data.jpa.repository.JpaRepository;
public interface LeadRepository extends JpaRepository<Lead,Long>{}
