package dataserviceimpl;

import datahelper.datahelperimpl.loginimpl;
import datahelper.login;
import dataservice.logindataservice;

import java.rmi.RemoteException;

/**
 * Created by huihantao on 2016/12/21.
 */
public class loginserviceimpl implements logindataservice {
    private login lg;

    public loginserviceimpl(){
        lg=new loginimpl();
    }

    @Override
    public boolean login(String id,char[] password) throws RemoteException{
        char[] pass=(lg.login(id)).toCharArray();
        if (pass.length!=password.length+2) return false;
        for (int i=0;i<password.length;i++){
            if (pass[i]!=password[i]-2) return false;
        }

        return true;
    }
}
