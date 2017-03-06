package chat.model;

import chat.controller.ChatbotController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.Status;
import java.util.List;
import java.util.ArrayList;

public class CTECTwitter 
{
	private ChatbotController baseController;
	private Twitter twitterBot;
	private List<Status> searchedTweets;
	private List<String> ignoredWords;
	
	public CTECTwitter(ChatbotController baseController)
	{
		this.baseController = baseController;
		searchedTweets = new ArrayList<Status>();
		ignoredWords = new ArrayList<String>();
		twitterBot = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String textToTweet )

	{
		try
		{
			twitterBot.updateStatus(textToTweet + "@chatbotctec");
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	
	public void createIgnoreWordList()
	{
		
	}
	
	private void collectTweets(String username)
	{
		
	}
	
	public String getMostCommonWord()
	{
		return null;
	}
}