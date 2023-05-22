package org.manhtb.rmi.server;

import java.rmi.RemoteException;

public class CaculatorImpl implements ICaculator {
    @Override
    public int sum(int a, int b) throws RemoteException {
        return a+b;
    }
}
