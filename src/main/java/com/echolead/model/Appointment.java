package com.echolead.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity
public class Appointment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String leadName; private String email; private String topic; private LocalDateTime scheduledAt;
 public Appointment(){}
 public Appointment(String leadName,String email,String topic,LocalDateTime scheduledAt){this.leadName=leadName;this.email=email;this.topic=topic;this.scheduledAt=scheduledAt;}
 public Long getId(){return id;} public String getLeadName(){return leadName;} public String getEmail(){return email;}
 public String getTopic(){return topic;} public LocalDateTime getScheduledAt(){return scheduledAt;}
}
