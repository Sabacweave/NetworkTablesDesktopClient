
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Main {
    public static void main(String[] args) {

        // NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTableInstance inst = NetworkTableInstance.create();
        inst.startClient("localhost",1735);
        NetworkTable table = inst.getTable("photonvision/Integrated_Webcam");
        NetworkTableEntry xEntry = table.getEntry("targetPixelsX");
        NetworkTableEntry yEntry = table.getEntry("targetPixelsY");
        // inst.startClientTeam(4201);  // where TEAM=190, 294, etc, or use inst.startClient("hostname") or similar

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
                return;
            }
            double x = (xEntry.getDouble(0));
            double y = (yEntry.getDouble(0));
            System.out.println("X: " + x + " Y: " + y);
        }
    }
}