/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.app.app.service;

import java.io.File;
import java.io.IOException;

import net.app.app.dto.User;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 *
 * @author tshepom
 */



//@Service
public class UserService {//implements UserService{

//    @Value("${userDetailsFilePath}")
	private static final String FILE_PATH = "user.json";

	public static void writeToFile(User user) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(FILE_PATH), user);
	}

	public static void updateFile(User user) throws IOException {
		writeToFile(user);
	}

	public static User readFile() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(FILE_PATH), User.class);
	}

	public static void deleteFile() throws IOException {
		new File(FILE_PATH).delete();
	}
	}
