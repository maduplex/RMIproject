package serveur;

import java.rmi.RemoteException;
import java.util.Scanner;

import protocole.HelloItf;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Hello implements HelloItf {
	String derniereLigne;
	boolean  []passage = new boolean[100] ;
	int indice;
	
    public Hello() {
    	for(int i=0;i<100;i++)
		{
			passage[i] = true;
		}
    	indice =0;
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
    		derniereLigne = Name + ": " +chaine;
    		for(int i=0;i<indice;i++)
    		{
    			passage[i] = false;
    		}

		}catch (IOException x) {
            System.err.println("Exception caught !");
            x.printStackTrace();
			}

    	
    }
    
    public String ecriture (int num) throws RemoteException
    {
        passage[num]=true;
    	return derniereLigne;
    }
    
    public boolean getPassage (int num) throws RemoteException, InterruptedException
    {
    	Thread.sleep(1000);
    	return passage[num];
    }
    
    public int indiceClient() throws RemoteException
    {
    	indice++;
    	return indice-1;
    }
    
}