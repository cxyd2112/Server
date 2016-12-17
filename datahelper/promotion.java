package datahelper;

import java.util.Map;

import po.PromotionPo;

public interface promotion {
	
	/**
	 * @return	从数据文件中读取策略数据
	 */
	public Map<String,PromotionPo> getPromotionData();
	
	/**
	 * 向数据文件中写入策略数据
	 * @param list	
	 */
	public boolean updatePromotionData(PromotionPo promotionPo);

}
