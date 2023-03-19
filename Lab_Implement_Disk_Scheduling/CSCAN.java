package Lab_Implement_Disk_Scheduling;

import java.util.Arrays;

public class CSCAN implements DiskScheduler {

    @Override
    public void handleScheduling(int[] requestList, int start) {
        int count = 0; // Head movements
        int previous = start; // Start position of a movement

        int[] requestListCopy = Arrays.copyOf(requestList, requestList.length); // Copy the array
        Arrays.sort(requestListCopy); // Sort the requests by cylinder value

        int pass = 1; // Pass number

        /*
         * In a real word scenario this would constantly loop, but since we have a
         * static list we are simply
         * going to do two passes. One from start to the end and then back to the front
         * and through to the end.
         */
        while (pass < 3) {
            if (pass == 2) { // We have returned to the beginning for a second pass
                previous = 0; // Start at the beginning of the list
                count += 4999; // Increment the count by 4999 because the head moved from the end to the front
            }

            for (int i = 0; i < requestListCopy.length; i++) { // Iterate for every request
                if (requestListCopy[i] >= previous) { // If the request is in the proper direction
                    count += DiskScheduler.moveHead(previous, requestListCopy[i]); // Increment the count value
                    previous = requestListCopy[i]; // Current position becomes the previous position
                    requestListCopy[i] = -1; // Mark this request as finished
                }
            }

            count += DiskScheduler.moveHead(previous, 4999); // Increment count by previous to the end
            pass++; // Increment pass
        }

        DiskScheduler.printHeadMovement(count); // Print the total head movements
    }
}
