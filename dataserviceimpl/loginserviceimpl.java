package dataserviceimpl;

import datahelper.datahelperimpl.loginimpl;
import datahelper.login;
import dataservice.logindataservice;
import po.HotelPo;
import po.OrderPo;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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




        {
            List<OrderPo> x =new orderserviceimpl().findorderbyhotelid(0);
            if (x==null) return true;
            for (OrderPo y:x){
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
                String nowtime = df.format(new Date());
                long now=Long.parseLong(nowtime);
                if (y.getDelaytime()<now&&y.getStatus()==0) y.setStatus(2);

            }

        }





        return true;
    }

    @Override
    public void logout(int id) throws RemoteException {
        values="0";
        lg.logout(values,id+"");
    }
}
