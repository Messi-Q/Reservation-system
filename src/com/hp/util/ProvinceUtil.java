package com.hp.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import org.apache.commons.collections.map.StaticBucketMap;

import com.hp.entity.MapInfo;


public class ProvinceUtil {
	public static Map<String, String> getMap() {
		Map<String,String> map=new LinkedHashMap<>();
		map.put("anhui", "安徽");
		map.put("beijing", "北京");
		map.put("chongqing", "重庆");
		map.put("fujian", "福建");
		map.put("gansu", "甘肃");
		map.put("guangdong", "广东");
		map.put("guangxi", "广西");
		map.put("guizhou", "贵州");
		map.put("hainan", "海南");
		map.put("hebei", "河北");
		map.put("heilongjiang", "黑龙江");
		map.put("henan", "河南");
		map.put("hongkong", "香港");
		map.put("hubei", "湖北");
		map.put("hunan", "湖南");
		map.put("jiangsu", "江苏");
		map.put("jiangxi", "江西");
		map.put("jilin", "吉林");
		map.put("liaoning", "辽宁");
		map.put("macao", "澳门");
		map.put("neimenggu", "内蒙古");
		map.put("ningxia", "宁夏");
		map.put("qinghai", "青海");
		map.put("shandong", "山东");
		map.put("shanghai", "上海");
		map.put("shannxi", "陕西");
		map.put("shanxi", "山西");
		map.put("sichuan", "四川");
		map.put("taiwan", "台湾");
		map.put("tianjin", "天津");
		map.put("xinjiang", "新疆");
		map.put("xizang", "西藏");
		map.put("yunnan", "云南");
		map.put("zhejiang", "浙江");
		return map;
	}
	public static String getChines(String pingyin) {
		Map<String, String> map=getMap();
		return map.get(pingyin);
	}
	
	public static List<MapInfo> addImg(List<MapInfo> list) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setImgPath("imge/"+list.get(i).getProvince()+".jpg");
		}
		return list;
	}
}
