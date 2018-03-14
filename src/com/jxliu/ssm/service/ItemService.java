package com.jxliu.ssm.service;

import java.util.List;

import com.jxliu.ssm.pojo.Items;
import com.jxliu.ssm.pojo.QueryVo;
public interface ItemService {
	List<Items> getItemList();
	Items getItemById(int id);
	void updateItem(Items items);
	List<Items> getItemLists(QueryVo queryVo);
}
