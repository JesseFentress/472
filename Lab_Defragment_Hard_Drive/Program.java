import java.util.ArrayList;

public class Program {

    private char programCharID;
    private ArrayList<Integer> sectors = new ArrayList<>();

    public Program(char programName) {
        this.programCharID = programName;
    }

    public char getProgramCharID() {
        return this.programCharID;
    }

    public ArrayList<Integer> getSectors() {
        return this.sectors;
    }

    public Integer getFirstSector() {
        return this.sectors.get(0);
    }

    public void addSector(int sectorIndex) {
        this.sectors.add(Integer.valueOf(sectorIndex));
    }

    public void removeSector(int sectorIndex) {
        this.sectors.remove(Integer.valueOf(sectorIndex));
    }

    public String toString() {
        return this.sectors.toString();
    }
}
