import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static char harddrive[] = { 'A', 'B', 'B', ' ', 'D', ' ', 'X', 'X', ' ', 'E', 'F', 'G', ' ', 'H', 'H', 'J', 'J',
            ' ',
            ' ', ' ', 'J', 'K', 'K', 'J', 'L', 'L', 'L', ' ', 'M', 'M', 'P', 'P', 'M', 'P', 'P', ' ', ' ', 'R', ' ',
            ' ' };

    static char CLEAR_SECTOR = ' ';

    static Map<Character, ArrayList<Integer>> programs = new HashMap<Character, ArrayList<Integer>>();
    static ArrayList<Integer> emptyMem = new ArrayList<>();
    static Map<Integer, Character> locations = new HashMap<Integer, Character>();

    public static void checkContinuos() {

    }

    public static void swap(Integer usedMemLocation, Integer emptyMemLocation) {

        char currentChar = harddrive[usedMemLocation];

        harddrive[emptyMemLocation] = harddrive[usedMemLocation];
        harddrive[usedMemLocation] = CLEAR_SECTOR;

        programs.get(currentChar).remove(usedMemLocation);
        programs.get(currentChar).add(emptyMemLocation);

        emptyMem.remove(emptyMemLocation);
        emptyMem.add(usedMemLocation);

    }

    public static int getFirstAvailableSector() {
        return emptyMem.get(0);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < harddrive.length; i++) {

            char currentChar = harddrive[i];
            locations.put(i, currentChar);
            if (currentChar == CLEAR_SECTOR) {
                emptyMem.add(i);
            } else {
                if (programs.containsKey(currentChar)) {
                    programs.get(currentChar).add(i);
                } else {
                    ArrayList<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(i);
                    programs.put(currentChar, tempList);
                }
            }
        }

        System.out.println(emptyMem);
        int index = 0;
        int endPoint = 0;

        for (Map.Entry<Character, ArrayList<Integer>> program : programs.entrySet()) {

            index = program.getValue().get(0);

            if (index != 0 && index > endPoint + 1) {
                System.out.println(programs);
                swap(endPoint, getFirstAvailableSector());
                System.out.println(programs);
            }

            int i = index;

            for (int j = 0; j < program.getValue().size(); j++) {

                int nextSectorOccupied = program.getValue().get(j);
                System.out.println(nextSectorOccupied);
                System.out.println(index + " " + i);
                if (nextSectorOccupied > i) {
                    System.out.println(program.getKey());
                    int emptySector = getFirstAvailableSector();
                    swap(i + 1, emptySector);
                    swap(nextSectorOccupied, i + 1);
                }
                i++;
            }
            endPoint = i;
        }

        System.out.println(harddrive);
        // swap(4, 3);
        System.out.println(harddrive);
        // System.out.println(programs);
    }
}