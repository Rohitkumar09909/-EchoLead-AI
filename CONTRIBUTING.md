# Contributing

Thanks for helping improve EchoLead AI.

## Local setup
1. Install Java 21 and Maven 3.9+.
2. Clone the repository and open its root folder.
3. Run `mvn test` and then `mvn spring-boot:run`.
4. Open `frontend/index.html`, or serve it with `python -m http.server 5500 --directory frontend`.

## Changes
- Keep secrets out of source control. Use environment variables and `.env.example` placeholders.
- Add or update tests for backend changes where practical.
- Describe what changed and how it was tested in your pull request.
- Label AI-generated or heuristic outputs clearly; don't present estimates as verified facts.

## Pull request checklist
- [ ] Builds locally (`mvn test`)
- [ ] No credentials or personal customer data committed
- [ ] README/docs updated if behavior or setup changed
- [ ] Manual UI/API smoke test performed
