import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    char correctOption; // 'A', 'B', 'C', or 'D'

    public Question(String questionText, String[] options, char correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = Character.toUpperCase(correctOption);
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == correctOption;
    }
}

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create list of questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                new String[]{"A) Berlin", "B) Madrid", "C) Paris", "D) Rome"}, 'C'));
        questions.add(new Question("Which language is used for Android app development?",
                new String[]{"A) Java", "B) Swift", "C) C#", "D) Ruby"}, 'A'));
        questions.add(new Question("Which company developed Java?",
                new String[]{"A) Microsoft", "B) Sun Microsystems", "C) Google", "D) Oracle"}, 'B'));

        // Step 2: Quiz logic
        int score = 0;
        System.out.println("===== Welcome to the Online Quiz =====");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);
            for (String opt : q.options) {
                System.out.println(opt);
            }
            System.out.print("Your answer (A/B/C/D): ");
            char answer = sc.next().charAt(0);

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.correctOption);
            }
        }

        // Step 3: Final result
        System.out.println("\n===== Quiz Over =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("🏆 Excellent! Perfect score!");
        } else if (score >= questions.size() / 2) {
            System.out.println("👍 Good job! Keep practicing.");
        } else {
            System.out.println("📚 Needs improvement. Study more!");
        }

        sc.close();
    }
}

