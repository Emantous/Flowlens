# Contributing to Flowlens

Thanks for your interest! Issues and pull requests are welcome.

## Workflow

1. Open or pick an [issue](https://github.com/Emantous/flowlens/issues) and say you are working on it.
2. Fork the repo and create a short-lived branch from `main`, for example `feat/bottleneck-heatmap` or `fix/event-timezone`.
3. Make small, focused changes. One pull request should do one thing.
4. Make sure everything passes locally (see below).
5. Open a pull request against `main` and link the issue.

`main` is protected. A pull request can only be merged when all CI checks pass and it has been reviewed.

## Commit messages

Use [Conventional Commits](https://www.conventionalcommits.org/). They drive versioning and release notes.

```
feat: add hourly bottleneck endpoint
fix: handle events with missing timestamps
docs: explain simulator options
test: cover late-order calculation
```

Use `feat!:` or a `BREAKING CHANGE:` footer for incompatible changes.

## Before you open a pull request

```bash
# API
cd api && ./mvnw verify

# Insight service and simulator
cd insight && pytest
cd simulator && pytest
```

- Add or update tests for any behaviour you change.
- Keep formatting and lint clean (Spotless, Checkstyle, ruff). CI will fail otherwise.
- Update the docs or README if the change is visible to users.
- For larger decisions, add a short note to `docs/adr/` explaining why.

## Reporting bugs and ideas

Open an issue with the steps to reproduce, what you expected and what happened. For ideas, describe the problem you want solved before the solution.

## Security

Please do not open public issues for security problems. Use GitHub's private vulnerability reporting under the repo's **Security** tab.