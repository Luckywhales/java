package com.supermarket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.entity.Goods;
import com.supermarket.service.GoodsService;
import com.supermarket.util.ResponseUtil;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Resource
	public GoodsService goodsService;
	//加载商品信息
	@ResponseBody
	@RequestMapping("/goodsList")
	public Map<String, Object> goodsList(HttpServletResponse response, Goods goods,
			@RequestParam(value = "page", required = false) Integer page,//通过@RequestParam指定request传入参数和形参进行绑定
			@RequestParam(value = "limit", required = false) Integer limit) throws Exception {//limit为每页条数，required指定参数是否必须要传入
		Map<String, Object> result = ResponseUtil.resultFye(page, limit);
		if (goods.getType_id() != null) {
			if (goods.getType_id() == 1) {
				goods.setType_id(null);
			} else {
				result.put("type_id", goods.getType_id());
			}
		}
		if (goods.getName() != null) {
			String name = new String(goods.getName().getBytes("ISO-8859-1"), "UTF-8");
			result.put("name", name);
		}
		result.put("state", 2);
		List<Goods> goodsList = goodsService.findAll(result);
		Long count = goodsService.count(result);
		return ResponseUtil.result(goodsList, count);
	}
	
	//添加商品信息
	@ResponseBody
	@RequestMapping("/save")
	public Map<String, Object> save(Goods goods) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		if (goodsService.isEchoe(goods.getName()) != null) {
			result.put("success", false);
			result.put("errorInfo", "商品已存在,请检查！");
		} else {
			goodsService.add(goods);
			result.put("success", true);
		}
		return result;
	}
	
	//修改商品信息
	@ResponseBody
	@RequestMapping("/update")
	public Map<String, Object> update(Goods goods) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Goods goodsNumber = goodsService.findById(goods.getId());
		if(goodsNumber.getNumber()!=goods.getNumbers()){
			goods.setNumber(goods.getNumbers());
		}
		goodsService.update(goods);
		result.put("success", true);
		return result;
	}
	
	//退货
	@ResponseBody
	@RequestMapping("/updateReturn")
	public Map<String, Object> updateReturn(Goods goods) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
			Goods goodsNumber = goodsService.findById(goods.getId());
			Integer number = goodsNumber.getNumber()- goods.getReturnnumber();
			if(number>=0){
				goods.setNumber(number);
			}else{
				result.put("success", false);
				result.put("errorInfo", "退货数量大于库存数量，请重新输入");
				return result;
			}
		goodsService.update(goods);
		result.put("success", true);
		return result;
	}

	
	//删除商品信息
	@ResponseBody
	@RequestMapping("/delete")
	public Map<String, Object> delete(@RequestParam(value = "id", required = false) Integer id) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Goods goods = new Goods();
		goods.setState(0);
		goods.setId(id);
		System.out.println(goods.getState());
		goodsService.update(goods);
		result.put("success", true);
		return result;
	}
	
	//加载删除商品信息
	@ResponseBody
	@RequestMapping("/goodsDel")
	public Map<String, Object> goodsDel(HttpServletResponse response, Goods goods,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) throws Exception {
		Map<String, Object> result = ResponseUtil.resultFye(page, limit);
		if (goods.getName() != null) {
			String name = new String(goods.getName().getBytes("ISO-8859-1"), "UTF-8");
			result.put("name", name);
		}
		result.put("state", 0);
		List<Goods> goodsList = goodsService.findAll(result);
		Long count = goodsService.count(result);
		return ResponseUtil.result(goodsList, count);
	}
	
	//恢复商品信息
	@ResponseBody
	@RequestMapping("/goodsUpdate")
	public Map<String, Object> goodsUpdate(@RequestParam(value = "id", required = false) Integer id) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Goods goods = new Goods();
		goods.setState(2);//商品状态为2时正常
		goods.setId(id);
		goodsService.update(goods);
		result.put("success", true);
		return result;
	}
	
	//商品销售
	@ResponseBody
	@RequestMapping("/updatenumber")
	public Map<String, Object> updatenumber(Goods goods) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
			Goods goodsNumber = goodsService.findById(goods.getId());
			goods.setSalenumber(goods.getNumber());
			Integer number = goodsNumber.getNumber()- goods.getNumber();
			if(number>=0){ 
				goods.setNumber(number);
			}else{
				result.put("success", false);
				result.put("errorInfo", "销售数量大于库存数量，请重新输入");
				return result;
			}
		goodsService.update(goods);
		result.put("success", true);
		return result;
	}
}
