import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String reply="";
		StudentLogic obj = new StudentLogic(); 

		do {
		    System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM");
		    System.out.println("1. REGISTER");
		    System.out.println("2. LOGIN");
		    System.out.println("3. EXIT");
		
		    System.out.println("ENTER YOUR CHOICE ");
		    int option = sc.nextInt();
		
		    switch (option) {
		        case 1:
		            obj.register();
		            break;
		
		        case 2:
		            obj.login();   
		
		            break;
		
		        case 3:
		            System.out.println("Exiting Inventory Management System.");
		            return;
		
		
		
		    default:
		        System.out.println("PLEASE ENTER VALID INPUT ");
		}
		
		System.out.println("DO YOU WANT TO CONTINUE Y/N ");
		reply = sc.next();
		} while (reply.equalsIgnoreCase("y"));
		}
		do
		{
			System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM");
			System.out.println("1. ADD STUDENT ");
			System.out.println("2. DELETE STUDENT ");
			System.out.println("3. SERACH STUDENT ");
			System.out.println("4. UPDATE STUDENT DETAILS ");
			System.out.println("5. DISPLAY ALL STUDENT ");
			
			System.out.println("ENTER YOUR CHOICE ");
			int option = sc.nextInt();
			
			switch(option)
			{
			   case 1: obj.readArrayListFromFile();
				       obj.addStudent();
			           obj.writeArrayListToFile();
				       break;
			 
			   case 2: obj.readArrayListFromFile();
		               obj.deleteStudent(); 
		               obj.writeArrayListToFile();
	                   break;
	            
			   case 3: obj.readArrayListFromFile();
                       obj.searchStudentById(); 
                       break;
			   
			   case 4: obj.readArrayListFromFile();
		               obj.updateStudentDetailsByID();
		               obj.writeArrayListToFile();
	                   break;
			   
			   case 5: obj.readArrayListFromFile();
				       obj.displayAllStudent(); 
			           break;
			   
			   default:
				   System.out.println("PLEASE ENTER VALID INPUT ");
			}
			
			
			System.out.println("DO YOU WANT TO CONTINUE Y/N ");
			reply = sc.next();
		}while(reply.equalsIgnoreCase("y"));
	}
}
