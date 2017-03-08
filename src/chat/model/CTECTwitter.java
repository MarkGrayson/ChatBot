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
			boringWordScanner.nextLine();
			wordCount++;
		}
		boringWordScanner.close();
		
		boringWords = new String[wordCount];
		
		boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		for(int index = 0; index < boringWords.length; index++)
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
	
	private void turnTweetsToWords()
	{
		for(Status currentTweet : allTheTweets)
		{
			String text = currentTweet.getText();
			String [] tweetWords = text.split(" ");
			for(String word : tweetWords)
			{
				tweetedWords.add(word);
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
		gatherTheTweets(username);
		turnTweetsToWords();
		removeBoringWords();
		removeBlankWords();
		
		String information = "The tweetcount is " + allTheTweets.size() + 
				" and the word count after removal is " + tweetedWords.size();

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
			try
			{
				allTheTweets.addAll(twitterBot.getUserTimeline(user, statusPage));
			}
			catch (TwitterException twitterError)
			{
				baseController.handleErrors(twitterError);
			}
			pageCount++;
		}
	}
	
	public void send(String textToTweet)

	{
		
	}
	
	private String calculateTopWord()
	{
		String results = "";
		String topWord = "";
		int mostPopularIndex = 0;
		int popularCount = 0;
		
		for (int index = 0; index < tweetedWords.size(); index++)
		{
			for (int searched = index +1; searched < tweetedWords.size(); searched++)
		{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)))
				{
					currentPopularity++;
			}
		}
		if(currentPopularity > popularCount)
		{
			popularCount = currentPopularity;
			mostPopularIndex = index;
			topWord = tweetedWords.get(mostPopularIndex);
		}
	}
		results += " the most popular word was " + topWord + ", and it occurred " + popularCount + "times.";
		results += "\nThat means it has a percentage of " + popularCount/tweetedWords.size() * 100 + "%";
				
		return results;
	}
}