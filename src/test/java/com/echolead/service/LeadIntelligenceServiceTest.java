package com.echolead.service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class LeadIntelligenceServiceTest {
 @Test void analysisProducesScoreAndStatus() {
  var result = new LeadIntelligenceService().analyze("I am interested and want to book a demo");
  assertTrue((Integer)result.get("score") >= 0);
  assertTrue((Integer)result.get("score") <= 100);
  assertNotNull(result.get("status"));
  assertNotNull(result.get("nextAction"));
 }
 @Test void negativeWordsAreDetected() {
  var result = new LeadIntelligenceService().analyze("I am frustrated with this problem");
  assertEquals("Negative", result.get("sentiment"));
 }
}
