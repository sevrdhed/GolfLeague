import java.util.*;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;

public class CourseList {
	
	private ArrayList<Course> courseList;
	
	
	public CourseList()
	{
	//duh this is clearly the list of courses ratings and slopes
	courseList = new ArrayList<Course>();
    courseList.add(new Course("Mick Riley", 33.7, 109));
    courseList.add(new Course("South Mountain", 34.65, 121));
    courseList.add(new Course("Old Mill", 34.05, 122));
    courseList.add(new Course("River Bend", 34.95, 125));
    courseList.add(new Course("Mountain View", 34, 111));
    courseList.add(new Course("Meadow Brook", 34.85, 117));
    courseList.add(new Course("Wasatch Mtn Lake", 34.85, 123));
    courseList.add(new Course("Wasatch Mtn Mtn", 33.6, 120));
    courseList.add(new Course("Murray Parkway", 34.35, 111));
    courseList.add(new Course("Moab", 34.7, 128));
    courseList.add(new Course("Eaglewood", 34.25, 116));
    courseList.add(new Course("Wolf Creek", 34.85, 130));
    courseList.add(new Course("Bonneville", 34.85, 123));
    courseList.add(new Course("Forestdale", 32.1, 119));
    courseList.add(new Course("Mountain Dell Lake", 34.85, 125));
    courseList.add(new Course("Mountain Dell Mountain", 35.1, 120));
    courseList.add(new Course("Glendale", 33.4, 108));
    courseList.add(new Course("Nibley", 32.05, 112));
    courseList.add(new Course("Pebblebrook", 33.4, 106));
	}
    
    
	public ArrayList<Course> courseListArray(){
		
		return courseList;
	}
	
	//This is just a lazy way to display the string name in the pulldown menu because getting objects is hard. I should rewrite this later
	public String[] courseListString(){
		
		String[] courseListStringArray = {"Mick Riley", "Old Mill", "South Mountain", "River Bend", "Mountain View", "Meadow Brook", "Wasatch Mtn Lake",
				"Wasatch Mtn Mtn", "Murray Parkway", "Moab", "Eaglewood", "Wolf Creek", "Bonneville", "Forestdale", "Mountain Dell Lake", 
				"Mountain Dell Mountain", "Glendale", "Nibley", "Pebblebrook"};
		return courseListStringArray;
		
	}
//	public ComboBoxModel<String> courseListComboBox(){
//	
//		ComboBoxModel<String> courseListComboBox = new ComboBoxModel();
//		
//	
//	}
	
	

}
