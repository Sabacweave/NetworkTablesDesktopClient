import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Main {
    public static void main(String[] args) {

        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("photonVision");
        NetworkTableEntry xEntry = table.getEntry("x");
        NetworkTableEntry yEntry = table.getEntry("y");
        inst.startClientTeam(4201);  // where TEAM=190, 294, etc, or use inst.startClient("hostname") or similar

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
                return;
            }
            double x = xEntry.getDouble(0.0);
            double y = yEntry.getDouble(0.0);
            System.out.println("X: " + x + " Y: " + y);
        }
    }
}