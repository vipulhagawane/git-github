package com.dps.controller;

import com.dps.utils.AESUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

	private static final Logger logger = LogManager.getLogger(PasswordService.class);
	
	public String passwordHashing(String password) {
		System.out.println("password in hashing"+password);
		String decryptedPassword = null;
		try {
			AESUtil aesUtil = new AESUtil(128, 1000);
			if (password != null && password.split("::").length == 3) {
				System.out.println("In If");
				decryptedPassword = aesUtil.decrypt(password.split("::")[1], password.split("::")[0], "dealerCensus",
						password.split("::")[2]);
			}
			System.out.println("decryptedPassword in hashing"+decryptedPassword);
			return decryptedPassword;
		} catch (Exception e) {
			logger.info("Error while decrypting :", e);
			return null;
		}
	}
}
