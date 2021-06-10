package question5;

/**
 * A class that encapsulates a unicycle wheel object.  
 * @author aaron
 *
 */

public class Wheel {

	private int diameter;
	private String type;
	
	
	/**
	 * No-argument constructor, creates a wheel of 12" and type learner.
	 */
	public Wheel(){
		//call argumented constructor
		this(12, "learner");
	}
	
	
	/**
	 * Argumented constructor.  Checks for valid wheel diameter and type.
	 * @param diameter diameter of wheel
	 * @param type type of wheel
	 */
	public Wheel(int diameter, String type){
		
		//since the constructor and the setWheel() method do the same work
		//i decided to consolidate.
		setWheel(diameter, type);
	}
	
	/**
	 * A private method that is used to make sure the diameter of the wheel
	 * is valid.  For safety reasons we're only allowing wheels between 12 and
	 * 18 inches.
	 * 
	 * @param diameter wheel diameter to be checked
	 * @return true if the wheel diameter is valid, otherwise false
	 */
	private boolean validDiameter(int diameter){
		if(diameter >= 12 && diameter <= 18)
			return true;
		return false;
	}
	
	/**
	 * A private method that is used to make sure the wheel type is valid.  Currently
	 * we stock only learner, mountain and street wheels.
	 * 
	 * @param type wheel type to be checked
	 * @return true if the wheel type is valid, otherwise false
	 */
	private boolean validType(String type){
		if(type.equals("learner") || type.equals("mountain")
				|| type.equals("street"))
			return true;
		return false;
	}
	
	/**
	 * Accessor for diameter field.
	 * @return diameter of the wheel
	 */
	public int getDiameter() { return diameter; }
	
	/**
	 * Accessor for type field.
	 * @return type of the wheel
	 */
	public String getType() { return type; }
	
	/**
	 * toString method - overrides Object toString.
	 */
	public String toString() { 
		return "Wheel[" + diameter + ", " + type +"]"; 
	}
	
	/**
	 * Set method to change the parameters of a wheel object.
	 * @param diameter diameter of the wheel
	 * @param type type of the wheel
	 * @throws IllegalArgumentException if wheel type or diameter is outside of specifications.
	 */
	public void setWheel(int diameter, String type){
		//check wheel diameter
		if(validDiameter(diameter))
			this.diameter = diameter;
		else
			throw new IllegalArgumentException("Not a valid diameter.");
		
		//check wheel type
		if(validType(type))
			this.type = type;
		else
			throw new IllegalArgumentException("Not a valid wheel type.");
		
	}
	
}
