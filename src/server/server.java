package server;

import java.rmi.Naming;

import java.rmi.registry.LocateRegistry;


public class server {

    public static void main(String[] args) {

        try {

            LocateRegistry.createRegistry(1099);
             InterfaceImp stub = new InterfaceImp();
            Naming.rebind("rmi://localhost:1099/InterfaceImp",stub);
            System.out.println("helloo " +stub.toString());


        } catch (Exception stub) {
            System.out.println(stub.toString());

        }

    }

}