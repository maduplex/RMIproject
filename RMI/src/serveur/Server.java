package serveur;


import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import protocole.RemoteItf;

public class Server {

	   public static void main(String args[]) {
		   int port = Integer.parseInt(args[0]);
	       try {
	           Remote obj = new Remote();
	           RemoteItf stub = (RemoteItf) UnicastRemoteObject.exportObject(obj, 0);

	            // Bind the remote object's stub in the registry
	            Registry registry = LocateRegistry.getRegistry(port);
	            registry.bind("Hello1", stub);

	            System.err.println("Server ready");
				
	       } catch (Exception e) {
	           System.err.println("Server exception: " + e.toString());
	           e.printStackTrace();
	      }
	 }
}
