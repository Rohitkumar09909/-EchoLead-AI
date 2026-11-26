package com.echolead.repository;
import com.echolead.model.KnowledgeDocument; import org.springframework.data.jpa.repository.JpaRepository;
public interface KnowledgeRepository extends JpaRepository<KnowledgeDocument,Long>{}
