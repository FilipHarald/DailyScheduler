/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.Serializable;

/**
 *
 * @author Aya
 */
public class UsernameAndPwdPair implements Serializable {
	private String userName;
	private char[] password;

	public UsernameAndPwdPair(String userName, String password) {
		this.userName = userName;
		this.password = password.toCharArray();
		

	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return String.valueOf(password);
	}

}
