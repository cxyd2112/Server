package dataserviceimpl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dataservice.promotiondataservice;
import datahelper.promotion;
import datahelper.datahelperimpl.promotionimpl;
import po.PromotionPo;

public class promotionserviceimpl implements promotiondataservice{
	
	private Map<String,PromotionPo> map;
	
	private promotion promotion;
	
	public promotionserviceimpl(){
		if(map==null){
			promotion = new promotionimpl();
			map = promotion.getPromotionData();
		}
		
	}
	
    public List<PromotionPo> promotionfind() throws RemoteException{
    	List<PromotionPo> promotionList = new ArrayList<PromotionPo>();
		Iterator<Map.Entry<String, PromotionPo>> iterator = map.entrySet().iterator();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		while(iterator.hasNext()){
			Map.Entry<String, PromotionPo> entry = iterator.next();
			PromotionPo promotionPo = entry.getValue();
			promotionList.add(promotionPo);
//			try {
//				Date dateBegin = sdf.parse(promotionPo.getBeginTime());
//				if(dateBegin.getTime()>=date.getTime()){
//					promotionList.add(promotionPo);
//				}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
		}
		return promotionList;
    }
	
	public int promotioninsert(PromotionPo promotionPo) throws RemoteException{
		/*
		 * 列表中添加策略并写入数据文件中
		 */
		int id=(int)(1000+Math.random()*(1000));
		String promotionName = promotionPo.getPromotionName();
		promotionPo.setPromotionNo(id);
		if(map.get(promotionName) == null){
			map.put(promotionName, promotionPo);
			if(promotion.updatePromotionData(promotionPo)){
				return id;
			}		
		}
		return id;
	}

}
