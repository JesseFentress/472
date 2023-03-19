import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main
{

    static Map<Character, Program> programs = new HashMap<Character, Program>();
    static ArrayList<Integer> emptyMem = new ArrayList<>();
    static char EMPTY_SECTOR = ' ';

    public static void findAllPrograms(Harddrive hdd)
    {

        for (int i = 0; i < hdd.getHarddriveSize(); i++)
        {

            if (hdd.isEmptySector(i))
            {
                emptyMem.add(i);
            }
            else
            {
                char currentChar = hdd.getProgramAtSector(i);
                if (programs.containsKey(currentChar))
                {
                    programs.get(currentChar).addSector(i);
                    ;
                }
                else
                {
                    Program newProgram = new Program(currentChar);
                    newProgram.addSector(i);
                    programs.put(currentChar, newProgram);
                }
            }
        }
    }

    public static void alterEmptyTable(int index1, int index2)
    {
        emptyMem.remove(Integer.valueOf(index1));
        emptyMem.add(Integer.valueOf(index2));
    }

    public static void alterProgramsTable(char programCharID, int index1, int index2)
    {
        programs.get(programCharID).removeSector(Integer.valueOf(index1));
        programs.get(programCharID).addSector(Integer.valueOf(index2));
    }

    public static void printGreetingMessage()
    {
        System.out.println("*********************************************************");
        System.out.println("*** WELCOME TO THE HARDDRIVE DEFRAGMENTATION PROGRAM. ***");
        System.out.println("*********************************************************");
        System.out.println("*** This program defragments a virtual harddrive that ***");
        System.out.println("*** holds of 13 fragmented programs. Upper-case ASCII ***");
        System.out.println("*** characters are used to represent the programs.    ***");
        System.out.println("*********************************************************");
    }

    public static void main(String[] args)
    {

        printGreetingMessage(); // Greeting message about the program

        Harddrive hdd = new Harddrive(); // Initialize the fragmented harddrive

        System.out.println("\n****************** Fragmented Harddrive *****************");

        hdd.printHarddrive(); // Display the fragmented harddrive

        findAllPrograms(hdd); // Identify where each program is stored

        int sectorIndex = 0;

        // Iterate over the programs found in the harddrive
        for (Map.Entry<Character, Program> programEntry : programs.entrySet())
        {

            // Iterate for every sector the program is found
            for (Integer sector : programEntry.getValue().getSectors())
            {

                // Character id of the program that is at our current sector
                char programCharID = hdd.getProgramAtSector(sectorIndex);

                // If the program entry we are at is not the same as the program we found
                if (programCharID != programEntry.getValue().getProgramCharID())
                {

                    if (programCharID == EMPTY_SECTOR)
                    { // Sector is empty

                        // Swap the empty sector with the sector of the program
                        hdd.swap(sector, sectorIndex);

                        // Alter the empty table to represent the swap
                        alterEmptyTable(sectorIndex, sector);

                    } else { // The sector belongs to another program

                        // Sort the empty memory so we have the first empty at the front
                        Collections.sort(emptyMem);

                        // Get the first available empty sector
                        int firstAvailableSector = emptyMem.get(0);

                        // Swap the program in the current sector with first empty sector
                        hdd.swap(sectorIndex, firstAvailableSector);

                        // Alter the tables to represent the swap
                        alterProgramsTable(programCharID, sectorIndex, firstAvailableSector);
                        alterEmptyTable(firstAvailableSector, sectorIndex);

                        // Swap the program that belongs in the current sector with the newly empty
                        // sector
                        hdd.swap(sector, sectorIndex);

                        // Alter the empty table to represent the swap
                        alterEmptyTable(sectorIndex, sector);

                    }
                }
                sectorIndex++; // Increment the sector index
            }

        }

        System.out.println("\n***************** Defragmented Harddrive ****************");

        hdd.printHarddrive(); // Display defragmented harddrive
    }
}
