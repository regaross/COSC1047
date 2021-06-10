package question7;

//this class should really have javadocs in it

//class to simulate a die (singular of dice)
public class Die{

	//data fields that describe the state of a die.
	private int numSides;
	private int value;

	/**
	 * Zero-argument constructor.  Creates 6-sided Die with random (rolled) value.
	 */
	public Die(){
		this(6);
	}

	
	/**
	 * Argumented constructor.  Die will be rolled to have a random value.
	 * @param num number of sides on the Die.
	 */
	public Die(int num){
		if(num == 4 || num == 6 || num == 20 || num == 100)
			numSides = num;
		else 
			numSides = 6;
		this.roll();
	}

	/**
	 * Mutator that rolls the Die.  Value should be legal for the number of sides
	 * on the Die.
	 */
	public void roll(){
		value = (int)(Math.random()*numSides) + 1;
	}
	
	/**
	 * Accessor
	 * @return the side up - the value on the Die.
	 */
	public int getValue() { return value; }
	
	/**
	 * Accessor
	 * @return number of sides on the Die.
	 */
	public int getNumSides() { return numSides; }
	
	/**
	 * Return the String representation of a Die.
	 */
	public String toString() { return "Die["+numSides+" sides, value=" + value +"]"; }




	/**
	 * Equals method that checks the number of sides but ignores the value.
	 * @param in a die to check.
	 * @return true if equal (same number of sides), else false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Die other = (Die) obj;
		if (numSides != other.numSides)
			return false;
		return true;
	}


	
	
}
