package com.careydevelopment.twitterlaughs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.careydevelopment.twitterlaughs.TwitterLaughs;
import com.careydevelopment.twitterlaughs.TwitterLaughsException;


@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
    @RequestMapping("/")
    public String home(Model model) {    	    
    	model.addAttribute("homeActive", "active");
    	
    	try {
    		List<String> tweets = TwitterLaughs.getInstance().getLaughs();
    		//List<String> tweets = new ArrayList<String>();
    		//tweets.add("<blockquote class=\"twitter-tweet\"><p lang=\"en\" dir=\"ltr\">THIS Q FOR NY PPL ONLY is the weather truly warm or freezing ny crisp ass air that people are pretending is warm bc ny life is so hard</p>&mdash; Chelsea Peretti (@chelseaperetti) <a href=\"https://twitter.com/chelseaperetti/status/721167235427860480\">April 16, 2016</a></blockquote><script async src=\"//platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>");
    		model.addAttribute("tweets",tweets);
    	} catch (TwitterLaughsException te) {
    		LOGGER.error("Problem retrieving jokes!",te);
    		return "trouble";
    	}
    		
        return "index";
    }
	        

}
