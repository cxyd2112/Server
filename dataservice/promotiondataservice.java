package dataservice;

import java.util.Date;
import java.util.List;

import po.PromotionPo;

public interface promotiondataservice {
	
	public List<PromotionPo> find(Date date);
	
	public boolean insert(PromotionPo promotionPo);

}
