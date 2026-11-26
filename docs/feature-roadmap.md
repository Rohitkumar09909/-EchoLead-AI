# Feature coverage and roadmap

## MVP code included
- Spring Boot REST backend and web dashboard
- Local response fallback plus optional LLM API integration
- Conversation context sent from the browser (session-level memory)
- Rule-based lead score, status, sentiment, objection, next-action
- CRM leads create/list/delete
- Appointment create/list
- Knowledge document storage and keyword retrieval
- Analytics dashboard
- Browser speech recognition/synthesis; voice language selection (Hindi and English options, browser support varies)

## Remaining to reach production-grade
1. Build and test locally; repair any compile/runtime issues.
2. Add real multilingual language detection and robust speech provider integration.
3. Implement semantic RAG (chunking, embeddings, vector database, citations, file uploads).
4. Implement opt-in persistent memory, customer consent and deletion controls.
5. Add auth, role/tenant separation, TLS, rate limiting, secret management and audit controls.
6. Add unit/integration/UI tests and report measured results.
7. Containerize, add CI, cloud deployment, monitoring and backups.
8. Load-test realistic concurrency; do not claim capacity until measured.
