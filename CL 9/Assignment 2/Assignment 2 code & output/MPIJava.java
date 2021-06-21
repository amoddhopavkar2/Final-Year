import mpi.*;
public class MPIJava {

	public static void main(String[] args) {
		
		/*Scanner scan = new Scanner(System.in);
		System.out.print("Enter two strings to perform concatenation: ");
		String S1 = scan.nextLine();
		String S2 = scan.nextLine();
		scan.close();*/
		
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int tag = 100;
		int dest;
		
		//sending data
		if(rank==1)
		{
			String stringToConcat[] = new String[2];
			dest = 0;
			stringToConcat[0] = "Hello";
			stringToConcat[1] = "World";
			
			System.out.println("This is process "+rank+"");
			System.out.println("Sending the strings "+ stringToConcat[0]+" and "+ stringToConcat[1]+ " to concatenate.");
			MPI.COMM_WORLD.Send(stringToConcat, 0, 2, MPI.OBJECT, dest, tag);
		}
		
		//receiving data
		else
		{
			dest = 1;
			String stringToConcat[] = new String[2];
			MPI.COMM_WORLD.Recv(stringToConcat, 0, 2, MPI.OBJECT, dest, tag);
			System.out.println("This is process "+rank+"");
			System.out.println("Strings received from process "+dest+ " are " + stringToConcat[0]+ " and "+ stringToConcat[1]);
			System.out.println("The concatenation is "+stringToConcat[0]+stringToConcat[1]);
			
		}
		
		MPI.Finalize();
	}

}

