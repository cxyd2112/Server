package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by huihantao on 2016/12/21.
 */
public interface logindataservice extends Remote{
    boolean login(String id,char[] password) throws RemoteException;
}
