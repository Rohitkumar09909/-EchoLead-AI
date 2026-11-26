package com.echolead.service;
import com.echolead.model.KnowledgeDocument; import com.echolead.repository.KnowledgeRepository;
import org.springframework.stereotype.Service; import java.util.*;
@Service
public class KnowledgeService {
 private final KnowledgeRepository repo;
 public KnowledgeService(KnowledgeRepository repo){this.repo=repo;}
 public KnowledgeDocument add(String title,String content){return repo.save(new KnowledgeDocument(title,content));}
 public List<KnowledgeDocument> all(){return repo.findAll();}
 public String retrieve(String query){
  List<String> terms=Arrays.stream(query.toLowerCase().split("\\W+")).filter(s->s.length()>2).toList();
  return repo.findAll().stream().map(d->Map.entry(d,terms.stream().filter(t->d.getContent().toLowerCase().contains(t)).count()))
   .filter(e->e.getValue()>0).sorted(Map.Entry.<KnowledgeDocument,Long>comparingByValue().reversed()).limit(2)
   .map(e->"["+e.getKey().getTitle()+"] "+e.getKey().getContent()).reduce((a,b)->a+"\\n"+b).orElse("");
 }
}
