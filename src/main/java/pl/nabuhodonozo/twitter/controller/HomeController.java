package pl.nabuhodonozo.twitter.controller;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.nabuhodonozo.twitter.entity.User;
import pl.nabuhodonozo.twitter.repository.UserRepository;


@Controller
public class HomeController {
	@GetMapping("/")
	public String homePage() {
		return "login";
	}
	
	
	//spring boot
	//spring data redis/jpa
	//spirng session
	@Autowired
	UserRepository userRepository;
	@PostMapping("/")
	@ResponseBody //test line
	public String login(@RequestParam String login, @RequestParam String password, HttpSession session) {
		User user = userRepository.findByLogin(login);
		if(user == null){
			return "Login doesnt exist";
		} else if(BCrypt.checkpw(password, user.getPassword())) {
			session.setAttribute("user_id", user.getId());
			return "Brawo zagogolowales sie";
		}else {
			return "Bledne haslo";
		}
	}
}
