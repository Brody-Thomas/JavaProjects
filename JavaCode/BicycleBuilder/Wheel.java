//(10/29/2025)
/*
 * Brody Thomas
 */
//I had help from a tutor

public class Wheel {
	
    //Default values and valid ranges
    public static final double DEFAULT_DIAMETER = 16.0;
    public static final double DEFAULT_WIDTH = 1.0;
    public static final double MIN_DIAMETER = 16.0;
    public static final double MAX_DIAMETER = 55.0;
    public static final double MIN_WIDTH = 1.0;
    public static final double MAX_WIDTH = 2.5;

    private double diameter;
    private double width;

    //Default constructor
    public Wheel() {
        diameter = DEFAULT_DIAMETER;
        width = DEFAULT_WIDTH;
    }
    //Parameterized constructor
    public Wheel(double diameter, double width) {
        setDiameter(diameter);
        setWidth(width);
    }
    //Should get diameter
    public double getDiameter() {
        return diameter;
    }
    //Should set diameter
    public void setDiameter(double diameter) {
        if(diameter >= MIN_DIAMETER && diameter <= MAX_DIAMETER)
            this.diameter = diameter;
        else
            this.diameter = DEFAULT_DIAMETER;
    }
    //Should get width
    public double getWidth() {
        return width;
    }
    //Should set width
    public void setWidth(double width) {
        if(width >= MIN_WIDTH && width <= MAX_WIDTH)
            this.width = width;
        else
            this.width = DEFAULT_WIDTH;
    }
    //Should check if two wheels are the same
    public boolean equals(Wheel other) {
        if(other == null) return false;
        return this.diameter == other.diameter && this.width == other.width;
    }
    //Should string form of a wheel
    public String toString() {
        return "[Wheel] Diameter: " + diameter + " Width: " + width;
    }
}