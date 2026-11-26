# EchoLead AI — Autonomous Multilingual Sales Agent (Java MVP)

EchoLead AI is a portfolio MVP for a sales assistant that can chat, use browser-based voice features, retrieve answers from a small knowledge base, estimate lead intent, save leads to a CRM-style list, schedule appointments, and display basic analytics.

> **Project status:** prototype / MVP starter. The source is packaged for GitHub, but this environment did not have Maven installed, so the project has not been compiled or test-run here. Please run the build and smoke tests locally before presenting it as verified.

## Highlights
- Java 21 + Spring Boot REST backend
- HTML/CSS/JavaScript dashboard
- H2 database for local prototype persistence
- Chat with local fallback and optional OpenAI-compatible API configuration
- Browser speech recognition and text-to-speech (browser/locale support varies)
- Rule-based lead scoring, sentiment indicator, objection detection, and next-action suggestion
- CRM lead create/list/delete endpoints
- Appointment create/list endpoints
- Knowledge-document storage with keyword retrieval (RAG-style MVP, **not** semantic vector search)
- Analytics endpoint/dashboard
- Architecture diagrams, interview demo script, one-page project report, and roadmap

## Demo workflow
Customer asks a question → agent answers using available knowledge/demo logic → lead intelligence estimates priority → lead can be saved → appointment can be scheduled → analytics summarize the demo data.

## Tech stack
| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 3 |
| API | REST / JSON |
| Persistence | Spring Data JPA, H2 (prototype) |
| Frontend | HTML, CSS, JavaScript |
| Voice | Browser Web Speech APIs (support varies) |
| AI | Optional OpenAI-compatible endpoint; local demo fallback |
| Build | Maven |

## Prerequisites
- Java 21 (JDK)
- Maven 3.9+
- Chrome or Edge recommended for browser voice features

## Run backend
From the repository root:

```bash
mvn test
mvn spring-boot:run
```

Backend API base: `http://localhost:8080/api`

## Run frontend
Open `frontend/index.html` in a browser. If local-file browser restrictions prevent API calls, serve it:

```bash
python -m http.server 5500 --directory frontend
```

Then visit `http://localhost:5500`.

## Optional AI configuration
Set provider credentials in your local environment only. Do not commit API keys.

macOS/Linux:
```bash
export OPENAI_API_KEY="your-key"
export AI_MODEL="gpt-4o-mini"
mvn spring-boot:run
```

PowerShell:
```powershell
$env:OPENAI_API_KEY="your-key"
$env:AI_MODEL="gpt-4o-mini"
mvn spring-boot:run
```

Without the API key, the app uses its local demo fallback. External API usage may cost money; review provider pricing and permissions first. `.env.example` is a placeholder reference, not a secret file.

## API endpoints
| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/chat` | Send a chat message and optional history |
| GET | `/api/leads` | List CRM leads |
| POST | `/api/leads` | Create a lead |
| DELETE | `/api/leads/{id}` | Delete a lead |
| GET | `/api/appointments` | List appointments |
| POST | `/api/appointments` | Book an appointment |
| GET | `/api/knowledge` | List knowledge documents |
| POST | `/api/knowledge` | Add knowledge document |
| GET | `/api/analytics` | Retrieve dashboard metrics |

Example chat request:
```json
{
  "message": "What plans do you offer?",
  "history": ""
}
```

Example appointment request:
```json
{
  "leadName": "Demo Customer",
  "email": "demo@example.com",
  "topic": "Product walkthrough",
  "scheduledAt": "2026-12-01T15:00:00"
}
```

## GitHub upload
See [`docs/github-upload.md`](docs/github-upload.md) for website upload and Git command instructions.

## Interview presentation
See [`docs/demo-script.md`](docs/demo-script.md), [`docs/one-page-report.md`](docs/one-page-report.md), and the diagrams in `docs/`.

## Limitations / next steps
- No user authentication, authorization, or tenant isolation yet; use demo data only.
- No production security/privacy review, consent flow, or data-retention policy.
- Browser voice is not a real-time telephony/streaming voice stack and support varies.
- Conversation context is client/session-based, not durable customer memory.
- Knowledge retrieval is keyword-based, not embeddings/vector semantic RAG.
- Lead score and sentiment are heuristic estimates, not validated predictive models.
- Appointment booking is local prototype scheduling, not connected to calendar providers.
- Starter tests are included but were not run in this environment.
- The 100k-user architecture is a scaling design proposal, not a tested capacity claim.

## License
MIT. See [`LICENSE`](LICENSE).
