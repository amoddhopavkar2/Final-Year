import java.rmi.*;																	//importing package for rmiregistry

public class Server {
	public static void main(String args[]) {
		try {
			ConcatServerInterface concatService=new Concat();			//creating object of Concat class
			Naming.rebind("ConcatService",concatService);					//concatService object is rebind with name ConcatService

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
