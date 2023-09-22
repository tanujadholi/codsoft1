import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String questionText;
    String[] options;
    int correctAnswer;

    public QuizQuestion(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        QuizQuestion[] questions = {
            new QuizQuestion("Which feature of OOP indicates code reusability?", new String[]{"Abstraction", "Polymorphism", "Encapsulation", "Inheritance"}, 3),
            new QuizQuestion("Which keyword should be used to declare static variables?", new String[]{"Const", "Common", "Static", "stat"}, 2),
            new QuizQuestion("Which of the following is not an OOPS concept?", new String[]{"Encapsulation", "Polymorphism", "Exception", "Inheritance"}, 2),
            new QuizQuestion("Which class cannot create its instance?", new String[]{"Parent class", "Abstract class", "Nested class", "Anonymous class"}, 1),
            new QuizQuestion("Java supports Multiple Inheritance", new String[]{"True", "False", }, 1),
        };

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            QuizQuestion question = questions[i];

            System.out.println("Question " + (i + 1) + ": " + question.questionText);

            for (int j = 0; j < question.options.length; j++) {
                System.out.println((j + 1) + ". " + question.options[j]);
            }

            final Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                int time = 10; 

                @Override
                public void run() {
                    if (time > 0) {
                        // System.out.println("Time remaining: " + time + " seconds");
                        time--;
                    } else {
                        System.out.println("Time's up!");
                        timer.cancel(); // Stop the timer

                    }
                }
            };

            timer.schedule(task, 0, 1000); 

            System.out.print("Enter your answer (1-" + question.options.length + "): ");
            int userAnswer = scanner.nextInt();

            timer.cancel();

            if (userAnswer == question.correctAnswer + 1) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + (question.correctAnswer + 1) + "\n");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + " out of " + questions.length);

        scanner.close();
    }
}
