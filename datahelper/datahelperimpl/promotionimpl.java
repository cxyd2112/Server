package datahelper.datahelperimpl;

import java.util.HashMap;
import java.util.Map;

import datahelper.promotion;
import po.PromotionPo;

public class promotionimpl implements promotion{
	 private runner run;

	 public promotionimpl(){
	     run=new runner();
	 }

	@Override
	public boolean promotionerinsert(String values, String log) {

		String sql1="INSERT INTO homework.promotioner(id, name ) VALUES("+values+");";
		String sql2="INSERT INTO homework.login(id, password,online) VALUES("+log+");";

		int i=run.write(sql1);
		int j=run.write(sql2);
		return (i==1)&&(j==1);


	}

	@Override
	public boolean promotionerupdate(String values) {


		String sql="REPLACE  INTO homework.promotioner(id, name ) VALUES("+values+");";
		int i=run.write(sql);
		return (i==2);
	}

	@Override

	public String findpromotion() {
		String sql="SELECT * FROM promotion ;";
		return run.read(sql);
	}

	@Override
	public boolean insert(String values) {

		String sql1="INSERT INTO homework.promotion(id, promotionName ,beginTime,endTime,discount,place) VALUES("+values+");";
		int i=run.write(sql1);

		return (i==1);
	}

	@Override
	public String findpromotioner(int id) {
		String sql="SELECT * FROM homework.promotioner WHERE id="+id;
		return run.read(sql);
	}
}
