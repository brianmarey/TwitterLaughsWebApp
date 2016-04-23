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
public class JokesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(JokesController.class);
	
    @RequestMapping("/jokes")
    public String home(Model model) {    	    
    	try {
    		List<String> tweets = TwitterLaughs.getInstance().getLaughs();
    		model.addAttribute("tweets",tweets);
    	} catch (TwitterLaughsException te) {
    		LOGGER.error("Problem retrieving jokes!",te);
    		return "trouble";
    	}
    		
        return "jokes :: jokesfragment";
    }
	        

}
