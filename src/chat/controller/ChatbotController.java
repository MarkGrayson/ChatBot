package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;

public class ChatbotController 
{
	private Chatbot stupidBot;
	private ChatViewer chatView;
	
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
		if(!stupidBot.quitChecker(input))
	
			
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
		else
		{
			chatView.displayMessage("Thank you for chatting with me :D");
			System.exit(0);
		}
		
		return answer;
	}
}

