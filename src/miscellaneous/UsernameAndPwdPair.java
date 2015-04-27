/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.Serializable;

/**
 *
 * @author Aya & Filip
 */
public class UsernameAndPwdPair implements Serializable {
	private char[] password;
	private int userId;

//	public UsernameAndPwdPair(int userId, String password) {
//		this.userId = userId;
//		this.password = password.toCharArray();
//	}
	
	public UsernameAndPwdPair(int userId, char[] password) {
		this.userId = userId;
		this.password = password;
	}

	public String getPassword() {
		return String.valueOf(password);
	}

	public int getUserId() {
		return userId;
	}

}
