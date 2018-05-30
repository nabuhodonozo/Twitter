package pl.nabuhodonozo.twitter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String addToDB(@Valid User user, BindingResult result) {
		if(result.hasErrors()){
			return "addUserForm";
		}
		if(userRepository.findByUsername(user.getUsername()) != null){
			result.rejectValue("username", "error.userAlreadyExist", "This username is already used");
			return "addUserForm";
		}else if(userRepository.findByEmail(user.getEmail()) != null){
			result.rejectValue("email", "error.emailAlreadyExist", "This email is already used");
			return "addUserForm";
		}
		userRepository.save(user);	
		return "homePage";
	}
}
