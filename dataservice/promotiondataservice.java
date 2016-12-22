package dataservice;

import java.util.Date;
import java.util.List;

import po.PromotionPo;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface promotiondataservice extends Remote{
	
	public List<PromotionPo> find() throws RemoteException;
	
	public boolean insert(PromotionPo promotionPo) throws RemoteException;

}
