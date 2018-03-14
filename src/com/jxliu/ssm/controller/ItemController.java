package com.jxliu.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jxliu.ssm.pojo.Items;
import com.jxliu.ssm.pojo.QueryVo;
import com.jxliu.ssm.service.ItemService;

/**
 * 商品处理Controller
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	/**
	 * 使用自动生成mapper查询商品列表
	 * @return
	 */
	@RequestMapping("/itemList")
	public ModelAndView getItemList() {
		//查询商品列表
		List<Items> itemList = itemService.getItemList();
		//把结果传递给页面
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", itemList);
		//设置逻辑视图
		modelAndView.setViewName("itemList");
		//返回结果
		return modelAndView;
	}
	
	/**
	 * 修改功能的中转，即点击修改按钮后，应该获取该商品信息存入model中，并跳转到修改页面
	 * RequestParam注解用于处理简单数据类型的绑定，defaultValue是默认值，required设置为true，默认也是true，表示请求中一定要有相应的参数，否则
	 * 会报400错误，value是与页面中传入的参数名字相同
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/itemEdit")
	public String getItemById(@RequestParam(defaultValue="1",required=true,value="id")Integer id,Model model){
		Items items = itemService.getItemById(id);
		model.addAttribute("item", items);
		//把结果传递给页面
		return "editItem";
	}
	
	/**
	 * 商品修改的方法
	 * @param items
	 * @return
	 */
	@RequestMapping("/updateitem")
	public String updateItem(Items items){
		//把结果传递给页面
		itemService.updateItem(items);
		return "redirect:/itemList.action";
	}
	
	/**
	 * 查询商品的方法
	 * @param queryVo
	 * @return
	 */
	@RequestMapping("/queryitem")
	public String queryItem(QueryVo queryVo,Model model){
		List<Items> itemLists = itemService.getItemLists(queryVo);
		model.addAttribute("itemList", itemLists);
		return "itemList";
	}
}
