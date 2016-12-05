package chat.controller;

/**
 * Imports Chatbot
 */
import chat.model.Chatbot;
/**
 * Imports ChatViewer
 */
import chat.view.ChatViewer;
/**
 * Uses public class ChatbotController with privates: stupidBot and chatView.
 * @author mpal7487
 *
 */
public class ChatbotController 
{
	private Chatbot stupidBot;
	private ChatViewer chatView;
	
	/**
	 * Uses privates to talk back to user.
	 */
	public ChatbotController()
	{
		stupidBot = new Chatbot("Tina ya fat lard!!!!");
		chatView = new ChatViewer();

	}
/**
 * Starts the program by asking a question. Then check for user response, and replys.
 */
	public void start()
	{
		String response = chatView.collectResponse("What do you want to talk about today?????");
		
		while(stupidBot.lengthChecker(response))
		{
			chatView.displayMessage(useChatbotCheckers(response));
			response = chatView.collectResponse("oh, you are inrested in " + response);
		}
		
	}
		
/**
 * Checks input for specific words, such as memes to reply with these comments, as well as if it is wrong it will reply with these comments.	
 * @param input
 * @return
 */
	public String useChatbotCheckers(String input)
	{
		String answer = "";
	
		{
		if(stupidBot.contentChecker(input))
		{
			answer += "\nYou know my special secret";
		}
		if(stupidBot.memeChecker(input))
		{
			answer +="\nI can has memes?\n";
		}
		
		if(answer.length() == 0)
		{
			answer += "Sorry, I don't know about" + input;
		}
		}
		
		
		return answer;
	}
}

