package datahelper.datahelperimpl;

import datahelper.order;

/**
 * Created by huihantao on 2016/11/30.
 */
public class orderimpl implements order {


    private runner run;
    public orderimpl(){
        run=new runner();
    }


    @Override
    public String find(String type,int id) {
        String sql="SELECT * FROM homework.order WHERE "+type+"='"+id+"'";
        return run.read(sql);
    }

    @Override
    public boolean insert(String values) {
        String sql="INSERT INTO homework.order(orderid,userid,hotelid,createtime,executetime,delaytime,endtime,value,status,roomnum,roomstyle,assess,discount,score) VALUES("+values+");";
        System.out.println(sql);
        int i=run.write(sql);
        return (i==1);
    }

    @Override
    public boolean update(String values) {
        String sql="REPLACE INTO homework.order(orderid,userid,hotelid,createtime,executetime,delaytime,endtime,value,status,roomnum,roomstyle,assess,discount,score) VALUES("+values+");";
        int i=run.write(sql);
        return (i==2);
    }
}
