package dataserviceimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import datahelper.datahelperimpl.promotionimpl;
import datahelper.promotion;
import dataservice.promotiondataservice;
import po.PromotionPo;
import po.PromotionerPo;

public class promotionserviceimpl implements promotiondataservice{
    private String name;
    private int id;
    private String values;
    private promotion prm;

    public promotionserviceimpl(){
        prm=new promotionimpl();
    }


    @Override
    public int promotionerinsert(PromotionerPo ppo, char[] password) throws RemoteException {
        name=ppo.getName();

        id=(int)(3000+Math.random()*(1000));
        values="'"+id+"','"+name+"'";
        for(int i=0;i<password.length;i++)
            password[i]=(char)(password[i]-2);
        String log="'"+id+"','"+String.valueOf(password)+"','0'";
        while(!prm.promotionerinsert(values,log)){
            id=(int)(1000+Math.random()*(1000));
            values="'"+id+"','"+name+"'";
            log="'"+id+"','"+String.valueOf(password)+"','0'";
        }
        return id;



    }

    @Override
    public boolean promotionerupdate(PromotionerPo ppo) throws RemoteException {
        id=ppo.getId();
        name=ppo.getName();
        values="'"+id+"','"+name+"'";
        return prm.promotionerupdate(values);
    }

    @Override
    public PromotionerPo promotionerfind(int id) throws RemoteException {

        String values=prm.findpromotioner(id);
        String[] promotioners=values.split("\\.");
        String[] s=promotioners[0].split(",");

        //set UserPo
        name=s[1];



        return new PromotionerPo(id,name);
    }

    public List<PromotionPo> promotionfind() throws RemoteException{
        values=prm.findpromotion(id);
        if (values.equals("") )
            return null;

        String[] promotions=values.split("\\.");

        ArrayList<PromotionPo> l=new ArrayList<>();
       for(int i=0;i<promotions.length;i++){
           String[] list=promotions[i].split(",");
           int promotionnum=Integer.parseInt(list[0]);
           String promotionname=list[1];
           String begintime=list[2];
           String endtime=list[3];
           double discount=Double.parseDouble(list[4]);
           String place=list[5];
           l.add(new PromotionPo(promotionnum,promotionname,begintime,endtime,discount,place));

       }

    	return l;
    }
	
	public int promotioninsert(PromotionPo promotionPo) throws RemoteException{

		/*
		 * 列表中添加策略并写入数据文件中
		 */
        String promotionname=promotionPo.getPromotionName();
        String begintime=promotionPo.getBeginTime();
        String endtime=promotionPo.getEndTime();
        double discount=promotionPo.getDiscount();
        String place=promotionPo.getPlace();

        int orderid=(int)(1000+Math.random()*(9000));
        String values="'"+orderid+"','"+promotionname+"','"+begintime+"','"+endtime+"','"+discount+"','"+place+"'";
        while (!prm.insert(values)){
            orderid=(int)(1000+Math.random()*(9000));
            values="'"+orderid+"','"+promotionname+"','"+begintime+"','"+endtime+"','"+discount+"','"+place+"'";
        }



		return orderid;

	}

}
