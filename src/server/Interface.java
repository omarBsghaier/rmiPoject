package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Interface  extends Remote {

        void createEmploye(Employe emp) throws RemoteException;
        public ArrayList<Employe> readEmploye() throws RemoteException;
        public ArrayList<Employe> readOneEmploye(int id) throws RemoteException;
        void updateEmploye(int id, String grade) throws RemoteException;
        void deleteEmploye(int id) throws RemoteException;
        void createTache(Tache t) throws RemoteException;
        public ArrayList<Tache> readTache() throws RemoteException;
        public ArrayList<Tache> readOneTache(int id) throws RemoteException;
        void updateTache(int id, String desc) throws RemoteException;
        void deleteTache(int id) throws RemoteException;
        void hello(String h) throws RemoteException;
    }

