package com.webservice.loginservice.service;

import org.springframework.beans.factory.parsing.ParseState;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.webservice.loginservice.user.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.webservice.loginservice.service.*;

@RestController // Le decimos que es un rest controller
@RequestMapping(path = "/loginService/User") // Ruta para encontrar el servicio
public class RestLogin {

	@RequestMapping(
			method = RequestMethod.POST, //indicamos que el servicio es POST
			path = "/validateUser", //Ruta del metodo
			consumes = "application/json", //Indicamos que recibe json
			produces = "application/json") //Indicamos que produce json
	public @ResponseBody User validateUser(@RequestBody User user) throws Exception {
		User response = new User();
		response.setFind(false);
		System.out.println("User: " + user.getUser());
		System.out.println("Password: " + user.getPassword());
		
		

		try {		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:\\Users\\JonathanMadrid\\Desktop\\info.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
		
				
			
			
			
				if (user.getUser().equals(jsonObject.get("user").toString()) && user.getPassword().equals(jsonObject.get("password").toString())) {
					User us = new User();				
					String usuario = (String) jsonObject.get("user");
					us.setUser(usuario);
					response.setName(jsonObject.get("name").toString());
					response.setUser(jsonObject.get("user").toString());
					response.setDate(jsonObject.get("date").toString());
					response.setFind(true);
					response.setPassword("******");
				}
			//}
			return response;
		} catch (Exception e) {

			return response;
		}
	}

}