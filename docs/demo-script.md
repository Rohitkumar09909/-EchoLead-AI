# Interview Demo Script (5–7 minutes)

1. **Problem (30 sec):** Sales teams miss leads, repeat questions, and manually write follow-up notes.
2. **Architecture (45 sec):** Browser UI → Spring Boot REST API → agent service, lead-intelligence service, knowledge service, repositories → H2 database. Explain the optional LLM provider and local fallback.
3. **Customer conversation (90 sec):** Ask a product/service question. Demonstrate the answer, voice input/output if supported, and language selection.
4. **Lead intelligence (60 sec):** Explain how interest and buying signals affect the heuristic lead score; show sentiment, objection, and suggested next action.
5. **CRM and appointment (60 sec):** Save a lead, view it in CRM, create an appointment, and show summary/analytics.
6. **RAG caveat (30 sec):** Explain that this MVP uses keyword matching over knowledge documents; semantic embeddings and vector retrieval are a future enhancement.
7. **Scale & safety (60 sec):** Explain the production-scale diagram: gateway, stateless service replicas, queue, Redis, PostgreSQL, vector store, observability. Clarify that the diagram is a design proposal and has not been load-tested.
8. **Close (30 sec):** State what you'd improve next: auth/consent, persistent conversation memory, semantic RAG, test coverage, deployment and load testing.

Use sample/demo data only. Do not add real people's personal information to a public demo.
