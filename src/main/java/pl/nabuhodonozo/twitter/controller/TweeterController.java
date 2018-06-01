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

import pl.nabuhodonozo.twitter.entity.Tweet;
import pl.nabuhodonozo.twitter.entity.User;
import pl.nabuhodonozo.twitter.repository.TweetRepository;
import pl.nabuhodonozo.twitter.repository.UserRepository;

@Controller
public class TweeterController {
	@Autowired
	TweetRepository tw;
	@GetMapping("/test")
	@ResponseBody
	public String initialize() {
		Tweet tweet1 = new Tweet();
		tweet1.setMessage("Dzialaj !!!!!!");
		
		tw.save(tweet1);
		
		return "Dodano";
	}
}
