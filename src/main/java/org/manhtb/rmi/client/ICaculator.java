package org.manhtb.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICaculator extends Remote {
    public int sum(int a, int b) throws RemoteException;
}
