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
	
	public void start()
	{
		String response = chatView.collectResponse("What do you want to talk about today?????");
		
		while(stupidBot.lengthChecker(response))
		{
			chatView.displayMessage(useChatbotCheckers(response));
			response = chatView.collectResponse("oh, you are inrested in " + response);
		}
		
	}
		
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
	
	public void setBaseFrame(String baseFrame)
	{
		this.setbaseFrame = new baseFrame;
	}
	
	public void handleErrors(Exception currentException)
	{
		display.displayMessage("An error has occured. Details provided next.");
		display.displayMessage(currentException.getMessage());
	}
	
	public ChatViewer getPopup()
	{
		return display;
	}


