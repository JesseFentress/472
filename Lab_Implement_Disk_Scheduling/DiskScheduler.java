package Lab_Implement_Disk_Scheduling;

public interface DiskScheduler {

    /*
     * Invokes a scheduling algorithm
     */
    public void handleScheduling(int[] requestList, int start);

    /*
     * Return the distance from one head position to the next
     */
    public static int moveHead(int start, int end) {
        return Math.abs(end - start);
    }

    /*
     * Print the number movements the head has made
     */
    public static void printHeadMovement(int count) {
        System.out.println(count);
    };
}
