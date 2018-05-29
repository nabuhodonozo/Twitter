package pl.nabuhodonozo.twitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	@RequestMapping("/")
	public String homePage() {
		return "homePage";
	}
	
	
	@GetMapping("/cos")
	@ResponseBody
	public String add() {
		return "Dzialaam";
	}
}
