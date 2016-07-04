package views;
import java.util.ArrayList;

import models.User;
public class LeaderBoardView
{
  public static void index(ArrayList<User> users)
  {
    System.out.println("-------------------------------------------");
    System.out.println("Social Leaderboard");
    displayUserList(users);
    System.out.println("-------------------------------------------");
    System.out.println("MOST SOCIAL");
    System.out.println("-------------------------------------------");
  }
  
  public static void talkative(ArrayList<User> users)
  {
    System.out.println("-------------------------------------------");
    System.out.println("Social Leaderboard");
    displayUserList(users);
    System.out.println("-------------------------------------------");
    System.out.println("MOST TALKATIVE");    
    System.out.println("-------------------------------------------");
 }

  public static void leastTalkative(ArrayList<User> users)
  {
    System.out.println("-------------------------------------------");
    System.out.println("Social Leaderboard");
    displayUserList(users);
    System.out.println("-------------------------------------------");
    System.out.println("LEAST TALKATIVE");    
    System.out.println("-------------------------------------------");
 }
  private static void displayUserList(ArrayList<User> users)
  {
    int index = 1;
    for(User user : users)
    {
      String s =  index + " " 
                  + user.firstName + " " + user.lastName 
                  + "(inbox-" + user.inbox.size() 
                  + ",outbox-" + user.outbox.size()
                  + ",friends-" + user.friendships.size()
                  + ")";
      System.out.println(s);
    }
  }
}
