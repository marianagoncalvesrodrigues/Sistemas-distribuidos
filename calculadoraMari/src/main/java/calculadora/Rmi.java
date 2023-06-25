package calculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.jws.WebService;
import java.util.concurrent.locks.ReentrantLock;

@WebService
public class Rmi extends UnicastRemoteObject implements Calculadora {
    private ReentrantLock lock;

    public Rmi() throws RemoteException {
        super();
        lock = new ReentrantLock();
    }

    public int add(int a, int b) throws RemoteException {
        lock.lock();
        try {
            System.out.println(a + b);
            return a + b;
        } finally {
            lock.unlock();
        }
    }

    public int sub(int a, int b) throws RemoteException {
        lock.lock();
        try {
            return a - b;
        } finally {
            lock.unlock();
        }
    }

    public int mul(int a, int b) throws RemoteException {
        lock.lock();
        try {
            return a * b;
        } finally {
            lock.unlock();
        }
    }

    public double div(int a, int b) throws RemoteException {
        lock.lock();
        try {
            return (double) a / b;
        } finally {
            lock.unlock();
        }
    }
}
