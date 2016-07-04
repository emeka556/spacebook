package controllers;

/**
 * @file    Main.java
 * @brief   Class to initialize and run spacebook application
 * @version 2015-4-22
 * @author  jfitzgerald
 */

import ie.wit.io.ictskills.In;
import ie.wit.io.ictskills.StdOut;

import java.util.ArrayList;

import models.LeaderBoard;
import models.User;

public class Main
{
  public static LeaderBoard leaderBoard = new LeaderBoard();
  private static ArrayList<User> users = new ArrayList<>();

  private static User homer;
  private static User lisa;
  private static User bart;
  private static User marge;
  private static User maggie;

  /**
   * Constructor sets up the Spacebook system by
   * creating a list of users
   * having a selection of users make friends
   * having some users engage in conversation by sending each other messages
   */
  public Main()
  {
    createUsers();
    createFriendships();
    createMessages();

  }

  private static void createUsers()
  {
    homer   = new User("Homer",   "Simpson", "homer@simpson.com",   "secret");
    lisa    = new User("Lisa",    "Simpson", "lisa@simpson.com",    "secret");
    bart    = new User("Bart",    "Simpson", "bart@simpson.com",    "secret");
    marge   = new User("Marge",   "Simpson", "marge@simpson.com",   "secret");
    maggie  = new User("Maggie",  "Simpson", "maggie@simpson.com",  "secret");

    users.add(homer);
    users.add(lisa);
    users.add(bart);
    users.add(marge);
    users.add(maggie);

  }

  private static void createFriendships()
  {
    homer.befriend(marge);
    homer.befriend(lisa);
    homer.befriend(bart);
    marge.befriend(homer);
    marge.befriend(lisa);
    lisa.befriend(homer);
    lisa.befriend(marge);
    bart.befriend(homer);
  }

  private static void createMessages()
  {
    marge.sendMessage(homer, "Where are You off to?");
    homer.sendMessage(marge, "I'm off to the pub?");
    lisa.sendMessage(homer, "Why are you not at work?");
    marge.sendMessage(homer, "Why are you going to the pub?");
    homer.sendMessage(marge, "Doh!");
    marge.sendMessage(homer, "Don't be late!");
    lisa.sendMessage(homer, "Explain Yourself?");
    homer.sendMessage(lisa, "I am working!?");
    marge.sendMessage(lisa, "Get your dad from the pub please");
  }

  /*
   * The following methods simulate Play rendering views
   */
  public void home_index()
  {
    Home.index(homer);
  }

  public void home_byUser()
  {
    Home.byUser(homer);
  }

  public void home_byConversation()
  {
    Home.byConversation(homer);
  }

  public static void leaderBoard_index()
  {
    LeaderBoard.index(users);
  }
  
  public static void leaderBoard_talkative()
  {
    LeaderBoard.talkative(users);
  }
  
  public static void leaderBoard_leastTalkative()
  {
    LeaderBoard.leastTalkative(users);
  }
  /*
   * This is a list of instructions on how to operate the spacebook application via this Main class.
   */
  private static void instructions()
  {
    System.out.println("Input integer on console to invoke method of your choice as follows:\n");
    System.out.println( "0 User's Home Page BY DATE\n"
                      + "1 User's Home Page BY USER\n"
                      + "2 User's Home Page BY CONVERSATION\n"
                      + "3 LeaderBoard MOST SOCIAL\n"
                      + "4 LeaderBoard MOST TALKATIVE\n"
                      + "5 LeaderBoard LEAST TALKATIVE\n"
                      + "-1 To Quit");
  }
  
  /**
   ***********************The main method**********************************************
   * 
   * Simulates the Play LeaderBoard and Home controller functionality
   * Uses Sedgewick & Wayne library to input choice in console
   * Input args via console
   * 
   * @param args program arguments integers in range [0 4] as follows:
   * 
   *    Spacebook: Home page for <user>
   *    0  runs Home.index                  (equivalent to BY DATE button press in Play app)
   *    1  runs Home.byUser                 (equivalent to BY USER button press)
   *    2  runs Home.byConversation         (equivalent to BY CONVERSATION button press)
   *    
   *    Social Leaderboard
   *    3  runs LeaderBoard.index           (equivalent to MOST SOCIAL button press)
   *    4  runs LeaderBoard.talkative       (equivalent to MOST TALKATIVE button press)
   *    5  runs LeaderBoard.leastTalkative  (new feature)
   *    
   *************************************************************************************/
  public static void main(String[] args)
  {
    Main controller = new Main();
    System.out.println("----------User Instructions  --------------");
    instructions();
    System.out.println("-------------------------------------------");
    int choice = 0;
    In in = new In();
    while(choice != -1)
    {
      choice = in.readInt();
      switch (choice)
      {
      case -1:
        System.out.println("Bye");
        System.exit(0);
        break;
      case 0:
        controller.home_index();
        break;
      case 1:
        controller.home_byUser();
        break;
      case 2:
        controller.home_byConversation();
        break;
      case 3:
        leaderBoard_index();
        break;
      case 4:
        leaderBoard_talkative();
        break;
      case 5:
        leaderBoard_leastTalkative();
        break;
      default:
        StdOut.println("You have entered an invalid number.");
      	StdOut.println("Valid integer range is between 1 and 5.");
      	StdOut.println("You may enter another number now.");
      	StdOut.println("Enter -1 to exit program.");
      }
    }
  }
}
