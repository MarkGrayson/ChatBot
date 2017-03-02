package chat.view;

/**
 * Imports ChabotController
 */
import chat.controller.ChatbotController;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import 
/**
 * Extends JPanel to fit baseController, baseLayout, chatDisplay, chatField, and chatButton
 * @author mpal7487
 *
 */
public class ChatPanel extends JPanel 
{
	private ChatbotController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	
	/**
	 * Adds SpringLayout, JTextArea, JTextField, and JButton to baseController. Changes the display size
	 * @param baseController
	 */
	public ChatPanel(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5, 25);
		chatField = new JTextField(25);
		
		chatButton = new JButton("Chat with the bot");
		
		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	/**
	 * Makes it so that ChatDisplay is not editable
	 */
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
		
	}
	
	/**
	 * Sets up how Panel will look without allowing the user to edit
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(chatDisplay);
		this.add(chatButton);
		this.add(chatField);
	}
	
	/**
	 * Sets up the Layout of chatbot and where everything will go
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 6, SpringLayout.SOUTH, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 41, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 95, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 23, SpringLayout.SOUTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 26, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, 0, SpringLayout.EAST, chatField);
	}
	
	/**
	 * Sets up a private Listener to see how to react to certain words.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				
				chatDisplay.setText("You said: " + userWords + "\n" + "ChatBot said: " + botResponse);
				chatField.setText("");
			}
		});
		}
}
