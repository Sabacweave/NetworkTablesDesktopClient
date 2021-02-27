import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPipelineResult;
import org.photonvision.PhotonTrackedTarget;
import edu.wpi.first.Transform2d;

public class Main {
    public static void main(String[] args) {

        PhotonCamera camera = new PhotonCamera("photonvision");
        PhotonPipelineResult result = camera.getLatestResult();
        PhotonTrackedTarget target;
        Transform2d pose;

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
                return;
            }
            target = result.getBestTarget();
            pose = target.getCameraToTarget();
            double x = pose.getTranslation().getX();
            double y = pose.getTranslation().getY();
            System.out.println("X: " + x + " Y: " + y);
        }
    }
}