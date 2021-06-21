import java.rmi.*;															//importing package for rmiregistry

public class Concat extends UnicastRemoteObject implements ConcatServerInterface
{
	Concat()throws RemoteException{
		super();
	}
	public String concat(String a,String b)				//Concat Function definition
	{
		return a+b;																	//Return concatenated string
	}
}
