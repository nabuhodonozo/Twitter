package pl.nabuhodonozo.twitter.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.nabuhodonozo.twitter.repository.UserRepository;


@Controller
public class HomeController {
	@GetMapping("/")
	public String homePage() {
		return "login";
	}
	
	@Autowired
	UserRepository userRepository;
	@PostMapping("/")
	@ResponseBody //test line
	public String login(@RequestParam String login, @RequestParam String password) {
		if(userRepository.findByLogin(login) == null){
			return "Login doesnt exist";
		} else if(BCrypt.checkpw(password, userRepository.findByLogin(login).getPassword())) {
			return "Brawo zagogolowales sie";
		}else {
			return "Bledne haslo";
		}
	}
}
