package protocole;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Mathilde Du Plessix et Yohan Gracia 3IF-1
 *
 */
/**
 * 
 * Interface de l'objet remote
 *
 */
public interface RemoteObjItf extends Remote {
	/**
	 * 
	 * @param Name
	 * @param chaine
	 * @throws RemoteException
	 */
    void enregistrement(String Name, String chaine) throws RemoteException;
    /**
     * 
     * @param num
     * @return la chaine qui doit être affichée pour le client
     * @throws RemoteException
     */
    String ecriture (int num) throws RemoteException;
    /**
     * 
     * @param num
     * @return un Bool disant si le client doit écrire ou non
     * @throws RemoteException
     * @throws InterruptedException
     */
    boolean getPassage (int num)throws RemoteException, InterruptedException;
    /**
     * 
     * @return l'indice du Client (unique)
     * @throws RemoteException
     */
    int indiceClient() throws RemoteException;
}