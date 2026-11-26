package com.echolead.service;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class LeadIntelligenceService {
 private static final List<String> HOT=List.of("buy","purchase","ready","book","demo","today","interested","price","sign up","enroll");
 private static final List<String> NEG=List.of("angry","bad","disappointed","problem","not happy","frustrated","complaint");
 private static final List<String> POS=List.of("great","good","thanks","excellent","interested","love");
 public Map<String,Object> analyze(String text){
  String t=text.toLowerCase(Locale.ROOT); int score=35;
  for(String word:HOT) if(t.contains(word)) score+=7;
  for(String word:NEG) if(t.contains(word)) score-=10;
  for(String word:POS) if(t.contains(word)) score+=5;
  score=Math.max(0,Math.min(100,score));
  String status=score>=70?"Hot":score>=40?"Warm":"Cold";
  String sentiment=NEG.stream().anyMatch(t::contains)?"Negative":POS.stream().anyMatch(t::contains)?"Positive":"Neutral";
  String objection=t.contains("price")||t.contains("expensive")?"Price":t.contains("time")||t.contains("later")?"Timing":t.contains("trust")?"Trust":"None detected";
  String action=status.equals("Hot")?"Offer a demo or booking option":status.equals("Warm")?"Share relevant details and follow up":"Provide helpful information; avoid pressure";
  Map<String,Object> result=new LinkedHashMap<>(); result.put("score",score);result.put("status",status);result.put("sentiment",sentiment);result.put("objection",objection);result.put("nextAction",action);return result;
 }
}
