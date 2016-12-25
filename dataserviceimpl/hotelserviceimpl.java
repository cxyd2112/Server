package dataserviceimpl;

import datahelper.datahelperimpl.hotelimpl;
import datahelper.datahelperimpl.orderimpl;
import datahelper.hotel;
import datahelper.order;
import dataservice.hoteldataservice;
import po.HotelPo;

import java.rmi.RemoteException;
import java.util.*;

/**
 * Created by huihantao on 2016/12/24.
 */
public class hotelserviceimpl implements hoteldataservice {

    private hotel ht;
    private order or;

    public hotelserviceimpl(){
        ht=new hotelimpl();
        or=new orderimpl();
    }

    @Override
    public List<HotelPo> usergethotellist(int userid) throws RemoteException {
        String values=or.find("userid",userid);
        if (values.equals("")) return null;
        String[] orders=values.split("!");
        HashSet<Integer> x=new HashSet<>();
        for (int i=0;i<orders.length;i++){
            String[] log=orders[i].split(",");
            x.add(Integer.parseInt(log[2]));
        }
        ArrayList<HotelPo> hpolist=new ArrayList<>();


        for (Integer j:x){
            hpolist.add(findhotelbyid(j.intValue()));
        }

        return hpolist;
    }

    @Override
    public List<HotelPo> getallhotellist() throws RemoteException {
        String values=ht.find(0);
        String[] hotels=values.split("!");
        ArrayList<HotelPo> hotlist=new ArrayList<>();

        for (String x:hotels){
            hotlist.add(new HotelPo(x));
        }


        return hotlist;
    }

    @Override
    public int hotelinsert(HotelPo hpo,char[] password) throws RemoteException {

        int id=(int)(2000+Math.random()*(2000));
        for(int i=0;i<password.length;i++)
            password[i]=(char)(password[i]-2);
        String log="'"+id+"','"+String.valueOf(password)+"','0'";
        while(!ht.insert("'"+id+"',"+hpo,log)){
            log="'"+id+"','"+String.valueOf(password)+"','0'";
        }
        return id;
        
    }

    @Override
    public boolean hotelupdate(HotelPo hpo) throws RemoteException {
        int hotelid=hpo.getHotelID();
        return ht.update("'"+hotelid+"',"+hpo);
    }

    @Override
    public HotelPo findhotelbyid(int hotelID) throws RemoteException {


        String values=ht.find(hotelID);
        String[] hotels=values.split("!");

        return new HotelPo(hotels[0]);
    }
}
