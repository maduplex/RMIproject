package serveur;

import java.rmi.RemoteException;
import java.util.Scanner;

import protocole.RemoteObjItf;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
/**
 * 
 * @author Mathilde Du Plessix et Yohan Gracia 3IF-1
 *	
 */

public class RemoteObj implements RemoteObjItf {
	/**
	 * attributs de l'objet
	 * derniereLigne est la dernière ligne rentrée
	 * passage est un tableau de bool qui dit si le client correspondant doit afficher quelque chose
	 * indice est le nombre de client
	 */
	String derniereLigne;
	boolean  []passage = new boolean[100] ;
	int indice;
	
	/**
	 * Constructeur de l'objet
	 * Création du tableau
	 * initialisation de l'indice à 0
	 */
    public RemoteObj() {
    	for(int i=0;i<100;i++)
		{
			passage[i] = true;
		}
    	indice =0;
    }

    /**
	 * 
	 * @param Name
	 * @param chaine
	 * @throws RemoteException
	 * Cette méthode écrit dans le fichier
	 * Historique.txt chaque message qui transite
	 */
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
    
    /**
     * 
     * @param num
     * @return la chaine qui doit être affichée pour le client
     * @throws RemoteException
     */
    public String ecriture (int num) throws RemoteException
    {
        passage[num]=true;
    	return derniereLigne;
    }
    
    /**
     * 
     * @param num
     * @return un Bool disant si le client doit écrire ou non
     * @throws RemoteException
     * @throws InterruptedException
     */
    public boolean getPassage (int num) throws RemoteException, InterruptedException
    {
    	Thread.sleep(1000);
    	return passage[num];
    }
    
    /**
     * 
     * @return l'indice du Client (unique)
     * @throws RemoteException
     */
    public int indiceClient() throws RemoteException
    {
    	indice++;
    	return indice-1;
    }
    
}