import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TextPanel extends JPanel {
	
	private JTextArea textArea;
	public TextPanel() {
		
		textArea = new JTextArea();
		
		//setLayout(new BorderLayout());
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(new JScrollPane(textArea), gbc);
		
	}
	public void append(String text) {
		
		textArea.append(text);
		
	}

}