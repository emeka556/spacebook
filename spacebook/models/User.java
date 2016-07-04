package models;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
	public String firstName;
	public String lastName;
	int age;
	String nationality;
	String email;
	String password;

	public ArrayList<Friendship> friendships = new ArrayList<>();
	public ArrayList<Message> inbox = new ArrayList<>();
	public ArrayList<Message> outbox = new ArrayList<>();

	public User(String firstName, String lastName, int age, String nationality, String email, String password) {
		setState(firstName, lastName, age, nationality, email, password);
	}

	public User(String firstName, String lastName, String email, String password) {
		setState(firstName, lastName, 100, "USA", email, password);
	}

	private void setState(String firstName, String lastName, int age, String nationality, String email,
			String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.nationality = nationality;
		this.email = email;
		this.password = password;
	}

	public void broadcastMessage(String messageText) {
		for (Friendship f : friendships) {
			Message message = new Message(this, f.targetUser, messageText);
			outbox.add(message);
			f.targetUser.inbox.add(message);
		}
	}

	public void sendMessage(User to, String messageText) {
		Message message = new Message(this, to, messageText);
		outbox.add(message);
		to.inbox.add(message);
	}

	public void displayOutbox() {
		for (Message msg : outbox) {
			msg.displayMessage();
		}
	}

	public void displayInbox() {
		for (Message msg : inbox) {
			msg.displayMessage();
		}
	}

	public void befriend(User friend) {
		if (!(friend == this)) {
			Friendship friendship = new Friendship(this, friend);
			friendships.add(friendship);
		} else {
			System.out.println("Opps! You seem to have made a mistake in attempting to befriend yourself");
		}
	}

	public void unfriendAll() {
		Iterator<Friendship> it = friendships.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}

	public void unfriend(User friend) {
		for (Friendship friendship : friendships) {
			if (friendship.targetUser == friend) {
				friendships.remove(friendship);
				return;
			}
		}
	}

	public void displayFriends() {
		if (friendships.isEmpty()) {
			System.out.println("Unfortunately you have no friends");
		}
		for (Friendship friendship : friendships) {
			System.out.println("My friend is " + friendship.targetUser.firstName);
		}
	}

}