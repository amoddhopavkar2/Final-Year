import java.rmi.*;																			//importing package for rmiregistry
import java.util.Scanner;																//importing package for scanning input
public class Client {
	@SuppressWarnings("resource")
	public static void main(String args[]) {							//main function
		Scanner sc= new Scanner(System.in);    							//System.in is a standard input stream
		System.out.print("Enter first String: ");
		String S1= sc.nextLine();														//taking input from user
		System.out.print("Enter second String: ");
		String S2= sc.nextLine();
		try{
			ConcatServerInterface st = (ConcatServerInterface)Naming.lookup("rmi://localhost/ConcatService");											//lloking up for ConcatService through RMIRegistry
			System.out.println("Concatenated String is : "+st.concat(S1,S2));																											//Printing the output after calling the function concat remotely
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
