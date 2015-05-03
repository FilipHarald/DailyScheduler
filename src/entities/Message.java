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
	private User user;
	private String title;
	private String msg;
	private ArrayList<Integer> recipients = new ArrayList<Integer>();
	private int id;

	public Message(String title, String msg, int[] recipients, int id) {
		this.title = title;
		this.msg = msg;
		this.id = id;
		for (int r : recipients) {
			this.recipients.add(r);
		}

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

	public ArrayList<Integer> getRecipients() {
		return recipients;
	}

	public void setRecipients(Integer[] recipients) {
		for (Integer r : recipients) {
			this.recipients.add(r);
		}
	}

	public String toString() {
		return title;
	}
}
