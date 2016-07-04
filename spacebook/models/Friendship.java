package models;

public class Friendship {
	public User sourceUser; // changed to public
	public User targetUser;

	public Friendship(User sourceUser, User targetUser) {
		this.sourceUser = sourceUser;
		this.targetUser = targetUser;
	}

	@Override
	public String toString() {
		return targetUser.firstName + ",s friend is " + targetUser.lastName;
	}
}
