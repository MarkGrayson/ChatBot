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
		String response = "Talking to you";
		
		while(stupidBot.lengthChecker(response))
		{
			response = chatView.collectResponse("What to talk about today?????");
		}
	}
}
