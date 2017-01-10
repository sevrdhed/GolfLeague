import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class InputPanel extends JPanel {

	private JLabel scoreLabel;
	private JLabel courseLabel;
	public JTextField scoreField;
	public JComboBox coursePulldown;
	public CourseList courseList;

	// This bit creates the panel that houses the main functions of the app -
	// the name of the golfer, the score input field, and the courselist.
	public InputPanel(String title) {

		scoreLabel = new JLabel("Score: ");
		courseLabel = new JLabel("Course: ");
		courseList = new CourseList();
		scoreField = new JTextField(10);
		coursePulldown = new JComboBox(courseList.courseListString());

		Border innerBorder = BorderFactory.createTitledBorder(title);
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		// Adding Score Label, First Row
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(scoreLabel, gc);

		// Adding Score Field
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(scoreField, gc);

		// Adding Course Label, Second Row
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(courseLabel, gc);

		// Adding Course Field
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(coursePulldown, gc);

	}

}
