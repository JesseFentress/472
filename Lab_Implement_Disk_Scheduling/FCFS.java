package Lab_Implement_Disk_Scheduling;

public class FCFS implements DiskScheduler {

    /*
     * Uses the First-Come Firs-Served scheduling algorithm
     */
    @Override
    public void handleScheduling(int[] requestList, int start) {

        int count = 0; // Head movements
        int previous = start; // Start position of a movement

        //
        for (int i = 0; i < requestList.length; i++) {
            count += DiskScheduler.moveHead(previous, requestList[i]); // Increment the count value
            previous = requestList[i]; // Current position becomes the previous position
        }
        DiskScheduler.printHeadMovement(count); // Print the total head movements
    }
}