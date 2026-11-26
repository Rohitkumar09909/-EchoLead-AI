package com.echolead.service;
import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient; import java.util.*;
@Service
public class AgentService {
 private final KnowledgeService knowledge;
 @Value("${echolead.ai.api-key:}") private String apiKey;
 @Value("${echolead.ai.base-url:https://api.openai.com/v1}") private String baseUrl;
 @Value("${echolead.ai.model:gpt-4o-mini}") private String model;
 public AgentService(KnowledgeService knowledge){this.knowledge=knowledge;}
 public String respond(String message,String history){
  String context=knowledge.retrieve(message);
  if(apiKey!=null&&!apiKey.isBlank()){
   try {
    Map<String,Object> body=Map.of("model",model,"messages",List.of(
     Map.of("role","system","content","You are EchoLead AI, a helpful multilingual sales assistant. Be transparent, never invent product facts. Use retrieved context when present. Context: "+context+" Conversation history: "+history),
     Map.of("role","user","content",message)));
    Map response=RestClient.create(baseUrl).post().uri("/chat/completions").header("Authorization","Bearer "+apiKey).body(body).retrieve().body(Map.class);
    List choices=(List)response.get("choices"); Map choice=(Map)choices.get(0); Map msg=(Map)choice.get("message"); return String.valueOf(msg.get("content"));
   } catch(Exception e){return localReply(message,context)+" (AI API unavailable; local mode used.)";}
  }
  return localReply(message,context);
 }
 private String localReply(String m,String context){
  String t=m.toLowerCase();
  if(!context.isBlank())return "Based on the available knowledge base: "+context+"\nWhat would you like to know next?";
  if(t.contains("price")||t.contains("cost"))return "I can help you compare options and explain the value. Please share which product or plan you are interested in, and I can guide you. (Demo response)";
  if(t.contains("appointment")||t.contains("book")||t.contains("demo"))return "I can help arrange a demo or appointment. Please share your preferred date and time. (Demo response)";
  if(t.contains("hello")||t.contains("hi")||t.contains("namaste"))return "Hello! Welcome to EchoLead AI. How can I help you today? You can ask about products, pricing, or request a demo.";
  return "Thanks for sharing. I can help understand your needs, answer questions from the knowledge base, and suggest a next step. Could you tell me a little more? (Local demo mode)";
 }
}
