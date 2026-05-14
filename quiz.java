package ConsoleProjects;
import java.util.Scanner;

public class quiz {

    static int amount = 0;
    static boolean used5050 = false;
    static boolean usedAudience = false;
    static boolean usedSkip = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "Which keyword is used to define a class in Java?",
            "Entry point of Java program?",
            "Which is not a primitive data type?",
            "Same method name with different parameters?",
            "Keyword used for inheritance?",
            "Scanner class belongs to?",
            "Keyword used to inherit class?",
            "Which allows duplicate elements?",
            "Keyword to handle exceptions?",
            "JVM executes bytecode using?"
        };

        String[][] options = {
            {"class","define","struct","object"},
            {"start()","main()","run()","init()"},
            {"int","float","boolean","String"},
            {"Inheritance","Polymorphism","Encapsulation","Abstraction"},
            {"implement","extends","inherit","super"},
            {"java.io","java.util","java.lang","java.net"},
            {"super","this","extends","final"},
            {"Set","Map","List","Tree"},
            {"try","catch","throw","finally"},
            {"Compiler","Interpreter","Loader","Garbage Collector"}
        };

        int[] answers = {1,2,4,2,2,2,3,3,1,2};

        for (int i = 0; i < 10; i++) {

            System.out.println("\nQ" + (i+1) + ": " + questions[i]);

            for (int j = 0; j < 4; j++) {
                System.out.println((j+1) + ". " + options[i][j]);
            }

            if (i < 8) {
                System.out.println("5. Lifeline");
            }
            System.out.println("6. Quit");

            int choice = sc.nextInt();

            // Quit
            if (choice == 6) {
                System.out.println("You quit the game. Amount: ₹" + amount);
                return;
            }

            // Lifeline
            if (choice == 5 && i < 8) {
                System.out.println("1. 50-50\n2. Audience Poll\n3. Skip");
                int l = sc.nextInt();

                switch (l) {
                    case 1:
                        if (!used5050) {
                            used5050 = true;
                            System.out.println("50-50 used. Correct answer is option " + answers[i]);
                        } else {
                            System.out.println("Already used!");
                            i--;
                            continue;
                        }
                        break;

                    case 2:
                        if (!usedAudience) {
                            usedAudience = true;
                            System.out.println("Audience suggests option " + answers[i]);
                        } else {
                            System.out.println("Already used!");
                            i--;
                            continue;
                        }
                        break;

                    case 3:
                        if (!usedSkip) {
                            usedSkip = true;
                            System.out.println("Question skipped!");
                            continue;
                        } else {
                            System.out.println("Already used!");
                            i--;
                            continue;
                        }
                }

                System.out.print("Enter answer: ");
                choice = sc.nextInt();
            }

            
            if (choice == answers[i]) {
                System.out.println(" Correct!");
                
                switch (i) {
                    case 0: amount = 1000; break;
                    case 1: amount = 3000; break;
                    case 2: amount = 8000; break;
                    case 3: amount = 18000; break;
                    case 4: amount = 20000; break; 
                    case 5: amount = 40000; break;
                    case 6: amount = 80000; break; 
                    case 7: amount = 160000; break;
                    case 8: amount = 320000; break;
                    case 9: amount = 700000; break;
                }

                System.out.println("Wallet: ₹" + amount);
            }
            else {
                System.out.println("Wrong answer!");

                if (i < 5) {
                    amount = 0;
                } else if (i < 7) {
                    amount = 20000;
                } else {
                    amount = 80000;
                }

                System.out.println("Final Amount: ₹" + amount);
                return;
            }
        }

        System.out.println(" \n🎉 You won ₹" + amount);
    }
}