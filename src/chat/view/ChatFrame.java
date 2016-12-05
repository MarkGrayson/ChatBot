package chat.view;

/**
 * Imports JFrame
 */
import javax.swing.JFrame;
/**
 * Imports Dimensions
 */
import java.awt.Dimension;
/**
 * Imports ChatbotController
 */
import chat.controller.ChatbotController;

/**
 * Extends JFrame to include baseController and ChatPanel
 * @author mpal7487
 *
 */
public class ChatFrame extends JFrame
{
	
	private ChatbotController baseController;
	private ChatPanel apppanel ;
	
	public ChatFrame(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		this.apppanel = new ChatPanel(baseController);
		
		this.setupFrame();
	}
	/**
	 * Sets up Frame with Title ContentPane Size and Visibile
	 */
	private void setupFrame()
	{
		this.setContentPane(apppanel);;
		this.setTitle("");
		this.setSize(new Dimension(600, 400));
		this.setVisible(true);
	}
}
