import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Main {
    public static void main(String[] args) {

        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("photonVision");
        NetworkTableEntry poseEntry = table.getEntry("targetPose");
        inst.startClientTeam(4201);  // where TEAM=190, 294, etc, or use inst.startClient("hostname") or similar

        double[] defaultValue = new double[0];

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
                return;
            }
            double x = poseEntry.getDoubleArray(defaultValue)[0];
            double y = poseEntry.getDoubleArray(defaultValue)[1];
            System.out.println("X: " + x + " Y: " + y);
        }
    }
}