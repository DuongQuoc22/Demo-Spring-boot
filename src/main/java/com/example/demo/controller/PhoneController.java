package com.example.demo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.example.demo.entity.Phone;
import com.example.demo.entity.PhoneBrand;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.service.IService;
import com.example.demo.utility.CommonConst;


@Controller
//@RequestMapping("/smartphone")
public class PhoneController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	@Autowired
	private IService service;
	@Autowired
	private PhoneRepository repository;
	
	@Bean("viewResolver")
	public ViewResolver getViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;

	}
	@Bean("tilesConfigurer")
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/WEB-INF/views/layout/tiles.xml");
		return tilesConfigurer;
	}
	@RequestMapping("/home/smartphone")
	public String home(Model model) {
		List<Phone> fone = service.getAllPhone();
		model.addAttribute("fone", fone);
		return "home/home";
	}
	
	@RequestMapping("admin/smartphone/index")
	public String showIndex(@RequestParam(name="pageNumber", defaultValue = "0") int pageNumber, Model model) {
		Page<Phone> phonePage = service.getByPage(pageNumber, CommonConst.PAGE_SIZE);
		List<String> listBrand = Arrays.asList("Apple","Samsung","Xiaomi","Realme","Oppo","Nokia","Oneplus");
		model.addAttribute("listBrand", listBrand);
		model.addAttribute("page", phonePage);
		return "smartphone/indexPhone";
	}
	
	@RequestMapping("/admin/smartphone/add")
	public String add(Model model){
		List<String> listRam = Arrays.asList("4 Gb","6 Gb", "8 Gb","12 Gb");
		List<String> listRom = Arrays.asList("64 Gb", "128 Gb", "256 Gb", "512 Gb");
		List<String> listBrand = Arrays.asList("Apple","Samsung","Xiaomi","Realme","Oppo","Nokia","Oneplus");
		model.addAttribute("phone", new Phone());
		model.addAttribute("listRam", listRam);
		model.addAttribute("listRom", listRom);
		model.addAttribute("listBrand", listBrand);
		return "smartphone/createPhone";
	}
	
	@RequestMapping( value="/admin/smartphone/store", method = RequestMethod.POST)
	public String store(Phone phone){
			service.savePhone(phone);
			session.setAttribute("mess_add_phone", "Thêm sản phẩm thành công");
			// TODO: handle exception
		return "redirect:/admin/smartphone/index";
	}
	
	//
	@RequestMapping(value ="/admin/smartphone/update/{id}", method = RequestMethod.POST)
	public String updatePhone(Phone phone) {
		Phone  fone = service.updatePhone(phone);
		return "redirect:/admin/smartphone/index";
	}
	
	// hiển thị form update
	@RequestMapping(value ="/admin/smartphone/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") Integer id,Model model) {
		List<String> listRam = Arrays.asList("4 Gb","6 Gb", "8 Gb","12 Gb");
		List<String> listRom = Arrays.asList("64 Gb", "128 Gb", "256 Gb", "512 Gb");
		List<String> listBrand = Arrays.asList("Apple","Samsung","Xiaomi","Realme","Oppo","Nokia","Oneplus");
		Optional<Phone> editPhone = service.findPhoneById(id);
		Phone phone = editPhone.get();
		model.addAttribute("fone", phone);
		model.addAttribute("listRam", listRam);
		model.addAttribute("listRom", listRom);
		model.addAttribute("listBrand", listBrand);
		return "smartphone/editPhone";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Integer id, Model model) {
		service.deletePhone(id);
		return "redirect:/admin/smartphone/index";
	}
	// cần sửa lại
	@GetMapping("/admin/smartphone/search")
	public String findPhone(@RequestParam(name="brand",required = false) PhoneBrand brand,Model model) {
		List<Phone> list = repository.findAll();
		
		 if(StringUtils.hasText(brand.toString())) {
			list = repository.findByBrandLike(brand);
		}else {
			list = repository.findAll();
		}
			
		
		 
		model.addAttribute("phone", list);
		return "smartphone/searchPhone";
	}

	@GetMapping("/home/smartphone")
	public String findPhoneHome(@RequestParam(name="brand", required = false) PhoneBrand brand,@RequestParam(name="name", required = false) String name,Model model) {
		List<Phone> list = repository.findAll();
		if(name != null) {
			if(StringUtils.hasText(name)) {
				list = repository.findByNameLike("%"+name+"%");
			}else {
				list = repository.findAll();
			}
		}
		if(brand !=null) {
			if(StringUtils.hasText(brand.toString())) {
				list = repository.findByBrandLike(brand);
			}else {
				list = repository.findAll();
			}
		}
		model.addAttribute("fone", list);
		return "home/searchHome";
	}
	@RequestMapping(value ="/home/smartphone/details", method = RequestMethod.GET)
	public String detailsPhone(@RequestParam("id") Integer id,Model model) {
		Optional<Phone> editPhone = service.findPhoneById(id);
		Phone phone = editPhone.get();
		model.addAttribute("fone", phone);
		return "shopping/detailsPhone";
	}
	
}
