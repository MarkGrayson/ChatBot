package chat.model;


import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project.
 * @author Mark Palesh 
 * @version 1.0 10/14/16
 */
public class Chatbot 
{
	
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	private String buildMemesList;
	private String buildPoliticalTopicList;
	private String memeChecker;
	private String politicalTopicChecker;
	private boolean looksTweetable;
	
	

	
	public Chatbot(String userName) 
	{
		
		this.politicalTopicList = new ArrayList<String>();
		this.memesList = new ArrayList<String>();
		this.userName = new String(userName);
		this.content = new String("Sushi");
		this.buildMemesList = new String();
		this.buildPoliticalTopicList = new String();
		this.politicalTopicChecker = new String();
		this.memeChecker = new String();
		this.looksTweetable = false;
	}
	
	private boolean buildMemesList(boolean memesList) 
	{
		boolean MemesList = false;
		if(buildMemesList !=null && getMemesList().size() > 17)
		{
			MemesList = false;
		}
		return MemesList;
	}
	
	private boolean buildPoliticalTopicsList(boolean politicalTopicList) 
	{
		boolean PoliticalTopicList = false;
		
		if(buildPoliticalTopicList !=null && getPoliticalTopicList().size() > 18)
		{
			PoliticalTopicList = true;
		}
		return PoliticalTopicList;
	}


	public boolean lengthChecker(String currentInput) 
	{
		boolean hasLength = false;
		
		if (currentInput != null && currentInput.length() >0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}


	public boolean contentChecker(String currentInput) 
	{
		boolean hasContent = false;
		
		String temp = "↑↓";
		System.out.println(temp + temp.toLowerCase());
		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}

	/**
	 * * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String politicalTopicList)
	{
		boolean hasPoliticalTopicChecker = false;
		
		if (politicalTopicChecker.contains(politicalTopicList))
		{ 
			hasPoliticalTopicChecker = true;
		}
		
		return hasPoliticalTopicChecker;
		
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if(currentInput.equalsIgnoreCase("quit"))
		{
			hasQuit = true;
		}
		else if(currentInput.equalsIgnoreCase("Exit"))
		{
			hasQuit = false;
		}
		
		return hasQuit;
	}

	public boolean memeChecker(String currentInput) {
		return false;
	}

	public String getUserName() {
		return null;
	}

	public String getContent() {
		return null;
	}

	
	public ArrayList<String> getMemesList() {
		return memesList;
	}

	
	public ArrayList<String> getPoliticalTopicList() {
		return null;
	}

	
	public void setContent(String content) {
	}

}