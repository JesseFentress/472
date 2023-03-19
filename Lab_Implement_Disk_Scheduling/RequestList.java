package Lab_Implement_Disk_Scheduling;

import java.util.Random;

public class RequestList {

    private static Random random = new Random(); // Used for random int generation
    private static RequestList INSTANCE = new RequestList(); // Singleton Instance
    private final int NUMBER_OF_REQUESTS = 10000; // Total number of requests
    private final int NUMBER_OF_CYLINDERS = 5000; // Total number of cylinders
    private final int START_POINT = random.nextInt(NUMBER_OF_CYLINDERS - 1); // Starting cylinder
    private int requests[] = new int[NUMBER_OF_CYLINDERS]; // Cylinder requests

    private RequestList() {
        requests = generateRequests(); // Generate random requests
    }

    /*
     * Generates an array of random ints that represent cylinder requests
     */
    private int[] generateRequests() {

        int[] requests = new int[NUMBER_OF_REQUESTS]; // Array for requests
        for (int i = 0; i < NUMBER_OF_REQUESTS; i++) { // Iterate for each position in the array
            requests[i] = random.nextInt(NUMBER_OF_CYLINDERS - 1); // Generate a random int (0 - 4999)
        }
        return requests;
    }

    public int[] getRequests() {
        return requests;
    }

    public int getStartPoint() {
        return START_POINT;
    }

    public int getNumberOfCylinders() {
        return NUMBER_OF_CYLINDERS;
    }

    /*
     * Get the singleton instance
     */
    public static RequestList getInstance() {
        return INSTANCE;
    }
}
