package utils;

import java.util.Comparator;

import models.User;

public class UserLeastTalkativeComparator implements Comparator<User> {
	@Override
	public int compare(User b, User a) {

		// Compare outbox sizes and return integer appropriate to sorting
		// smallest to largest
		return Integer.compare(b.outbox.size(), a.outbox.size());
	}
}
