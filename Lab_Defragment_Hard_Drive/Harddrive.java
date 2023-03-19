public class Harddrive
{
    static char sectors[] =
    {
      'A', 'B', 'B', ' ', 'D', ' ', 'X', 'X', ' ', 'E', 'F', 'G', ' ', 'H', 'H', 'J', 'J',
      ' ', ' ', ' ', 'J', 'K', 'K', 'J', 'L', 'L', 'L', ' ', 'M', 'M', 'P', 'P', 'M', 'P',
      'P', ' ', ' ', 'R', ' ', ' '
    };

    static final char CLEAR_SECTOR = ' '; // Empty sector

    /*
     * Swaps a used sector with an empty sector.
     */
    public void swap(Integer usedMemLocation, Integer emptyMemLocation)
    {

        char currentChar = sectors[usedMemLocation];

        sectors[emptyMemLocation] = sectors[usedMemLocation];
        sectors[usedMemLocation] = CLEAR_SECTOR;

    }

    /*
     * Returns the program identifier at a given sector
     */
    public char getProgramAtSector(int sectorIndex)
    {
        return sectors[sectorIndex];
    }

    /*
     * Returns the number of sectors in the harddrive
     */
    public int getHarddriveSize()
    {
        return sectors.length;
    }

    /*
     * Returns whether or not a sector is empty
     */
    public boolean isEmptySector(int sectorIndex)
    {
        return sectors[sectorIndex] == CLEAR_SECTOR;
    }

    /*
     * Displays the harddrive sectors and their contents
     */
    public void printHarddrive()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println(String.format("Sector %d [%c] | Sector %d [%c] | Sector %d [%c] | Sector %d [%c]", i,
                    sectors[i], i + 10, sectors[i + 10], i + 20, sectors[i + 20], i + 30, sectors[i + 30]));
        }
    }
}
