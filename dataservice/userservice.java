package dataservice;


import po.userpo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface userservice extends Remote{

    userpo userfind(int id) throws RemoteException;

    int userinsert(userpo upo,char[] password) throws RemoteException;

    boolean userupdate(userpo upo) throws RemoteException;

    boolean userlogin(int id,char[] password) throws RemoteException ;


}


