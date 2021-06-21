import java.io.*;
import java.net.*;
import java.nio.file.Paths;
public class Client {
private static Socket socket;
	
	public static void main(String args[]) {
		try {
			String host="localhost";
			int port=25000;
			
			InetAddress address = InetAddress.getByName(host);
			socket=new Socket(address,port);
			
			String Filename =("myFile.txt");
			File myFile = new File(Filename);
			int FileSize = (int) myFile.length();
			
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			
			bw.write(Filename+"\n");
			bw.write(FileSize +"\n");
			bw.flush();
			System.out.println("Following File information sent to server: ");
			System.out.println("File name : "+ Filename + "\nFile Size : "+ FileSize);

			
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			System.out.println("\nFile content recived from server: ");
			String str;
			while((str=br.readLine())!=null)
			{
				System.out.println(str);
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
