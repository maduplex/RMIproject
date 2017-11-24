package protocole;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloItf extends Remote {
    void enregistrement(String Name, String chaine) throws RemoteException;
    String ecriture (int num) throws RemoteException;
    boolean getPassage (int num)throws RemoteException, InterruptedException;
    int indiceClient() throws RemoteException;
}