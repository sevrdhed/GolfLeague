import java.util.ArrayList;

public class Course {
	
	public String Name;
	public double Rating;
	public int Slope;
	public ArrayList<Course> courseList;

	 public Course(String Name, double Rating, int Slope)
	    {
	       this.Name = Name;
	       this.Rating = Rating;
	       this.Slope = Slope;
	       
	    }  
	 
	 public String getName(){
		 
		 return this.Name;
	 }
	 public double getRating(){
		 
		 return this.Rating;
	 }
	 public int getSlope(){
	 
	 return this.Slope;
 }

}
