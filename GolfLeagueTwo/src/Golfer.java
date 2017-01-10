public class Golfer implements Comparable<Golfer> {

	public int points = 13;
	public int weekscore;
	public String name;
	public int totalPoints;

	public Golfer(String name, int weekscore) {
		this.name = name;
		this.weekscore = weekscore;
	}

	public void addPoints(int points) {
		this.points = points;
	}

	public int getWeekScore() {

		return weekscore;
	}

	public String getName() {
		return this.name;

	}
	
	public int getTotalPoints()
	{
		this.totalPoints = totalPoints + points;
		return totalPoints;
		
	}
	
	public int getCurrentPoints(){
		
		return points;
	}

	@Override
	public int compareTo(Golfer comparescore) {
		int comparisonres = ((Golfer) comparescore).getWeekScore();
		return this.weekscore - comparisonres;
	}

}
