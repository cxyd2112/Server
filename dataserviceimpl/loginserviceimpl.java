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
    String values;

    public loginserviceimpl(){
        lg=new loginimpl();
    }

    @Override
    public boolean login(String id,char[] password) throws RemoteException{
        char[] pass=(lg.login(id)).toCharArray();

        if (pass.length!=password.length+4) return false;

        for (int i=0;i<password.length;i++){
            if (pass[i]!=password[i]-2) return false;
        }

        if (pass[password.length+1]=='1') return false;
        values="1";
        lg.logout(values,id);



        return true;
    }

    @Override
    public void logout(int id) throws RemoteException {
        values="0";
        lg.logout(values,id+"");
    }
}
