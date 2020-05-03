package user;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Login {
    private static Scanner console;
    private static boolean loggedIn;
    private static User authUser;

    public static void main(String[] args) 
    {
        console = new Scanner(System.in);
	    loggedIn = false;
        while (true) 
        {
            if (loggedIn) 
            {
                serveAuth();
            }
            	else 
            	{
            		serveGuest();
            	}
        }

    }


    public static void serveGuest () 
    {
        System.out.println("*****************************************");
        System.out.println("*****************Guest********************");
        System.out.println("*****************************************");
        int choice = showGuestMenu();
        if(choice == 1) 
        {
            login();
        }	
        
        	else if (choice == 2) 
        	{
        		register();
        	}
        	
        		else if (choice == 3) 
        		{
        			System.out.println("Bye.");
        			System.exit(0);
        		}
    }

    public static void serveAuth() 
    {
        System.out.println("*****************************************");
        System.out.println("*****************Auth********************");
        System.out.println("*****************************************");
        System.out.println("\nYou are logged as : " +authUser.getFirstName()+"  "+authUser.getLastName()+
                "\nUsername :" +authUser.getUsername()+
                "\nRole :"+authUser.getRole());
        System.out.println("*****************************************");
        int choice = showAuthMenu();
        if (choice == 1) 
        {
        	loggedIn = false;
            authUser  = null;
        }
        	else 
        	{
        		System.out.println("Bye");
        		System.exit(0);
        	}
    }

    public static int showAuthMenu() {
        int choice = 0;
        while (true) {
            System.out.print("1. Logout" +
                    "\n2. Exit" +
                    "\nEnter choice");
            try {
                choice = Integer.parseInt(console.nextLine());
                if(choice < 1 || choice > 2) {
                    System.out.println("Invalid choice. Please try again.");
                }else {
                    return choice;
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static int showGuestMenu() {
        int choice = 0;
        while (true) {
            System.out.print("1. Login\n" +
                    "2. Register\n" +
                    "3. Quit\n" +
                    "Enter choice :");

            try {
                choice = Integer.parseInt(console.nextLine());
                if(choice <1 || choice > 3) {
                    System.out.println("Invalid choice. Please try again.");
                }else {
                    return choice;
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void login() {
        System.out.print("Enter username :");
        String username = console.nextLine().trim();
        if(!UserDAO.userExists(username)){
            System.out.println("Unregistered username. Please register first");
            return;
        }
        System.out.print("Enter password :");
        String password = console.nextLine().trim();
        User u = UserDAO.login(username, password);
        if(u == null) {
            System.out.println("Login failed");
        }else {
            System.out.println("Login success");
            loggedIn = true;
        }
        authUser = u;
    }

    private static void register() {
        System.out.print("Enter first name :");
        String firstName = console.nextLine().trim();

        System.out.print("Enter last name :");
        String lastName = console.nextLine().trim();
        System.out.print("Enter username :");

        String username = console.nextLine().trim();
        if(UserDAO.userExists(username) ){
            System.out.println("The username is already taken");
            return;
        }
        String role = chooseRole() == 1 ? "Administrator": "Assistant";
        System.out.print("Enter password :");
        String password = console.nextLine();

        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setUsername(username);
        u.setRole(role);
        u.setPassword(password);
        UserDAO.register(u);
        System.out.println("Registration success");
    }

    private static int chooseRole() {
        int role = 0;
        while (true) {
            System.out.print("Choose role:\n" +
                    "1. Administrator\n" +
                    "2. Assistant\n" +
                    "Enter choice :");
            try {
                role = Integer.parseInt(console.nextLine());
                if (role < 1 || role > 2) {
                    System.out.println("Invalid choice. Please try again.");
                }else {
                    return role;
                }

            }catch (NumberFormatException e){
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
