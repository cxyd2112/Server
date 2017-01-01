package dataserviceimpl;

import datahelper.datahelperimpl.userimpl;
import datahelper.user;
import dataservice.userdataservice;
import po.OrderPo;
import po.UserPo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

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
    private String birthday;
    private String company;

    public userserviceimpl(){
        user=new userimpl();
    }

    @Override
    public UserPo userfind(int id) throws RemoteException {

        values=user.find(id);
      
        if (values.equals("") )
            return null;

        String[] users=values.split("!");
        String[] s=users[0].split(",");
        System.out.print(s.length);

        //set UserPo
        name=s[1];
        credit=Integer.parseInt(s[2]);
        number= s[3];
        birthday=s[4].equals("null") ?null: s[4];
        company=s[5].equals("null") ?null: s[5];
        return new UserPo(id,name,birthday,number,credit,company);
    }

    @Override
    public boolean hotelreserved(int userid, int hotelid) throws RemoteException {
        List<OrderPo> s=new orderserviceimpl().findorderbyuserid(hotelid);
        for (OrderPo x:s){
            if (x.getHotelid()==userid) return true;
        }

        return false;
    }

    @Override
    public int userinsert(UserPo upo, char[] password) throws RemoteException{
        name=upo.getUserName();
        credit=upo.getCredit();
        number=upo.getPhone();
        birthday=upo.getBirthday();
        company=upo.getCompany();

        id=(int)(1000+Math.random()*(1000));
        values="'"+id+"','"+name+"','"+credit+"','"+number+"','"+birthday+"','"+company+"'";
        for(int i=0;i<password.length;i++)
            password[i]=(char)(password[i]-2);
        String log="'"+id+"','"+String.valueOf(password)+"','0'";
        while(!user.insert(values,log)){
            id=(int)(1000+Math.random()*(1000));
            values="'"+id+"','"+name+"','"+credit+"','"+number+"','"+birthday+"','"+company+"'";
            log="'"+id+"','"+String.valueOf(password)+"','0'";
        }
        return id;
    }

    @Override
    public boolean userupdate(UserPo upo) throws RemoteException{
        id=upo.getId();
        name=upo.getUserName();
        credit=upo.getCredit();
        number=upo.getPhone();
        values="'"+id+"','"+name+"','"+credit+"','"+number+"','"+birthday+"','"+company+"'";

        return user.update(values);


    }
    

}
