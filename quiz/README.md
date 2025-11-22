# Quizzes App

A small, delightful Java quiz starter app — clean, tiny, and ready to expand.

Think of this repo as the playground for building quiz experiences: a minimal model for questions, a simple runner, and room to plug in services or a UI.

Why you'll like it
- Minimal and focused: easy to read and extend.
- Practical model: `Question` encapsulates id, text, options and answer.
- Great for learning or quick demos — add a REST layer, CLI, or GUI later.

Quick start

Build and run with the JDK (tested with Java 8+):

```bash
# from the project root (where src/ is located)
javac -d out src/com/quizzes/*.java
java -cp out com.quizzes.Main
```

Project layout

- src/com/quizzes/Main.java — tiny runner
- src/com/quizzes/Question.java — quiz model
- (Add more services under `src/com/quizzes/`)

Next ideas
- Implement `QuestionService` to load questions from JSON or CSV
- Add unit tests and a CI workflow
- Create a simple web front-end or CLI interaction loop

License

MIT — feel free to use, hack, and remix.

Enjoy building something fun with quizzes! 🎯

