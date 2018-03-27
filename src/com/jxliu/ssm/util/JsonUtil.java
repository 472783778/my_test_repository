package com.jxliu.ssm.util;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 操作json数据的工具类
 * @author Administrator
 */
public class JsonUtil {
	private static Logger LOG = Logger.getLogger(JsonUtil.class);
	private static final ObjectMapper objectMapper = new ObjectMapper();
	/**
	 * 将java对象转json数据格式
	 * @param obj java对象
	 * @return json数据格式字符串
	 */
	public static String objToJson(Object obj){
		try {
			String json = objectMapper.writeValueAsString(obj);
			return json;
		} catch (JsonProcessingException e) {
			LOG.info("java对象转json数据失败！");
			e.printStackTrace();
		}
		return null;
	} 
	
}
