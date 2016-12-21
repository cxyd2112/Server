package rmi;

/**
 * Created by huihantao on 2016/11/28.
 */
import dataservice.logindataservice;
import dataservice.userdataservice;
import dataserviceimpl.loginserviceimpl;
import dataserviceimpl.userserviceimpl;
import po.UserPo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class dataremoteobject extends UnicastRemoteObject implements userdataservice , logindataservice {

    private static final long serialVersionUID = 10L;

    private userdataservice userserve;
    private logindataservice loginserve;
    public dataremoteobject() throws RemoteException{
        userserve=new userserviceimpl();
        loginserve=new loginserviceimpl();
    }


    @Override
    public UserPo userfind(int id) throws RemoteException {
        return userserve.userfind(id);
    }

    @Override
    public int userinsert(UserPo upo, char[] password) throws RemoteException {
        return userserve.userinsert(upo,password);
    }

    @Override
    public boolean userupdate(UserPo upo) throws RemoteException {
        return userserve.userupdate(upo);
    }


    @Override
    public boolean login(String id, char[] password) throws RemoteException {
        return loginserve.login(id,password);
    }
}
