package models;

import java.util.ArrayList;
import java.util.Date;

public class Message {
	public String messageText;
	public User from;
	public User to;
	public Date postedAt;

	public Message(User from, User to, String messageText) {
		this.from = from;
		this.to = to;
		this.messageText = messageText;
		postedAt = new Date();
		pause();
	}

	/*
	 * Pause briefly to ensure the Date postedAt values are sufficiently
	 * different to allow sorting. Here 10 milliseconds are used with effect but
	 * this figure may vary on other systems.
	 */
	private void pause() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public String toString() {
		return this.from.firstName + " says... " + this.messageText;
	}

	public void displayMessage() {
		System.out.println(toString());
	}

	public static void displayMessage(ArrayList<Message> messages) {
		for (Message message : messages) {
			message.displayMessage();
		}
	}
}