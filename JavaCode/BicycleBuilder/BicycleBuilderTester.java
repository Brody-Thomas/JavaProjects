//(10/31/2025)
/*
 * Brody Thomas
 */
//I had help from a tutor
//This thing should run the entire program

public class BicycleBuilderTester {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("Welcome to the Bicycle Builder Tester!");
        System.out.println("---------------------------------");

        System.out.println("\nFirst we will create a \"Default\" Bicycle");
        Bicycle b1 = new Bicycle();

        System.out.println("\nPrinting the Bicycle's data");
        System.out.println("Bicycle's make: " + b1.getMake());
        System.out.println("Bicycle's front wheel: Diameter " + b1.getFrontWheel().getDiameter()
                + " Width: " + b1.getFrontWheel().getWidth());
        System.out.println("Bicycle's back wheel: Diameter " + b1.getBackWheel().getDiameter()
                + " Width: " + b1.getBackWheel().getWidth());
        System.out.println("Bicycle's frame: Size: " + b1.getFrame().getSize()
                + " Type: " + b1.getFrame().getType().toLowerCase());

        System.out.println("\nTesting the toString method");
        System.out.println(b1.toString());

        System.out.println("\nSetting invalid values for the default bike's wheels and frame");
        b1.getFrontWheel().setDiameter(100);
        b1.getFrontWheel().setWidth(0);
        b1.getBackWheel().setDiameter(10);
        b1.getBackWheel().setWidth(5);
        b1.getFrame().setSize(10);
        b1.getFrame().setType("wrong");

        System.out.println(b1.toString());

        System.out.println("\nCreating another bike using the parameterized constructor");
        Wheel fw = new Wheel(55.0, 2.5);
        Wheel bw = new Wheel(18.0, 2.0);
        Frame f = new Frame(60.0, "Penny-Farthing");
        Bicycle b2 = new Bicycle("Big Wheel", fw, bw, f);
        System.out.println(b2.toString());

        System.out.println("\nCreating another bike using the parameterized constructor with invalid values");
        Wheel bad1 = new Wheel(1000, -1);
        Wheel bad2 = new Wheel(-5, 10);
        Frame badFrame = new Frame(0, "invalid");
        Bicycle b3 = new Bicycle(null, bad1, bad2, badFrame);
        System.out.println(b3.toString());

        System.out.println("\nChecking the \"equals\" method");
        System.out.println("Different memory addresses? " + (b1 != b3));
        System.out.println("Same properties? " + b1.equals(b3));

        System.out.println("\n---------------------------------");
        System.out.println("Tests Complete! Goodbye");
        System.out.println("---------------------------------");
    }
}