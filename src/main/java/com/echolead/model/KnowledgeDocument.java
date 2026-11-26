package com.echolead.model;
import jakarta.persistence.*;
@Entity
public class KnowledgeDocument {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String title;
 @Column(length=100000) private String content;
 public KnowledgeDocument(){}
 public KnowledgeDocument(String title,String content){this.title=title;this.content=content;}
 public Long getId(){return id;} public String getTitle(){return title;} public String getContent(){return content;}
}
