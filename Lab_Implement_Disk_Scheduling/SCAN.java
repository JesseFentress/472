package Lab_Implement_Disk_Scheduling;

import java.util.Arrays;

public class SCAN implements DiskScheduler {

    @Override
    public void handleScheduling(int[] requestList, int start) {
        int count = 0; // Head movements
        int previous = start; // Start position of a movement

        int[] requestListCopy = Arrays.copyOf(requestList, requestList.length); // Copy the array
        Arrays.sort(requestListCopy); // Sort the requests by cylinder value

        for (int i = 0; i < requestListCopy.length; i++) { // Go to the right
            if (requestListCopy[i] >= previous) { // We are going to forward
                count += DiskScheduler.moveHead(previous, requestListCopy[i]); // Increment the count value
                previous = requestListCopy[i]; // Current position becomes the previous position
                requestListCopy[i] = -1; // Mark this request as finished
            }
        }

        count += DiskScheduler.moveHead(previous, 4999); // Increment count by previous to the end
        previous = 4999; // Previous is the

        for (int i = 0; i < requestListCopy.length; i++) { // Go back to the left
            if (requestListCopy[i] <= previous && requestListCopy[i] != -1) { // We are going back so check if this
                                                                              // request is valid for this direction
                count += DiskScheduler.moveHead(previous, requestListCopy[i]); // Increment the count value
            }
            previous = requestListCopy[i]; // Current position becomes the previous position
        }

        count += DiskScheduler.moveHead(0, previous); // Increment the count from previous to the beginning

        DiskScheduler.printHeadMovement(count); // Print the total head movements
    }
}
