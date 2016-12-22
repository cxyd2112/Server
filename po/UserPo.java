package po;

import java.io.Serializable;

/**
 * Created by huihantao on 2016/11/27.
 */
public class UserPo implements Serializable {


    private int id;

    private String userName;

    private String birthday;

    private String phone;

    private int credit;

    private String company;

    private static final long serialVersionUID = 8383901821872620925L;

    public UserPo(){
        super();
    }

    public UserPo(int id, String userName, String birthday, String phone,
                  int credit, String company){
        super();
        this.id = id;
        this.userName = userName;
        this.birthday = birthday;
        this.phone = phone;
        this.credit = credit;
        this.company = company;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public int getCredit(){
        return credit;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String company){
        this.company = company;
    }


}
