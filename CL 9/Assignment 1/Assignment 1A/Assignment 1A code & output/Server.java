import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
	private static Socket socket;
	
	public static void main(String args[]) {
		try {
			int port=25000;
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server started and listening to port 25000");
			
			while(true) {
			    //Get message from client
				socket = serverSocket.accept();
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				String filename = br.readLine();
				
				int fileSize = Integer.parseInt(br.readLine());
				
				//br.close();
				
				System.out.println("\nFile information recived from client: ");
				System.out.println("Filename : " +filename + "\nfilsesize : "+fileSize);
				
				
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				
				BufferedReader br2=new BufferedReader(new FileReader(filename));
				
				System.out.println("\nSending file content to client : ");
				
				String str;
				System.out.println("\nFollowing File content sent to client: ");
				while((str=br2.readLine())!=null)
				{
					//pr.println(str);
					bw.write(str + "\n");
					System.out.println(str);	
				}
				
				br2.close();
				bw.flush();
			}

			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
