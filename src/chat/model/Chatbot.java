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
	
	public boolean keyBoardMashChecker(String currentInput)
	{
		boolean hasKeyBoardMash = false;
		
		if(currentInput.equalsIgnoreCase("S.D.F"))
		{
			hasKeyBoardMash = false;
		}
		else if(currentInput.equalsIgnoreCase("derf"))
		{
			hasKeyBoardMash = false;
		}
		else if(currentInput.equalsIgnoreCase("sdf"))
		{
			hasKeyBoardMash = true;
		}
		else if(currentInput.equalsIgnoreCase("dfg"))
		{
			hasKeyBoardMash = true;
		}
		else if(currentInput.equalsIgnoreCase("cvb"))
		{
			hasKeyBoardMash = true;
		}
		else if(currentInput.equalsIgnoreCase(",./"))
		{
			hasKeyBoardMash = true;
		}
		
		return hasKeyBoardMash;
	}

	public boolean memeChecker(String memeChecker) 
	{
		
		boolean hasmemeChecker = false;
		
		if(memeChecker.equals("dodge"))
		{
			hasmemeChecker = true;
		}
		else if(memeChecker.equals("cute animals"))
		{
			hasmemeChecker = true;
		}
		
		return hasmemeChecker;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return null;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	
	public void setMemesList(ArrayList<String> memesList)
	{
		this.memesList = memesList;
	}
	
	public ArrayList<String> getMemesList() 
	{
		return memesList;
	}

	public void setpoliticalTopicList(ArrayList<String>politicalTopicList)
	{
		this.politicalTopicList = politicalTopicList;
	}
	
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	public boolean twitterChecker(String input)
	{
		boolean looksTweetable = false;
		if(input == null)
		{
			return false;
		}
		
		int indexOfHash = input.indexOf("#");
		int indexOfAt = input.indexOf("@");
		
		if(indexOfHash >= 0 || indexOfAt >= 0)
		{
			if(indexOfHash != - 1)
			{
				if(!input.substring(indexOfHash + 1, indexOfHash +2).equals(" "))
				{
					looksTweetable = true;
				}
			}
		}
		
		return looksTweetable = true;
	}
	
	public boolean inputHTMLChecker(String input)
	{
		boolean containsHTML = false;
		
		if(input == null || !input.contains("<"))
		{
			return containsHTML;
		}
		
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf("< ", firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		if(input.contains("<>") || input.indexOf("< >") > -1)
		{
			containsHTML = false;
		}
		if(input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
		{
			containsHTML = true;
		}
		else if (firstClose > firstOpen)
		{
			tagText = input.substring(firstOpen + 1, firstClose).toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
			
			if(tagText.contains("a href=\""))
			{
				if(tagText.indexOf("\"", firstOpen+10) >= 0)
				{
					String remainder = input.substring(firstClose);
					if(remainder.indexOf("</a>") >= 0)
					{
						containsHTML = true;
					}
				}
			}
			else if(secondOpen >= 0)
			{
				secondClose = input.indexOf(">", secondOpen + tagText.length());
				String closingTag = input.toLowerCase().substring(secondOpen+2,secondClose);
				if(secondClose >= 0 && closingTag.equals(tagText))
				{
					containsHTML = true;
				}
				else
				{
					containsHTML = false;
				}
			}
			else
			{
				containsHTML = false;
			}
		}
		
		return containsHTML;
	}
}
