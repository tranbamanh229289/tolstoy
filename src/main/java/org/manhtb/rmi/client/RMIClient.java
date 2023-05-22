package org.manhtb.rmi.client;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args) {
        try {
            ICaculator caculator = (ICaculator) Naming.lookup("rmi://localhost:5000/caculator");
            System.out.println("1+2 = " + caculator.sum(1, 2));
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
