package rmi;

/**
 * Created by huihantao on 2016/11/28.
 */
import dataservice.*;
import dataserviceimpl.*;
import po.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


public class dataremoteobject extends UnicastRemoteObject implements userdataservice , logindataservice, hoteldataservice, orderdataservice, promotiondataservice {

    private static final long serialVersionUID = 10L;

    private userdataservice userserve;
    private logindataservice loginserve;
    private hoteldataservice hotelservice;
    private orderdataservice orderservice;
    private promotiondataservice promotionservice;
    public dataremoteobject() throws RemoteException{
        userserve=new userserviceimpl();
        loginserve=new loginserviceimpl();
        hotelservice=new hotelserviceimpl();
        orderservice=new orderserviceimpl();
        promotionservice=new promotionserviceimpl();
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
    public UserPo userfind(int id) throws RemoteException {
        return userserve.userfind(id);
    }

    @Override
    public int orderinsert(OrderPo opo) throws RemoteException {
        System.out.println(opo);
//        return 10;
        return orderservice.orderinsert(opo);
    }

    @Override
    public boolean orderupdate(OrderPo opo) throws RemoteException {
    	System.out.println("     "+opo.getRoomstyle()+"asdasdsada");
        return orderservice.orderupdate(opo);
    }

    @Override
    public OrderPo orderfind(int orderid) throws RemoteException {
        return orderservice.orderfind(orderid);
    }

    @Override
    public List<OrderPo> findorderbyuserid(int userid) throws RemoteException {
        return orderservice.findorderbyuserid(userid);
    }

    @Override
    public List<OrderPo> findorderbyhotelid(int hotelid) throws RemoteException {
    	System.out.print(hotelid);
        return orderservice.findorderbyhotelid(hotelid);
    }

    @Override
    public boolean login(String id, char[] password) throws RemoteException {
//        return true;
        return loginserve.login(id,password);
    }

    @Override
    public void logout(int id) throws RemoteException {
        loginserve.logout(id);
    }

    @Override
    public List<HotelPo> usergethotellist(int userid) throws RemoteException {

        return hotelservice.usergethotellist(userid);
    }

    @Override
    public List<HotelPo> getallhotellist() throws RemoteException {
        return hotelservice.getallhotellist();
    }

    @Override
    public int hotelinsert(HotelPo hpo, char[] password) throws RemoteException {
        return hotelservice.hotelinsert(hpo,password);
    }

    @Override
    public boolean hotelupdate(HotelPo hpo) throws RemoteException {
        return hotelservice.hotelupdate(hpo);
    }

    @Override
    public HotelPo findhotelbyid(int hotelID) throws RemoteException {
        return hotelservice.findhotelbyid(hotelID);
    }

    @Override
    public int promotionerinsert(PromotionerPo ppo, char[] password) throws RemoteException {
        return promotionservice.promotionerinsert(ppo,password);
    }

    @Override
    public boolean promotionerupdate(PromotionerPo ppo) throws RemoteException {
        return promotionservice.promotionerupdate(ppo);
    }

    @Override
    public PromotionerPo promotionerfind(int id) throws RemoteException {
        return promotionservice.promotionerfind(id);
    }

    @Override
    public List<PromotionPo> promotionfind() throws RemoteException {
        return promotionservice.promotionfind();
    }

    @Override
    public int promotioninsert(PromotionPo pormotionPo) throws RemoteException {
        return promotionservice.promotioninsert(pormotionPo);
    }
}
