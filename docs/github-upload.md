# Upload EchoLead AI to GitHub

## Option A — GitHub website (quickest)
1. Sign in to GitHub and click **New repository**.
2. Repository name: `EchoLead-AI` (or another name you choose).
3. Choose Public or Private; for an interview portfolio, Public is useful if you are comfortable sharing the source.
4. Do not initialize with a README, license, or .gitignore because these are already in this project.
5. Extract the ZIP, open the `EchoLead-AI` folder, and upload its files and folders to the new repository. Ensure `src`, `frontend`, `docs`, `pom.xml`, `README.md`, and `LICENSE` are included.
6. Commit with message: `Initial commit: EchoLead AI Java MVP`.

## Option B — Git command line
Run these commands in the extracted project folder (replace the remote URL with your repository URL):

```bash
git init
git add .
git status
git commit -m "Initial commit: EchoLead AI Java MVP"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/EchoLead-AI.git
git push -u origin main
```

Review `git status` before committing. Never commit `.env`, API keys, credentials, private customer data, or generated database files.
