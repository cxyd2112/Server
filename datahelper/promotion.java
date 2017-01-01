package datahelper;

import java.util.Map;

import po.PromotionPo;

public interface promotion {
	
	
    boolean promotionerinsert(String values, String log);
    
    boolean promotionerupdate(String values);


	String findpromotion();

    boolean insert(String values);

    String findpromotioner(int id);
}
