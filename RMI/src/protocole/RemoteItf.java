package protocole;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Client;

public interface RemoteItf extends Remote {
    void enregistrement(String Name, String chaine) throws RemoteException;
    void envoyer (String Name, String chaine) throws RemoteException;
    void ajouterUser(Client unClient) throws RemoteException;
}