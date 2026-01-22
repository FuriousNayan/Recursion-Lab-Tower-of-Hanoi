import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tower of Hanoi Lab
 * 
 * The Tower of Hanoi is a classic problem that demonstrates recursion.
 * 
 * Rules:
 * - You have 3 pegs (A, B, C) and n disks of different sizes
 * - All disks start on peg A, sorted by size (largest at bottom)
 * - Goal: Move all disks from peg A to peg C
 * - Only one disk can be moved at a time
 * - A larger disk can never be placed on top of a smaller disk
 * 
 * Recursive solution:
 * To move n disks from source to destination using auxiliary peg:
 *   1. Move n-1 disks from source to auxiliary (using destination as helper)
 *   2. Move the largest disk from source to destination
 *   3. Move n-1 disks from auxiliary to destination (using source as helper)
 * 
 * @author Nayan Patel
 */
public class TowerOfHanoiCopy {
    public static ArrayList<Integer> pegA;
    public static ArrayList<Integer> pegB;
    public static ArrayList<Integer> pegC;
    
    
    // Part 3: Move counter (you'll add this)
    private static int moveCount = 0;
    
    /**
     * PART 1: Implement the classic Tower of Hanoi solver
     * 
     * TODO: Implement this recursive method
     * 
     * Base case: if n == 1, move disk from source to destination
     * Recursive case:
     *   1. Move n-1 disks from source to auxiliary (using destination)
     *   2. Move disk n from source to destination
     *   3. Move n-1 disks from auxiliary to destination (using source)
     * 
     * @param n number of disks to move
     * @param source the source peg (e.g., 'A')
     * @param destination the destination peg (e.g., 'C')
     * @param auxiliary the auxiliary peg (e.g., 'B')
     */
    public static void moveDisks(int n, char source, char destination, char auxiliary) {
        if(n == 1){
            moveSingularDisk(source, destination);
            return;
        }
        
        moveDisks(n - 1, source, auxiliary,  destination);

        moveSingularDisk(source, destination);
        
        moveDisks(n - 1, auxiliary, destination, source);

    }
    public static void moveSingularDisk(char source, char destination){
        moveCount++;

        ArrayList<Integer> sourcePeg = getPeg(source);
        ArrayList<Integer> destPeg = getPeg(destination);
        
        if(sourcePeg.isEmpty()) {
            return;
        }

        int disk = sourcePeg.remove(sourcePeg.size() - 1);
        destPeg.add(disk);

        System.out.println("Move disk " + disk + " from " + source + " to " + destination);
        displayTowers();

    }
    public static ArrayList<Integer> getPeg(char pegName) {
        if (pegName == 'A') return pegA;
        if (pegName == 'B') return pegB;
        if (pegName == 'C') return pegC;
        return null;
    }

// update towers
// getpeg
// initializetowers

    /**
     * PART 2: Add visualization
     * 
     * Modify this method to display the state of the towers after each move.
     * 
     * You can represent the towers however you like. Example:
     * A: [3, 2, 1]
     * B: []
     * C: []
     * 
     * Or get creative with ASCII art!
     * 
     * Hint: You'll need to track which disks are on which peg.
     * Consider using ArrayList<Integer> for each peg.
     */


    public static void initializetowers(int n){
        pegA = new ArrayList<>(Arrays.asList()); 
        pegB = new ArrayList<>();
        pegC = new ArrayList<>();
        for(int i = n; i >= 1; i--){
            pegA.add(i);
        }

        System.out.println(pegA);
    }


    public static void displayTowers() {
        // TODO: Implement tower visualization
        System.out.println("--- Tower State ---");
        System.out.println("A: " + pegA);
        System.out.println("B: " + pegB);
        System.out.println("C: " + pegC);
        
    }
    
    /**
     * PART 3: Add move counting and validation
     * 
     * Enhance your solution to:
     * 1. Count total moves
     * 2. Verify the solution uses the minimum number of moves (2^n - 1)
     * 3. Optional: Add validation to ensure no illegal moves
     */
    public static void printStatistics(int n) {
        // TODO: Print statistics
        System.out.println("\n=== Statistics ===");
        System.out.println("Number of disks: " + n);
        System.out.println("Total moves: " + moveCount);
        System.out.println("Minimum possible moves: " + ((int)Math.pow(2, n) - 1));
        
        // Verify correctness
        if (moveCount == (int)Math.pow(2, n) - 1) {
            System.out.println("SUCCESS! Optimal solution.");
        } else {
            System.out.println("WARNING: Not optimal.");
        }
    }
    
    public static void main(String[] args) {
        int n = 3; // Start with 3 disks
        initializetowers(n);

        
        System.out.println("Tower of Hanoi - " + n + " disks");
        System.out.println("Moving disks from A to C using B\n");
        
        // Reset move counter
        moveCount = 0;
        
        // Solve the puzzle
        moveDisks(n, 'A', 'C', 'B');
        
        // Display statistics
        printStatistics(n);
        
        // Test with different numbers of disks
        System.out.println("\n\n=== Try with 4 disks ===");
        initializetowers(4);
        moveCount = 0;
        moveDisks(4, 'A', 'C', 'B');
        printStatistics(4);
    }
}