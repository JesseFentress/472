package Lab_Implement_Disk_Scheduling;

public class Main {
    public static void main(String[] args) {

        // List of disk access requests to be used by all algorithms
        RequestList requestList = RequestList.getInstance();

        // First-Come First-Served Algorithm
        System.out.println("FSCF Algorithm:");
        FCFS fcfs = new FCFS();
        fcfs.handleScheduling(requestList.getRequests(), requestList.getStartPoint());
        System.out.println();

        // SCAN Algorithm
        System.out.println("SCAN Algorithm:");
        SCAN scan = new SCAN();
        scan.handleScheduling(requestList.getRequests(), requestList.getStartPoint());
        System.out.println();

        // C-SCAN Algorithm
        System.out.println("C-SCAN Algorithm:");
        CSCAN cscan = new CSCAN();
        cscan.handleScheduling(requestList.getRequests(), requestList.getStartPoint());
        System.out.println();
    }
}
