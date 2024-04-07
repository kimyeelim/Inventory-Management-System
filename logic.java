import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentLogic {
	
	private ArrayList<StudentModel> stlist = new ArrayList<StudentModel>();
 	private Scanner sc = new Scanner(System.in);

	public void register()
	{
		System.out.println("Enter username: ");
		String username = sc.next();

		System.out.println("Enter password: ");
		String password = sc.next();

        try (PrintWriter writer = new PrintWriter(new FileWriter("D:\\user_data.txt", true))) {
            
            writer.println(username + "," + password);
            System.out.println("Registration successful");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
		
	}
	public void login() {
	    System.out.println("Enter username: ");
	    String username = sc.next();

	    System.out.println("Enter password: ");
	    String password = sc.next();

	    try (Scanner fileScanner = new Scanner(new FileInputStream("D:\\user_data.txt"))) {
	        boolean found = false;
	        while (fileScanner.hasNextLine()) {
	            String line = fileScanner.nextLine();
	            String[] data = line.split(",");
	            if (data[0].equals(username) && data[1].equals(password)) {
	                found = true;
	                break;
	            }
	        }
	        if (found) {
	            System.out.println("Login successful");
	        } else {
	            System.out.println("Invalid username or password");
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	  
	}

 	
	public void addStudent()
	{
		String reply="";
		do
		{
			//TAKE INPUT FROM USER AND STORE IT IN THE OBJECT
			StudentModel obj = new StudentModel();
			System.out.println("Enter Student id ");
			int id = sc.nextInt();
			obj.setStid(id);
			
			//TAKE INPUT FROM USER AND STORE IT IN THE OBJECT
			System.out.println("Enter Student Name ");
			obj.setStname(sc.next());
			
			//TAKE INPUT FROM USER AND STORE IT IN THE OBJECT
			System.out.println("Enter Student Points ");
			obj.setStpoints(sc.nextDouble());
			
			//ADD OBJECT TO THE ARRAY LIST
			stlist.add(obj);
						
			System.out.println("Want to add more students Y/N ");
			reply = sc.next();
		}while(reply.equalsIgnoreCase("y"));
	}

	public void displayAllStudent()
	{
		for(StudentModel obj: stlist)
		{
			System.out.println("Student id " + obj.getStid());
			System.out.println("Student Name " + obj.getStname());
			System.out.println("Student Points " + obj.getStpoints());
			System.out.println();
		}
	}
	
	public void deleteStudent()
   	{
    	System.out.println("Enter ID ");
    	int id = sc.nextInt();
    	StudentModel tempstobj = null;
    	
    	//SEARCH OBJECT BY ROLL NO IN THE ARRAY LIST
    	//IF FOUND STORE IT IN TEMP OBJ
    	for(StudentModel stobj: stlist)
		{
    		if (stobj.getStid() == id)
    		{
    			tempstobj = stobj;
    			break;
    		}
		}
    	//CHECK OBJECT IS FUND OR NOT
        if(tempstobj != null)
        {
        	//IF OBJECT IS FOUND
        	// REMOVE OBJECT FROM ARRAYLIST
        	stlist.remove(tempstobj);
			System.out.println("Student Information Deeted ");
        }
        else
        	System.out.println("INVALID ROLL NO ");
   	}
	
	public void searchStudentById()
   	{
    	System.out.println("Enter ID ");
    	int id = sc.nextInt();
    	StudentModel tempstobj = null;
    	
    	//SEARCH OBJECT BY ROLL NO IN THE ARRAY LIST
    	for(StudentModel stobj:stlist)
		{
    		if (stobj.getStid() == id)
    		{
    			tempstobj = stobj;
    			break;
    		}
		}
    	
    	if(tempstobj != null)
    	{
    	   	System.out.println("ID is "+ tempstobj.getStid());
    	   	System.out.println("Name is "+ tempstobj.getStname());
    	   	System.out.println("Grade Point is "+ tempstobj.getStpoints());  	
    	}
    	else
    		System.out.println("INVALID ID ");
   	}
	
	
	public void updateStudentDetailsByID()
   	{
    	System.out.println("Enter Student ID ");
    	int id = sc.nextInt();
    	StudentModel tempstobj = null;
    	int loc = -1;
    	//SEARCH OBJECT BY ROLL NO IN THE ARRAY LIST
    	for(int index =0; index < stlist.size();index++)
		{
    		tempstobj = stlist.get(index);
    		if (tempstobj.getStid() == id)
    		{
    			loc = index;
    			break;
    		}
		}
    	//CHECK OBJECT IS FOUND OR NOT
        if(loc != -1)
        {
        	//IF OBJECT IS FOUND
           //TAKE UPDATED VALUE
           System.out.println("Enter Correct Name ");
           tempstobj.setStname(sc.next());
   	    
   	       System.out.println("Enter Updated Grade Points  ");
   	       tempstobj.setStpoints(sc.nextInt());
   	       	       
   	       //UPDATE ARRAY LIST
   	       stlist.set(loc, tempstobj);
   	       
   	       System.out.println("Student Information Updated ");
        }
        else
        	System.out.println("INVALID STUDENT ID  ");
   	}
	
	
	public void writeArrayListToFile()
	{
	  try	
	  {
		FileOutputStream fout = new FileOutputStream("D:\\Student.txt");
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		//WRITE ARRAYLIST OBJECT INTO FILE 
		oout.writeObject(stlist);
		
		System.out.println("FILE WRITING DONE....");
	  
	  }catch(FileNotFoundException e){System.out.println(e.toString());}
	   catch(IOException e) {System.out.print(e.toString());}
	   catch(Exception e) {System.out.print(e.toString());}
	}
	
	public void readArrayListFromFile()
	{
	  try
	  {
		FileInputStream fin=new FileInputStream("D:\\Student.txt");
		ObjectInputStream oin=new ObjectInputStream(fin);
		//READ DATA FROM FILE AND STORE IT IN ARRAYLIST 
		stlist = (ArrayList<StudentModel>)oin.readObject();
	  
		System.out.println("READING FROM FILE COMPLETED.....");
	  }catch(FileNotFoundException e){
		  stlist = new ArrayList<StudentModel>();
		  //System.out.println(e.toString());
		  }
	   catch(IOException e) {System.out.print(e.toString());}
	   catch(Exception e) {System.out.print(e.toString());}
	}
	
}
