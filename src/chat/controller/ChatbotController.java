package chat.controller;

import chat.model.Chatbot;
import chat.model.CTECTwitter;
import chat.view.ChatViewer;
import chat.view.*;

public class ChatbotController 
{
	private Chatbot stupidBot;
	private ChatViewer display;
	private String baseFrame;
	private CTECTwitter tweetBot;
	
	public ChatbotController()
	{
		stupidBot = new Chatbot("Tina ya fat lard!!!!");
		display = new ChatViewer();

	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about today?????");
		
		while(stupidBot.lengthChecker(response))
		{
			display.displayMessage(useChatbotCheckers(response));
			response = display.collectResponse("oh, you are inrested in " + response);
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
		this.baseFrame = baseFrame;
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
	
	public void useTwitter(String text)
	{
		tweetBot.sendTweet(text);
	}
	
	public String searchTwitter(String name)
	{
		String results = "The top word form user: " + name + " is: ";
		results += tweetBot.getMostPopularWord(name);
		
		return results;
	}
}