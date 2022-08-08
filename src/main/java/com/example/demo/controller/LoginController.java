package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.impl.UserService;
import com.example.demo.utility.EncryptUtil;

@Controller
public class LoginController {
	@Autowired private UserService userService;
	@Autowired private HttpServletRequest request;
	@Autowired private HttpSession session;
	@Autowired private IUserRepository repository;
	
	@GetMapping("/login")
	public String formLogin() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(name="email",required = true)String email,
			@RequestParam(name="pass",required = true)String pass) {
		
		Users user = this.repository.findByEmail(email);
		Users passW = this.repository.findByPass(pass);
		session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("pass", passW);
		if(user == null && passW == null) {
			session.setAttribute("error", "Vui lòng điền đầy đủ thông tin!");
			return "redirect:/login";
		}
		return "redirect:/home/smartphone";
	}
	@GetMapping("/logout")
	public String logOut() {
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");       
        }
        return "redirect:/home/";
	}
	
	@GetMapping("/signin")
	public String processRegistration(Users user) {
		String encrypted = EncryptUtil.encrypt(request.getParameter("pass"));
		user.setPass(encrypted);
		userService.save(user);		
		return "register-message";
	}
}
