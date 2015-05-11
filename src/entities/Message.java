/*
 ' * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public class Message implements Serializable {

	private int authorId;
	private String title;
	private String msg;
	private int id;
	private ArrayList<User> recipients;

	public Message(String msg, String title, int[] recipients, int id,
			int authorId) {
		this.title = title;
		this.msg = msg;
		this.id = id;
		ArrayList<User> temp = new ArrayList<User>();
		if (recipients != null) {
			for (int r : recipients) {
				temp.add(r);
			}
		}
		this.recipients = temp;
		this.authorId = authorId;

	}
	public int getAuthorId(){
		return authorId;
	
	}
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return msg;
	}

	public void setMessage(String string) {
		this.msg = msg;
	}

	public ArrayList<User> getRecipients() {
		return recipients;
	}

	public void setRecipients(User[] recipients) {
		for (User r : recipients) {
			this.recipients.add(r);
		}
	}

	public String toString() {
		return msg;
	}

}
