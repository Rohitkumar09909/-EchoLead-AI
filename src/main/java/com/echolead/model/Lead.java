package com.echolead.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Lead {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String name; private String email; private String phone; private String interest;
 private String status="Warm"; private Integer score=50; private String sentiment="Neutral";
 private String summary; private String nextAction; private LocalDateTime createdAt=LocalDateTime.now();
 public Lead(){}
 public Lead(String name,String email,String phone,String interest){this.name=name;this.email=email;this.phone=phone;this.interest=interest;}
 public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getInterest(){return interest;} public void setInterest(String v){interest=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public Integer getScore(){return score;} public void setScore(Integer v){score=v;}
 public String getSentiment(){return sentiment;} public void setSentiment(String v){sentiment=v;}
 public String getSummary(){return summary;} public void setSummary(String v){summary=v;}
 public String getNextAction(){return nextAction;} public void setNextAction(String v){nextAction=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
