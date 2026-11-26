package com.echolead.controller;
import com.echolead.model.*; import com.echolead.repository.*; import com.echolead.service.*;
import org.springframework.web.bind.annotation.*; import java.time.LocalDateTime; import java.util.*;
@RestController @RequestMapping("/api")
@CrossOrigin(origins="*")
public class ApiController {
 private final LeadRepository leads; private final AppointmentRepository appointments; private final KnowledgeService knowledge;
 private final AgentService agent; private final LeadIntelligenceService intelligence;
 public ApiController(LeadRepository l,AppointmentRepository a,KnowledgeService k,AgentService g,LeadIntelligenceService i){leads=l;appointments=a;knowledge=k;agent=g;intelligence=i;}
 @PostMapping("/chat") public Map<String,Object> chat(@RequestBody Map<String,String> body){
  String message=body.getOrDefault("message",""); String history=body.getOrDefault("history","");
  Map<String,Object> analysis=intelligence.analyze(message); String reply=agent.respond(message,history);
  return Map.of("reply",reply,"analysis",analysis,"summary",summary(message,reply));
 }
 @GetMapping("/leads") public List<Lead> listLeads(){return leads.findAll();}
 @PostMapping("/leads") public Lead createLead(@RequestBody Map<String,String> b){
  Lead l=new Lead(b.getOrDefault("name","Unknown"),b.get("email"),b.get("phone"),b.get("interest"));
  Map<String,Object> a=intelligence.analyze(Objects.toString(l.getInterest(),""));
  l.setScore((Integer)a.get("score"));l.setStatus((String)a.get("status"));l.setSentiment((String)a.get("sentiment"));
  l.setNextAction((String)a.get("nextAction"));l.setSummary("Interest: "+l.getInterest()+" | "+l.getSentiment()+" sentiment");
  return leads.save(l);
 }
 @DeleteMapping("/leads/{id}") public void deleteLead(@PathVariable Long id){leads.deleteById(id);}
 @GetMapping("/appointments") public List<Appointment> listAppointments(){return appointments.findAll();}
 @PostMapping("/appointments") public Appointment book(@RequestBody Map<String,String>b){
  return appointments.save(new Appointment(b.getOrDefault("leadName","Guest"),b.get("email"),b.getOrDefault("topic","Demo"),LocalDateTime.parse(b.get("scheduledAt"))));
 }
 @GetMapping("/knowledge") public List<KnowledgeDocument> docs(){return knowledge.all();}
 @PostMapping("/knowledge") public KnowledgeDocument addDoc(@RequestBody Map<String,String>b){return knowledge.add(b.getOrDefault("title","Untitled"),b.getOrDefault("content",""));}
 @GetMapping("/analytics") public Map<String,Object> analytics(){
  List<Lead> all=leads.findAll(); long hot=all.stream().filter(l->"Hot".equals(l.getStatus())).count();
  long warm=all.stream().filter(l->"Warm".equals(l.getStatus())).count();long cold=all.stream().filter(l->"Cold".equals(l.getStatus())).count();
  double avg=all.stream().mapToInt(l->l.getScore()==null?0:l.getScore()).average().orElse(0);
  return Map.of("total",all.size(),"hot",hot,"warm",warm,"cold",cold,"averageScore",Math.round(avg));
 }
 private String summary(String q,String a){return "Customer asked: "+q+" | Agent response: "+a.substring(0,Math.min(120,a.length()))+"...";}
}
