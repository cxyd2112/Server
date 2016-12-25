package datahelper;

/**
 * Created by huihantao on 2016/12/7.
 */
public interface hotel {
    String find(int hotelid);

    boolean insert(String values,String log);

    boolean update(String values);
}
