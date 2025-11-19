//(10/29/2025)
/*
 * Brody Thomas
 */
//I had help from a tutor

public class Frame {
	
    //Default values and valid ranges
    public static final double DEFAULT_SIZE = 18.5;
    public static final String DEFAULT_TYPE = "Diamond";
    public static final double MIN_SIZE = 18.5;
    public static final double MAX_SIZE = 60.0;

    private double size;
    private String type;

    //Default constructor
    public Frame() {
        size = DEFAULT_SIZE;
        type = DEFAULT_TYPE;
    }
    //Parameterized constructor
    public Frame(double size, String type) {
        setSize(size);
        setType(type);
    }
    //Should get size
    public double getSize() {
        return size;
    }
    //Should set size
    public void setSize(double size) {
        if(size >= MIN_SIZE && size <= MAX_SIZE)
            this.size = size;
        else
            this.size = DEFAULT_SIZE;
    }
    //Should get type
    public String getType() {
        return type;
    }
    //Should set type
    public void setType(String type) {
        if(type == null) {
            this.type = DEFAULT_TYPE;
            return;
        }
        String t = type.trim();
        if(t.equalsIgnoreCase("Diamond") ||
            t.equalsIgnoreCase("Step-Through") ||
            t.equalsIgnoreCase("Truss") ||
            t.equalsIgnoreCase("Penny-Farthing")) {
            this.type = t;
        } else {
            this.type = DEFAULT_TYPE;
        }
    }
    //Should check if two frames are the same
    public boolean equals(Frame other) {
        if(other == null) return false;
        return this.size == other.size && this.type.equals(other.type);
    }
    //Should string form of a frame
    public String toString() {
        return "[Frame] Size: " + size + " Type: " + type;
    }
}