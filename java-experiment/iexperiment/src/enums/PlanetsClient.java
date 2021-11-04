package enums;
import callable.io.Print;
/**
 * @author A., Didum
 * @description PlanetsClient(): defines nine planets
 */
public class PlanetsClient {
	//instance var
	private Planets planet;
	
	/**
	 * PlanetsClient(): default constructor
	 */
	public PlanetsClient(Planets planet) {
		this.planet = planet;
	}
	
	/**
	 * getPlanets(): returns planets
	 * @return planets
	 */
	public Planets getPlanet() {
		return planet;
	}
	
	public String getPlanetName() {
		String distance = "";
		switch(planet) {
			case EARTH:
				distance = "10K";
				break;
			case MARS:
				distance = "30K";
				break;
			case JUPITER:
				distance = "12.5K";
				break;
			case VENUS:
				distance = "150.5K";
				break;
			case NAPTUN:
				distance = "25.56";
				break;
			case MOON:
				distance = "36K";
				break;
			case SUN:
				distance = "145.65K";
				break;
			case PLUTO:
				distance = "101.3K";
				break;
			default:
				//enum Planets is finite, therefore, no need for error checking
		}
		return distance;
	}
	
	/**
	 * @param args
	 * main(): application entry point
	 */
	public static void main(String[] args) {
		Print view = new Print();
		PlanetsClient gxy = new PlanetsClient(Planets.NAPTUN);
		view.println("Planet name: "+gxy.getPlanet()+" at "+gxy.getPlanetName()+" units from the sun.");
	}

}
