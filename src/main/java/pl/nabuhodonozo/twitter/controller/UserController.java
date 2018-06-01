package pl.nabuhodonozo.twitter.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String addToDB(@Valid User user, BindingResult result) {
		if(result.hasErrors()){
			return "addUserForm";
		}
		if(userRepository.findByLogin(user.getLogin()) != null){
			result.rejectValue("login", "error.userAlreadyExist", "This login is already used");
			return "addUserForm";
		}else if(userRepository.findByEmail(user.getEmail()) != null){
			result.rejectValue("email", "error.emailAlreadyExist", "This email is already used");
			return "addUserForm";
		}
		user.hashPassword();
		userRepository.save(user);	
		return "homePage";
	}

	@GetMapping("/account")
	public String account() {
		return "account";
	}
	
	//dunno if it's proper way of deleting things by url... mby js or smthing
	//but it's workin just dunt wanna give users opportunity to manualy go here by url, without account
	@GetMapping("/delete")
	@ResponseBody
	public String delete(HttpSession session) {
		Long id = Long.parseLong( session.getAttribute("user_id").toString());
		User entity = userRepository.findOne(id);
		userRepository.delete(entity);
		return "usuniteto" + entity.toString();
	}
	
	
	@GetMapping("/initialize")
	@ResponseBody
	public String initialize() {
		User user1 = new User();
		user1.setLogin("Maniek");
		user1.setPassword("Maniek123");
		user1.setEmail("q@q.q");
		user1.setUsername("Manius");
		user1.hashPassword();
		
		userRepository.save(user1);
		User user2 = new User();
		user2.setLogin("Jasiu");
		user2.setPassword("Jasiu123");
		user2.setEmail("e@e.e");
		user2.setUsername("Jasio");
		user2.hashPassword();
		
		userRepository.save(user2);
		User user3 = new User();
		user3.setLogin("Michal");
		user3.setPassword("Michal123");
		user3.setEmail("w@w.w");
		user3.setUsername("Michalek");
		user3.hashPassword();
		
		userRepository.save(user3);
		
		
		
		
		return "Dodano";
	}
}
