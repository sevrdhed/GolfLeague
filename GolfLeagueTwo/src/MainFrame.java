import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private TextPanel outputPanel;
	private InputPanel inputMatt;
	private InputPanel inputSteve;
	private InputPanel inputJr;
	private InputPanel inputSr;
	private JButton submitButton;
	private DBConnector connection;
	public Golfer steve;
	public Golfer matt;
	public Golfer jr;
	public Golfer sr;
	public CourseList courseList;
	public ArrayList<Course> courseListArray;
	public ArrayList<Golfer> golfers;
	
	public MainFrame() {

		super("Golf League");
		//These three lines currently open and then close the DB connection. This needs to be moved to later, when the lookups first occur. 
		//I fucked up and broke the DB and need to fix it. Meanwhile these three lines are commented out until I can.
		//connection = new DBConnector();
		//connection.createConnection();
		//connection.closeConnection();
		//Creates the array of courses
		courseList = new CourseList();
		courseListArray = new ArrayList<Course>(courseList.courseListArray());
		
		//The below is the basic creation of my GUI including each inputpanel (it's own class) and the output panel and submit button. 
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
			
		setLayout(new GridBagLayout());
		setSize(1000, 400);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridy = 0;
		gbc.gridx = 0;

		inputMatt = new InputPanel("Matt");
		add(inputMatt, gbc);

		gbc.gridx = 1;
		inputSteve = new InputPanel("Steve");
		add(inputSteve, gbc);

		gbc.gridx = 2;
		inputJr = new InputPanel("Trent Jr");
		add(inputJr, gbc);

		gbc.gridx = 3;
		inputSr = new InputPanel("Trent Sr");
		add(inputSr, gbc);
		
		//The following sets the submit button in the middle bottom right hand corner
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 3;
		add(submitButton, gbc);
		
		//The following sets the text panel in the bottom of the GUI
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridwidth = 4;
		outputPanel = new TextPanel();
		add(outputPanel, gbc);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//The below is where the main function of the application runs as this runs when the "Submit" button is clicked
	public void actionPerformed(ActionEvent e) {
		
		
	//This is a placeholder that passes the selected name from the Steve input panel.
		outputPanel.append(getCourseInfo(inputSteve.coursePulldown.getSelectedItem().toString()) + "\n");
		
		//This checks if the score field is missing for anyone
		if(inputMatt.scoreField.getText().isEmpty() || inputSteve.scoreField.getText().isEmpty() 
		|| inputJr.scoreField.getText().isEmpty() || inputSr.scoreField.getText().isEmpty()){
		outputPanel.append("ERROR: One of your scores is empty. Please add a score for all golfers (for a golfer who bailed on this round, enter 0)\n");
		}
		else{
		this.createGolferArray();	
		}
		
	}	

	public void createGolferArray(){
		
		//This array of golfers to be used for sorting, to allocate points and update handicaps
	
		golfers = new ArrayList<Golfer>();
		golfers.add(new Golfer ("Matt", Integer.valueOf(inputMatt.scoreField.getText())));
		golfers.add(new Golfer("Steve", Integer.valueOf(inputSteve.scoreField.getText())));
		golfers.add(new Golfer("Jr", Integer.valueOf(inputJr.scoreField.getText())));
		golfers.add(new Golfer("Sr", Integer.valueOf(inputSr.scoreField.getText())));
		Collections.sort(golfers);
		this.calculateWeekPoints();
	}
		
	public void calculateWeekPoints() {
		if (golfers.get(0).getWeekScore() == golfers.get(1).getWeekScore()) {
			golfers.get(0).addPoints(4);
			golfers.get(1).addPoints(4);
		} else {
			golfers.get(0).addPoints(4);
			golfers.get(1).addPoints(3);
		}

		if (golfers.get(1).getWeekScore() == golfers.get(2).getWeekScore()) {
			golfers.get(2).addPoints(golfers.get(1).getCurrentPoints());
		} else {
			golfers.get(2).addPoints(golfers.get(1).getCurrentPoints() - 1);
		}
		if (golfers.get(2).getWeekScore() == golfers.get(3).getWeekScore()) {

			golfers.get(3).addPoints(golfers.get(2).getCurrentPoints());
		} else {
			golfers.get(3).addPoints(golfers.get(2).getCurrentPoints() - 1);
		}

		for(int i = 0; i < golfers.size(); i++){
			if(golfers.get(i).getWeekScore() == 0){
				golfers.get(i).addPoints(0);
				int j = i + 1;
				if(i == 0){
				do{
					golfers.get(j).addPoints(golfers.get(j).getCurrentPoints() + 1);
					j++;				
				}while(j < golfers.size());
				}
			}	
		}

		outputPanel.append(golfers.get(0).getName() + " Points: "
				+ golfers.get(0).getTotalPoints() + "\n"
				+ golfers.get(1).getName() + " Points: "
				+ golfers.get(1).getTotalPoints() + "\n"
				+ golfers.get(2).getName() + " Points: "
				+ golfers.get(2).getTotalPoints() + "\n"
				+ golfers.get(3).getName() + " Points: "
				+ golfers.get(3).getTotalPoints() + "\n");
	}
	
	

	//This method when completed will pull the course information (slope and rating) for use in calculating the handicap of a given golfer.
	public String getCourseInfo(String selectedName) {

		// System.out.println(courseListArray.get(i).getName().contentEquals(selectedName));
		String courseName = new String();
		
		for (int i = 0; i < courseListArray.size(); i++) {
			courseName = courseListArray.get(i).getName();
			int courseSlope = courseListArray.get(i).getSlope();
			double courseRating = courseListArray.get(i).getRating();
			System.out.println(courseSlope);
			System.out.println(courseRating);
			if (courseName.contentEquals(selectedName)) {
				return courseName;
			}

		}

		return "Whoops! Get Course For loop ended. This shouldn't have happened.";
	}
}
