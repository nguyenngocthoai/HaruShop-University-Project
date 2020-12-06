package com.haru.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haru.entities.Employee;
import com.haru.services.EmployeeService;

@Controller
@RequestMapping("login/")
public class LoginController {

	@Autowired
	EmployeeService employeeService;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@GetMapping
	public String loginDefault() {
		return "login";
	}

	@PostMapping
	public String signUp(@RequestParam String userName, @RequestParam String email, @RequestParam String password,
			@RequestParam String rePassword, ModelMap modelMap) {
		boolean regexEmail = validate(email);
		if (regexEmail == true) {
			if (password.equals(rePassword)) {
				Employee e = new Employee();
				e.setUserName(userName);
				e.setEmail(email);
				e.setPassword(password);

				boolean checkAddEmployee = employeeService.addEmployee(e);
				if (checkAddEmployee == true) {
//					modelMap.addAttribute("msg", "Tạo tài khoản thành công.");
					return "login";
				} else {
					modelMap.addAttribute("msg", "Tạo tài khoản thất bại !");
				}
			} else {
				modelMap.addAttribute("msg", "Mật khẩu không trùng khớp !");
			}
		} else {
			modelMap.addAttribute("msg", "Email không hợp lệ !");
		}
		return "login";

	}

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

//	@PostMapping
//	@Transactional
//	public String handleLogin(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
//		boolean check = employeeService.handleLogin(email, password);
//		if (check == true) {
//			modelMap.addAttribute("msgLogin", "Đăng nhập thành công !");
//			System.out.println("Login success !");
//		} else {
//			modelMap.addAttribute("msgLogin", "Email hoặc Mật khẩu không hợp lệ !");
//			System.out.println("Login fail !");
//		}
//		return "login";
//	}
}
