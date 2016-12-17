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
	 
	 public Map<String,PromotionPo> getPromotionData(){
		Map<String,PromotionPo> map = new HashMap<String,PromotionPo>();
		String str = "SElECT * FROM software.homework ";
		String str2 = run.read(str);
		String[] datas = str2.split(";");
		for(int j=0;j<datas.length;j++){
		String[] data = datas[j].split(",");	
			int promotionNo = Integer.valueOf(data[0]);
			String promotionName = data[1];
			String beginTime = data[2];
			String endTime = data[3];
			double discount = Double.valueOf(data[4]);
			String place = data[5];
			PromotionPo promotionPo = new PromotionPo(promotionNo,promotionName,beginTime,endTime,discount,place);
			map.put(promotionName,promotionPo);
		
		}
		return map;				
	}
	 
	 public boolean updatePromotionData(PromotionPo promotionPo){
		 //写入数据		
		String str = "\""+promotionPo.getPromotionNo()+"\",\""+promotionPo.getPromotionName()+"\",\""+
		promotionPo.getBeginTime()+"\",\""+promotionPo.getEndTime()+"\",\""+promotionPo.getDiscount()+"\",\""+promotionPo.getPlace()+"\"";
		String str1 = "INSERT INTO software.homework(id,promotionName,beginTime,endTime,discount,place) VALUES("+str+");";
		int i=run.write(str1);	
		if(i==1){
			return true;
		}
		return false;
		}
}
