//(10/30/2025)
/*
 * Brody Thomas
 */
//I had help from a tutor

public class Bicycle {
    public static final String DEFAULT_MAKE = "none";

    private String make;
    private Wheel frontWheel;
    private Wheel backWheel;
    private Frame frame;

    //Default constructor
    public Bicycle() {
        make = DEFAULT_MAKE;
        frontWheel = new Wheel();
        backWheel = new Wheel();
        frame = new Frame();
    }
    //Parameterized constructor
    public Bicycle(String make, Wheel frontWheel, Wheel backWheel, Frame frame) {
        setMake(make);
        setFrontWheel(frontWheel);
        setBackWheel(backWheel);
        setFrame(frame);
    }
    //Should get make
    public String getMake() {
        return make;
    }
    //Should set make
    public void setMake(String make) {
        if(make != null)
            this.make = make;
        else
            this.make = DEFAULT_MAKE;
    }
    //Should get front wheel
    public Wheel getFrontWheel() {
        return frontWheel;
    }
    //Should set front wheel
    public void setFrontWheel(Wheel frontWheel) {
        if(frontWheel != null)
            this.frontWheel = frontWheel;
        else
            this.frontWheel = new Wheel();
    }
    //Should get back wheel
    public Wheel getBackWheel() {
        return backWheel;
    }
    //Should set back wheel
    public void setBackWheel(Wheel backWheel) {
        if(backWheel != null)
            this.backWheel = backWheel;
        else
            this.backWheel = new Wheel();
    }
    //Should get frame
    public Frame getFrame() {
        return frame;
    }
    //Should set frame
    public void setFrame(Frame frame) {
        if(frame != null)
            this.frame = frame;
        else
            this.frame = new Frame();
    }
    //Should check if two bicycles are the same
    public boolean equals(Bicycle other) {
        if(other == null) return false;

        boolean sameMake = this.make.equalsIgnoreCase(other.make);
        boolean sameFront = this.frontWheel.equals(other.frontWheel);
        boolean sameBack = this.backWheel.equals(other.backWheel);
        boolean sameFrame = this.frame.equals(other.frame);

        return sameMake && sameFront && sameBack && sameFrame;
    }
    //Should string form of a bicycle
    public String toString() {
        return "[Bicycle] Make: " + make +
               " Front Wheel: " + frontWheel +
               " Back Wheel: " + backWheel +
               " Frame: " + frame;
    }
}