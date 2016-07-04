package utils;

import java.util.Comparator;

import models.Message;

import utils.MessageDateComparator;

public class MessageDateComparator implements Comparator<Message> {
	@Override
	public int compare(Message a, Message b) {

		// compare the time-date attributes of each message
		// use the Date compareTo method
		// use appropriate attribute of Message b as the parameter
		return a.postedAt.compareTo(b.postedAt);
	}
}
