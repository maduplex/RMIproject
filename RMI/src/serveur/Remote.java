package serveur;

import java.rmi.RemoteException;
import java.util.Scanner;

import protocole.RemoteItf;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import client.Client;

public class Remote implements RemoteItf {
	public List<Client> mesClients;
    
	public Remote() {
    	mesClients = new ArrayList<Client>();
    }

    public void enregistrement(String Name, String chaine) throws RemoteException 
    {
    	try{
            // Creation d'un FileWriter: flux de sortant vers un fichier
			String fileName = "Historique.txt"; // Nom du fichier
            File file = new File(fileName);  // Pointeur vers ce fichier
            FileWriter fw = new FileWriter(file,true);
    		fw.write(Name+": "+chaine +"\r\n"); 
    		fw.close();
		}catch (IOException x) {
            System.err.println("Exception caught !");
            x.printStackTrace();
		}
    }
    
    public void ajouterUser(Client unClient) throws RemoteException{
    	mesClients.add(unClient);
    }
    
    public void envoyer (String Name, String chaine) throws RemoteException
    {
    	for(int i = 0; i< mesClients.size();i++){
    		mesClients.get(i).afficher(Name,chaine);
    	}
    }
    
}