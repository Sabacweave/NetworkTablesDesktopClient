
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Main {
    public static void main(String[] args) {

        // NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTableInstance inst = NetworkTableInstance.create();
        NetworkTable table = inst.getTable("photonvision");
        NetworkTableEntry poseEntry = table.getEntry("targetPose");
        inst.startClient("localhost",1735);
        // inst.startClientTeam(4201);  // where TEAM=190, 294, etc, or use inst.startClient("hostname") or similar

        double[] defaultValue = {8,8};
        
        System.out.println(inst.getNetworkMode());

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
                return;
            }
            double x = (poseEntry.getDoubleArray(defaultValue))[0];
            double y = (poseEntry.getDoubleArray(defaultValue))[1];
            System.out.println("X: " + x + " Y: " + y);
        }
    }
}