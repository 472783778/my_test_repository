package com.jxliu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxliu.ssm.mapper.ItemsMapper;
import com.jxliu.ssm.pojo.Items;
import com.jxliu.ssm.pojo.ItemsExample;
import com.jxliu.ssm.pojo.QueryVo;
import com.jxliu.ssm.pojo.ItemsExample.Criteria;
import com.jxliu.ssm.service.ItemService;

/**
 * 商品管理Service
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<Items> getItemList() {
		ItemsExample example = new ItemsExample();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public Items getItemById(int id) {
		//根据商品id查询商品信息
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void updateItem(Items items) {
		itemsMapper.updateByPrimaryKeySelective(items);
	}

	@Override
	public List<Items> getItemLists(QueryVo queryVo) {
		ItemsExample example = new ItemsExample();
		Criteria criteria = example.createCriteria();
		Integer id = queryVo.getItems().getId();
		String name = queryVo.getItems().getName();
		if(id!=null&&!id.equals("")){
			criteria.andIdEqualTo(id);
		}
		if(name!=null&&!name.equals("")){
			criteria.andNameLike("%"+name+"%");
		}
		List<Items> list = itemsMapper.selectByExample(example);
		for (Items items : list) {
			System.out.println(items.getId()+"==="+items.getName());
		}
		return list;
	}

}
