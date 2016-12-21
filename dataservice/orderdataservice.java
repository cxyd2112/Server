package dataservice;


import po.OrderPo;

import java.util.ArrayList;

/**
 * Created by huihantao on 2016/11/30.
 */
public interface orderdataservice {
    OrderPo orderfindbyid(int orderid);

    ArrayList<OrderPo> orderfindbyuser(int userid);

    ArrayList<OrderPo> orderfindbyhotel(int hotelid);

    int orderinsert(OrderPo opo);

    boolean orderupdate(OrderPo opo);

}
