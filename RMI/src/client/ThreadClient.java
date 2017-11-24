package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import protocole.RemoteObjItf;
/**
 * 
 * @author Mathilde Du Plessix et Yohan Gracia 3IF-1
 *
 */

public class ThreadClient extends Thread{
	/**
	 * Le ThreadClient a 3 attributs, le nom du client
	 * l'objet remote et un indice
	 */
	String Name;
	RemoteObjItf stub;
	int num;
	/**
	 * 
	 * @param unName le nom du client
	 * @param unStub l'objet remote
	 */
	ThreadClient (String unName, RemoteObjItf unStub)
	{
		Name = unName;
		stub=unStub;
	}
	
	
	public void run() {
		/**
		 * Lit l'historique
		 */
    		//lecture de l'historique
  		  String fileName = "Historique.txt"; // Nom du fichier
          File file = new File(fileName);  // Pointeur vers ce fichier
          try  {
              // Creation d'un flux de lecture pour ce fichier
              FileReader in = new FileReader(file);

              // Creation d'un buffer de lecture pour ce flux
              BufferedReader reader = new BufferedReader(in); 

              String line = null;
              // Lecture du fichier ligne par ligne  tant que l'on est pas a la fin (null)
              while ((line = reader.readLine()) != null) { 
                  // Affichage de la ligne courante
                  System.out.println(line); 
              }
              reader.close();
          } catch (IOException x) {
              System.err.println("Exception caught !");
              x.printStackTrace();
          }
  	  try {
  		  /**
  		   * Ecrit dans l'historique
  		   */
  		String ecriture ="";
  		Scanner sc = new Scanner(System.in);
  			while (true)
  			{
  				ecriture = sc.nextLine();
  				stub.enregistrement(Name,ecriture);
  				if(ecriture.equals("."))
  				{
  					break;
  				}
  			}
  		sc.close();
  	  } catch (Exception e) {
    	System.err.println("Error in ClientChatThread:" + e); 
    }
   }
}
