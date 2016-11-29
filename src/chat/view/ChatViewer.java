package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


public class ChatViewer 
{
	private String windowMessage;
	private ImageIcon chatIcon;
		
	public ChatView()
	{
		windowMessage = "This message brought to you by the chatbot! :D";
		chatIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
	}

	public String collectResponse(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type here Pleases!").toString();
		
		return response;
	}
	
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon );
		
		return response;
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
}
