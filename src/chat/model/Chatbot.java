package chat.model;

/**Imports ArrayLists
 * 
 */
import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project.
 * @author Mark Palesh 
 * @version 1.0 10/14/16
 */
public class Chatbot 
{
	/**
	 * The list of memes.
	 */
	private ArrayList<String> memesList;
	/**
	 * The list of political topics.
	 */
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * * Creates an instance of the Chatbot with the supplied username. * @param
	 * userName The username for the chatbot.
	 */
	public Chatbot(String userName) 
	{
		/**
		 * Creates an ArrayList for politicalTopicList
		 */
		this.politicalTopicList = new ArrayList<String>();
		/**
		 * Creates an ArrayList for memeList
		 */
		this.memesList = new ArrayList<String>();
		/**
		 * Creates an ArrayList for userName
		 */
		this.userName = new String(userName);
		/**
		 * Creates an ArrayList for content
		 */
		this.content = new String("Sushi");
		/**
		 * Creates an ArrayList for buildMemesList
		 */
		this.buildMemesList();
		/**
		 * Creates an ArrayList for buildPoliticalTopicsList
		 */
		this.buildPoliticalTopicsList();
	}
	/**
	 * Makes buildMemesList private
	 */
	private void buildMemesList() {
	}
	/**
	 * Makes buildPoliticalTopicsList private
	 */
	private void buildPoliticalTopicsList() {
	}

	/**
	 * * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true. * @param currentInput * @return
	 * A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput) 
	{
		boolean hasLength = false;
		
		if (currentInput != null && currentInput.length() >0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}

	/**
	 * * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */
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
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPoliticalTopicChecker = false;
		
		if (currentInput.contains((CharSequence)politicalTopicList))
		{ 
			hasPoliticalTopicChecker = true;
		}
		
		return hasPoliticalTopicChecker = true;
		
	}

	/**
	 * * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput) {
		return false;
	}

	/**
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
	 */
	public String getUserName() {
		return null;
	}

	/**
	 * * Returns the content area for this Chatbot instance. * @return The
	 * content area for this Chatbot instance.
	 */
	public String getContent() {
		return null;
	}

	/**
	 * * Getter method for the memesList object. * @return The reference to the
	 * meme list.
	 */
	public ArrayList<String> getMemesList() {
		return memesList;
	}

	/**
	 * * Getter method for the politicalTopicList object. * @return The
	 * reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList() {
		return null;
	}

	/**
	 * * Updates the content area for this Chatbot instance. * @param content
	 * The updated value for the content area.
	 */
	public void setContent(String content) {
	}

}