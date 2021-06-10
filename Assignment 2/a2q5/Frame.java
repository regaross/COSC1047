package question5;

/**
 * This class encapsulates the frame for a unicycle.  This class is immutable
 * meaning, once a frame has been created it cannot be changed.
 * @author aaron
 *
 */

public class Frame {

	private int height;
	private String colour;
	
	/**
	 * No-argument constructor that creates a 12" blue frame.
	 */
	public Frame(){
		this(12, "blue");
	}
	
	/**
	 * Fully argumented constructor allowing for different heights
	 * and colours.  The object is only constructed if a valid height
	 * argument is provided.  Colour is not checked.
	 * 
	 * @param height height of the frame.  
	 * @param colour colour of the frame.
	 */
	public Frame(int height, String colour){
		//Since the constructor and the setFrame() method do the same
		//work i decided to consolidate.
		setFrame(height, colour);
	}
	
	/**
	 * A private method that is used to make sure the height of the frame
	 * is valid.  For safety reasons we're only allowing frames between 12 and
	 * 36 inches.
	 * 
	 * @param height frame height to be checked
	 * @return true if the frame height is valid, otherwise false
	 */
	private boolean validHeight(int height){
		if(height >= 12 && height <= 36)
			return true;
		return false;
	}
	
	/**
	 * Accessor for the height data field
	 * @return height of the frame
	 */
	public int getHeight() { return height; }
	
	/**
	 * Accessor for the colour data field
	 * @return colour of the frame
	 */
	public String getColour() { return colour; }
	
	/**
	 * toString method - overrides Object toString.
	 */
	public String toString() { 
		return "Frame[" + height + ", " + colour +"]"; 
	}
	
	/**
	 * Mutator for the frame object.
	 * @param height height of the frame
	 * @param colour colour of the frame
	 */
	public void setFrame(int height, String colour){
		if(validHeight(height))
			this.height = height;
		else
			throw new IllegalArgumentException("Not a valid height.");
		this.colour = colour;
	}
}
