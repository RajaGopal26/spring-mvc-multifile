package com.aalam.spring.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.aalam.spring.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Controller
public class HomeController extends TextWebSocketHandler {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/*
	 * @RequestMapping(value = "/home", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * System.out.println("Home Page Requested, locale = " + locale); Date date =
	 * new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate);
	 * 
	 * return "home"; }
	 */
	 

	/*
	 * @GetMapping("/") public String index() { return "index"; }
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		return "users";
	}
	
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(OutputMessage message) throws Exception {
	    String time = new SimpleDateFormat("HH:mm").format(new Date());
	    return new OutputMessage(message.getFrom(), message.getMessage(), time);
	}
	
	 @Getter
	 @Setter
	 @AllArgsConstructor
	 public class OutputMessage{
		 
		 private String from;
		 
		 private String message;
		 
		 private String time;
	 }
}
