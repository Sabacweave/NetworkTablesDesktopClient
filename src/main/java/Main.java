// Need to import photonlib and pose2d here?

public class Main {
    public static void main(String[] args) {

        PhotonCamera camera = new PhotonCamera("MyCamera");
        PhotonTrackedTarget target;
        Transform2d pose;

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
                return;
            }
            target = result.getBestTarge()
            pose = target.getCameraToTarget();
            double x = pose.getTranslation().getX();
            double y = pose.getTranslation().getY();
            System.out.println("X: " + x + " Y: " + y);
        }
    }
}