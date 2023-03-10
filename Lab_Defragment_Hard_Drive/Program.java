import java.util.ArrayList;

public class Program {

    private char programCharID; // ID identifier for a program
    private ArrayList<Integer> sectors = new ArrayList<>(); // List of sectors the program holds in memory

    public Program(char programName) {
        this.programCharID = programName;
    }

    /*
     * Returns the ID identifier for the program
     */
    public char getProgramCharID() {
        return this.programCharID;
    }

    /*
     * Returns a list of all sectors the program holds
     */
    public ArrayList<Integer> getSectors() {
        return this.sectors;
    }

    /*
     * Returns the first sector the program holds
     */
    public Integer getFirstSector() {
        return this.sectors.get(0);
    }

    /*
     * Adds a sector the the sector list
     */
    public void addSector(int sectorIndex) {
        this.sectors.add(Integer.valueOf(sectorIndex));
    }

    /*
     * Removes a sector from the sector list
     */
    public void removeSector(int sectorIndex) {
        this.sectors.remove(Integer.valueOf(sectorIndex));
    }

    public String toString() {
        return this.sectors.toString();
    }
}
