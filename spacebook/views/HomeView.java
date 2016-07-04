package views;

import java.util.ArrayList;
import java.util.List;

import models.Message;
import models.User;

public class HomeView
{
  /**
   * Displays a list of messages ordered by time-date
   * 
   * @param user the user whose inbox of messages is displayed
   * @param inbox the inbox of messages associate with the user
   * 
   */
  public static void index(User user, ArrayList<Message> inbox)
  {  
    System.out.println("-------------------------------------------");
    System.out.println("Spacebook: Home page for " + user.firstName + " " + user.lastName);
    System.out.println("Messages");
    displayMessages(inbox);
    System.out.println("-------------------------------------------");
    System.out.println("BY DATE");
    System.out.println("-------------------------------------------");
   }
  /**
   * Displays a list of messages ordered by user, that is, grouped by senders
   * 
   * @param user the user whose inbox of messages is displayed
   * @param inbox the inbox of messages associate with the user
   * 
   */  
  public static void byUser(User user, ArrayList<Message> inbox)
  {  
    System.out.println("-------------------------------------------");
    System.out.println("Spacebook: Home page for " + user.firstName + " " + user.lastName);
    System.out.println("Messages");
    displayMessages(inbox);
    System.out.println("-------------------------------------------");
    System.out.println("BY USER");
    System.out.println("-------------------------------------------");
  } 
  
  /**
   * Displays a list of conversations
   * A conversation comprises a time-ordered list of messages
   * Thus a list of conversations is a list of list of messages
   * 
   * @param user simulates the logged-in user with whom various other users converse
   * @param conversations the list of list of messages, that is, the list of conversations
   * 
   */
  public static void byConversation(User user, ArrayList<ArrayList<Message>> conversations)
  {
    System.out.println("-------------------------------------------");
    System.out.println("Spacebook: Home page for " + user.firstName + " " + user.lastName);
    System.out.println("Messages");
    displayConversations(conversations);
    System.out.println("-------------------------------------------");
    System.out.println("BY CONVERSATION");     
    System.out.println("-------------------------------------------");
  }
  /**
   * Displays a list of messages to standard output
   * 
   * @param messages a list of messages
   * 
   */
  private static void displayMessages(List<Message> messages)
  {
    for (Message message : messages)
    {
      message.displayMessage();
    }
  }
  
  /**
   * Displays a list of conversations to standard output
   * A conversation comprises a time-ordered list of messages between 2 users
   * 
   * @param conversations the list of conversations comprising a list of lists of messages
   * 
   */
  private static void displayConversations(ArrayList<ArrayList<Message>> conversations)
  {
    for (ArrayList<Message> conversation : conversations)
    {
      for (Message message : conversation)
      {
        message.displayMessage();
      }
    }
  }
}
