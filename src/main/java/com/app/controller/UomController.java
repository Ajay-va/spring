package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Uom;
import com.app.service.IUomService;

@Controller("/Uom")
public class UomController {
	
	@Autowired
	private IUomService service;
	
	private String name;
	
	@RequestMapping("/register")
	public String showReg() {
		return "UomRegister";
	}
	
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Uom uom , ModelMap map)
	{

		Integer id=service.saveUom(uom);

		String message="Uom '"+id+"'created";

		map.addAttribute("msg",message);
		return "UomRegister";
	}
    
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		List<Uom> uoms=service.getAllUoms();
		map.addAttribute("list",uoms);
		return "UomData";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map)
	{
		
		service.deleteUom(id);
		List<Uom> uoms=service.getAllUoms();
		String msg="Deleted'"+id+"' Successfully";
		map.addAttribute("list", uoms);
		map.addAttribute("msg", msg);
		return "UomData";
		
	}
	
	
	
}
