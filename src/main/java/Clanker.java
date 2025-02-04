import java.util.Scanner;

public class Clanker {

        private static final String LINE = "____________________________________________________________";
        private static final String LOGO = " _____ _             _\n"
                + "/  __ \\ |           | |\n"
                + "| /  \\/ | __ _ _ __ | | _____ _ __ \n"
                + "| |   | |/ _` | '_ \\| |/ / _ \\ '__| \n"
                + "| \\__/\\ | (_| | | | |   <  __/ | \n"
                + " \\____/_|\\__,_|_| |_|_|\\_\\___|_| \n";


        private void greet() {
            System.out.println(LINE);
            System.out.println("Hello I'm\n" + LOGO + "\n"+ "What Can I do for you?");
            System.out.println(LINE);
        }

        private void goodbye() {
            System.out.println("Bye! Hope to see you again soon!");
            System.out.println(LINE);
        }

        private String getUserInput() {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        private void echoUserCommand(String command) {
            System.out.println(LINE);
            System.out.println(command);
            System.out.println(LINE);
        }

        private void chatLoop() {
            boolean isRunning= true;
            while (isRunning) {
                String userCommand = getUserInput();
                if (userCommand.equals("bye")) {
                    isRunning = false;
                }
                echoUserCommand(userCommand);
            }
        }

        public void chatBotProgram() {
            greet();
            chatLoop();
            goodbye();
        }

        public static void main(String[] args) {
            Clanker chatbot = new Clanker();
            chatbot.chatBotProgram();
        }
    }
