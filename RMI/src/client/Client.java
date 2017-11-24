package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import protocole.RemoteItf;
import serveur.Remote;

public class Client {
	
	public void afficher(String unNom, String uneEcriture){
		System.out.println(unNom+ ": "+ uneEcriture);
	}

    public void main(String[] args) {

        String host = (args.length < 2) ? null : args[0];
        int port = Integer.parseInt(args[1]) ;
        BufferedReader stdIn = null;
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        try {
            Registry registry = LocateRegistry.getRegistry(host,port);
            RemoteItf stub =(RemoteItf) registry.lookup("Hello1");
            Scanner sc = new Scanner(System.in);
            stub.ajouterUser(this);
            System.out.println("Donnez votre pseudo: ");
            String Name = sc.nextLine();
            
   //       ThreadClient ct = new ThreadClient(Name, stub);
   //       ct.start();
           String ecriture="ff";
           
            while(!ecriture.equals("."))
            {
            	ecriture = stdIn.readLine();
            	stub.enregistrement(Name, ecriture);
            	stub.envoyer(Name,ecriture);
            }
            sc.close();
            stdIn.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}