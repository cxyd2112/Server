package dataserviceimpl;

import datahelper.datahelperimpl.userimpl;
import datahelper.user;
import dataservice.userdataservice;
import po.UserPo;

import java.rmi.RemoteException;

/**
 * Created by huihantao on 2016/11/27.
 */
public class userserviceimpl implements userdataservice {
    //数据库访问对象
    private user user;
    //
    private String name;
    private String number;
    private int credit;
    private String values;
    private int id;
    private char[] pass;

    public userserviceimpl(){
        user=new userimpl();
    }

    @Override
    public UserPo userfind(int id) throws RemoteException {

        values=user.find(id);
        if (values.equals("") )
            return null;

        String[] users=values.split("\\.");
        String[] s=users[0].split(",");

        //set UserPo
        name=s[1];
        credit=Integer.parseInt(s[2]);
        number= s[3];
        return new UserPo();
    }

    @Override
    public int userinsert(UserPo upo, char[] password) throws RemoteException{
        name=upo.getUserName();
        credit=upo.getCredit();
        number=upo.getPhone();
        id=(int)(1000+Math.random()*(1000));
        values="'"+id+"','"+name+"','"+credit+"','"+number+"'";
        for(int i=0;i<password.length;i++)
            password[i]=(char)(password[i]-2);
        String log="'"+id+"','"+String.valueOf(password)+"'";
        while(!user.insert(values,log)){
            id=(int)(1000+Math.random()*(1000));
            values="'"+id+"','"+name+"','"+credit+"','"+number+"'";
            log="'"+id+"','"+String.valueOf(password)+"'";
        }
        return id;
    }

    @Override
    public boolean userupdate(UserPo upo) throws RemoteException{
        id=upo.getId();
        name=upo.getUserName();
        credit=upo.getCredit();
        number=upo.getPhone();
        values="'"+id+"','"+name+"','"+credit+"','"+number+"'";

        return user.update(values);


    }



}
