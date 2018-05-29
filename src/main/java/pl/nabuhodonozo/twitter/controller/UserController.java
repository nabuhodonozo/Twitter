package pl.nabuhodonozo.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.nabuhodonozo.twitter.entity.User;
import pl.nabuhodonozo.twitter.repository.UserRepository;

@Controller
public class UserController {
	@GetMapping("/addUser")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "addUserForm";
	}
	
	@Autowired
	UserRepository userRepository;
	@PostMapping("/addUser")
	@ResponseBody
	public String addToDB(@ModelAttribute User user) {
		userRepository.save(user);
		return "Dodano";
	}
}
