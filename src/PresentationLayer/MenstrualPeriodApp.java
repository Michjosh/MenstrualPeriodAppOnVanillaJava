package PresentationLayer;


import DTOs.CreateUserRequest;
import DTOs.FindUserResponse;
import java.util.Scanner;

public class MenstrualPeriodApp {

    private static Scanner scanner = new Scanner(System.in);
    public static UserController userController = new UserController();
    public static MPController mpController = new MPController();


    public static void main(String[] args) {
        startApp();
    }
    private static void startApp() {
        System.out.println( """
        Welcome to the Menstrual Period App!
        1 -> Login
        2 -> Register
        3 -> Exit
        """);
        try {
            int input = scanner.nextInt();
            if (input == 1) {
                loginUser();
            } else if (input == 2) {
                registerUser();
            } else if (input == 3) {
                exitApp();
            } else {
                displayMessage("Invalid input try again");
                startApp();
            }
        } catch (Exception e) {
            displayMessage("An error occurred: " + e.getMessage());
            startApp();
        }
    }


    private static void loginUser() {
        try {
            System.out.println("Enter Your fullName");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            userController.login(input);
            MPApp();
        } catch (Exception e) {
            displayMessage("An error occurred: " + e.getMessage());
            startApp();
        }
    }

    private static void MPApp() {
        System.out.println(  """
                Email Menu
                1 -> See your Next Menstrual Period
                2 -> See the estimated dates of your period for 6 months
                3 -> See your last period date
                4 -> Account Settings
                5 -> Logout
                """);
        try {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 1) {
                nextMP();
            } else if (input == 2) {
                estimatedMP();
            } else if (input == 3) {
                lastMP();
            }
            else if (input == 4) {
                viewProfile();
            }
            else if (input == 5) {
                startApp();
            }else {
                displayMessage("Invalid input try again");
                startApp();
            }
        } catch (Exception e) {
            displayMessage("An error occurred: " + e.getMessage());
            MPApp();
        }
    }


    private static void viewProfile() {
        try {
            System.out.println("Enter Your Username");
            int input = scanner.nextInt();
            userController.findUserById(input);
            MPApp();
        } catch (Exception e) {
            displayMessage("An error occurred while checking the estimated dates of your next menstrual periods: " + e.getMessage());
            MPApp();
        }
    }


    private static void lastMP() {
        try {
            FindUserResponse findUserResponse = new FindUserResponse();
            displayMessage("Your last menstrual period is " + findUserResponse.getDateOfLastPeriod());
            MPApp();
        } catch (Exception e) {
            displayMessage("An error occurred while checking the estimated dates of your next menstrual periods: " + e.getMessage());
            MPApp();
        }
    }

    private static void estimatedMP() {
        try {
            CreateUserRequest findUserResponse = new CreateUserRequest();
            var estimatedMAndP = mpController.getEstimatedPeriodDates(findUserResponse, findUserResponse, findUserResponse);
            displayMessage("Here are your estimated period dates for the 6 months: " + estimatedMAndP);
            MPApp();
        } catch (Exception e) {
            displayMessage("An error occurred while checking the estimated dates of your next menstrual periods: " + e.getMessage());
            MPApp();
        }
    }

    private static void nextMP(){
        try {
            CreateUserRequest findUserResponse = new CreateUserRequest();
            mpController.calculateNextPeriodDate(findUserResponse, findUserResponse, findUserResponse);
            MPApp();
        } catch (Exception e) {
            displayMessage("An error occurred while checking the date of your next menstrual period: " + e.getMessage());
            MPApp();
        }
    }

    private static void registerUser() {
        try {
            CreateUserRequest request = new CreateUserRequest();
            System.out.println("Enter your First name and Lastname with a space in between");
            String name = scanner.next();
            request.setFullName(name);
            System.out.println("Enter your email address");
            String email = scanner.next();
            request.setEmail(email);
            System.out.println("Enter the date of your last period (YYYY-MM-DD)");
            String lastPeriod = scanner.next();
            request.setDateOfLastPeriod(lastPeriod);
            System.out.println("Enter the length of your period in days");
            int period = scanner.nextInt();
            request.setLengthOfPeriod(period);
            System.out.println("Enter the length of your cycle in days");
            int cycle = scanner.nextInt();
            request.setLengthOfCycle(cycle);
            userController.register(request);
            var result = userController.findUserById(request.getId());
            displayMessage("""
                Your Account Details Are:
                """ + result.toString());
            startApp();
        } catch (Exception e) {
            displayMessage("An error occurred: " + e.getMessage());
            startApp();
        }
    }

    private static void displayMessage(String message) {
        System.out.println(message);
    }

    private static void exitApp() {
        System.exit(1);
        displayMessage("Good bye");
    }

}