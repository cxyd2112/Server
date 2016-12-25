package dataserviceimpl;

import datahelper.datahelperimpl.orderimpl;
import dataservice.orderdataservice;
import datahelper.order;
import po.OrderPo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huihantao on 2016/11/30.
 */
public class orderserviceimpl implements orderdataservice {
    private String values;
    private order order;

    public orderserviceimpl() {
        order=new orderimpl();
    }

    @Override
    public OrderPo orderfind(int orderid) {
        values=order.find("orderid",orderid);
        if (values.equals("")) return  null;
        String[] orders=values.split("\\.");
        String[] s=orders[0].split(",");
        int userid=Integer.parseInt(s[1]);
        int hotelid=Integer.parseInt(s[2]);
        long createtime=Long.parseLong(s[3]);
        long executetime=Long.parseLong(s[4]);
        long delaytime=Long.parseLong(s[5]);
        long endtime=Long.parseLong(s[6]);
        int value=Integer.parseInt(s[7]);
        int status=Integer.parseInt(s[8]);
        int roomnum=Integer.parseInt(s[9]);
        int roomstyle=Integer.parseInt(s[10]);
        String assess=s[11];
        double discount= Double.parseDouble(s[12]);
        int score=Integer.parseInt(s[13]);


        return new OrderPo(orderid,userid,hotelid,createtime,executetime,delaytime,endtime,value,status,roomnum,roomstyle,assess,discount,score);
    }

    @Override
    public List<OrderPo> findorderbyuserid(int userid) {
        values=order.find("userid",userid);

        if (values.equals("")) return  null;
        String[] orders=values.split("\\.");
        ArrayList<OrderPo> res=new ArrayList<>();
        for(int i=0;i<orders.length;i++) {

            String[] s = orders[i].split(",");
            int orderid=Integer.parseInt(s[0]);
            int hotelid=Integer.parseInt(s[2]);
            long createtime=Long.parseLong(s[3]);
            long executetime=Long.parseLong(s[4]);
            long delaytime=Long.parseLong(s[5]);
            long endtime=Long.parseLong(s[6]);
            int value=Integer.parseInt(s[7]);
            int status=Integer.parseInt(s[8]);
            int roomnum=Integer.parseInt(s[9]);
            int roomstyle=Integer.parseInt(s[10]);
            String assess=s[11];
            double discount= Double.parseDouble(s[12]);
            int score=Integer.parseInt(s[13]);
            res.add(new OrderPo(orderid,userid,hotelid,createtime,executetime,delaytime,endtime,value,status,roomnum,roomstyle,assess,discount,score));
        }
        return res;
    }

    @Override
    public List<OrderPo> findorderbyhotelid(int hotelid) {
        values=order.find("hotelid",hotelid);
        if (values.equals("")) return  null;
        String[] orders=values.split("\\.");
        ArrayList<OrderPo> res=new ArrayList<>();
        for(int i=0;i<orders.length;i++) {


            String[] s = orders[i].split(",");
            int orderid=Integer.parseInt(s[0]);
            int userid=Integer.parseInt(s[1]);
            long createtime=Long.parseLong(s[3]);
            long executetime=Long.parseLong(s[4]);
            long delaytime=Long.parseLong(s[5]);
            long endtime=Long.parseLong(s[6]);
            int value=Integer.parseInt(s[7]);
            int status=Integer.parseInt(s[8]);
            int roomnum=Integer.parseInt(s[9]);
            int roomstyle=Integer.parseInt(s[10]);
            String assess=s[11];
            double discount= Double.parseDouble(s[12]);
            int score=Integer.parseInt(s[13]);
            res.add(new OrderPo(orderid,userid,hotelid,createtime,executetime,delaytime,endtime,value,status,roomnum,roomstyle,assess,discount,score));
        }
        return res;
    }

    @Override
    public int orderinsert(OrderPo opo) {
        int orderid=(int)(1000+Math.random()*(9000));
        while (!order.insert("'"+orderid+"',"+opo)){
            orderid=(int)(1000+Math.random()*(9000));
        }

        return orderid;
    }

    @Override
    public boolean orderupdate(OrderPo opo) {
        int orderid=opo.getOrderid();
        return order.update("'"+orderid+"',"+opo);
    }
}
