package models;
/**
* @file    LeaderBoard.java
* @brief   Class publishes users graded most socially and talkatively active
* @version 2015-4-22
*/

import java.util.ArrayList;
import java.util.Collections;

import utils.UserLeastTalkativeComparator;
import utils.UserSocialComparator;
import utils.UserTalkativeComparator;
import views.LeaderBoardView;

public class LeaderBoard {
	public static void index(ArrayList<User> users) {

		Collections.sort(users, new UserSocialComparator());
		LeaderBoardView.index(users);
	}

	public static void talkative(ArrayList<User> users) {

		/*
		 * sort users by most talkative, that is by most messages sent render
		 * list users in LeaderBoardView
		 */

		Collections.sort(users, new UserTalkativeComparator());
		LeaderBoardView.talkative(users);

	}

	public static void leastTalkative(ArrayList<User> users) {

		/*
		 * sort users by least talkative, that is by least messages sent render
		 * list users in LeaderBoardView
		 */
		Collections.sort(users, new UserLeastTalkativeComparator());
		LeaderBoardView.leastTalkative(users);

	}
}
