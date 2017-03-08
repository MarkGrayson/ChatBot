package chat.model;

import chat.controller.ChatbotController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.Status;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import twitter4j.Paging;

public class CTECTwitter 
{
	private ChatbotController baseController;
	private Twitter twitterBot;
	private List<Status> searchedTweets;
	private List<String> ignoredWords;
	private List<String> tweetedWords;
	private List<Status> allTheTweets;
	
	public CTECTwitter(ChatbotController baseController)
	{
		this.baseController = baseController;
		this.searchedTweets = new ArrayList<Status>();
		this.ignoredWords = new ArrayList<String>();
		this.twitterBot = TwitterFactory.getSingleton();
		this.tweetedWords = new ArrayList<String>();
		this.allTheTweets = new ArrayList<Status>();
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
	
	public String [] createIgnoreWordArray()
	{
		String [] boringWords;
		int wordCount = 0;
		
		Scanner boringWordScanner = new Scanner(this.getClass().getResourcesAsStream("commonWords.txt"));
		while(boringWordScanner.hasNextLine())
		{
			wordCount++;
		}
		boringWordScanner.close();
		
		boringWords = new String[wordCount];
		
		boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		for(int index = 0; index < boirngWords.length; index++)
		{
			boringWords[index] = boringWordScanner.next();
		}
		boringWordScanner.close();
		
		return boringWords;
	}
	
	private void removeBoringWords()
	{
		String [] boringWords = createIgnoredWordsArray();
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(boringWords[boringIndex]))
				{
					tweetedWords.remove(index);
					index--;
					boringIndex = boringWords.length;
				}
			}
		}
	}
	
	private void removeBlankWords()
	{
		
	}
	
	private void collectTweets(String username)
	{
		
	}
	
	public String getMostPopularWord(String username)


	{
		removeBoringWords();
		removeBlankWords();

		return "";
	}
	
	private void gatherTheTweets(String user)
	{
		tweetedWords.clear();
		allTheTweets.clear();
		int pageCount = 1;
		Paging statusPage = new Paging(1,200);
		
		while(pageCount <= 10)
		{
			
			pageCount++;
		}
	}
	
	public void send(String textToTweet)
	{
		
	}
}