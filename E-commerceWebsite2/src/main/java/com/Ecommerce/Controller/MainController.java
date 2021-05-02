package com.Ecommerce.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Ecommerce.Dao.userDaoImpl;
import com.Ecommerce.entity.User;

@Controller
public class MainController {

	@Autowired
	private userDaoImpl userdao;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String signup() {
	
		return "common/Signup";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
	
		return "common/login";
	}
	
	
	@RequestMapping(value = "/addUser",method = RequestMethod.POST)
	public @ResponseBody String addUser(HttpServletRequest request) {
	
		User userDetail=new User();
		userDetail.setUser_name(request.getParameter("username"));
		userDetail.setUser_password(request.getParameter("password"));
		userDetail.setUser_email(request.getParameter("email"));
		userDetail.setUser_address(request.getParameter("adddress"));
		userDetail.setMobile(request.getParameter("Mobnumber"));
		System.out.println("userDetail"+userDetail);
		String messeage = userdao.addUser(userDetail);
		System.out.println("messeage"+messeage);
		 if(!messeage.equals("****"))
		  return"Error adding user";
		return messeage;
	}
	
	
	// useraddCode
}
