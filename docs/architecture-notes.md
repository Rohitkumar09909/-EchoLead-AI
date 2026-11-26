# System Architecture Notes

## Current prototype (modular monolith)
A single Spring Boot Java application exposes REST endpoints. The services are separated by responsibilities:
- AgentService: response generation; optional API-backed LLM, otherwise local deterministic demo
- KnowledgeService: keyword retrieval from stored documents
- LeadIntelligenceService: score, sentiment, objection and next action
- ApiController: REST endpoints and orchestration
- JPA repositories: persistence to H2

## Production scale target (100,000 registered users)
Registered users are not equivalent to concurrent calls. For a production design:
1. CDN serves frontend assets; API Gateway/load balancer distributes requests.
2. Horizontally scale stateless Java service replicas.
3. PostgreSQL for CRM/appointment data; Redis for session/cache/rate limits.
4. Queue (Kafka/RabbitMQ) for call summaries, follow-ups, analytics and transcription jobs.
5. Vector database for embeddings and semantic retrieval (e.g., pgvector).
6. Voice provider / streaming STT-TTS services for real-time voice; separate worker pools.
7. Monitoring, tracing, alerting, autoscaling and backup/restore testing.

## Security and privacy
- Keep API keys in environment secrets; never commit them.
- Add login, role-based access and tenant isolation before production.
- Obtain consent before recording/transcribing; disclose AI voice agent.
- Minimize collected data; define retention and deletion policies.
- TLS, encryption at rest, input validation, rate limits, audit logs and secure backups.
- The MVP has no authentication and should only be used with demo data.
