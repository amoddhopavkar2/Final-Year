import java.rmi.*;															//importing package for rmiregistry
public interface ConcatServerInterface extends Remote
{
	public String concat(String S1,String S2) throws RemoteException;				//declaring function in the interface
}
