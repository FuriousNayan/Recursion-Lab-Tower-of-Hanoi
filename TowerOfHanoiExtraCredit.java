import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
public class TowerOfHanoiExtraCredit {
    public static Scanner input = new Scanner(System.in);
    public static String getInput(String prompt) {
            System.out.print(prompt);
            return input.nextLine();
        }
        public static int getIntInput(String prompt) {
            System.out.print(prompt);
            return input.nextInt();
        }

        public static char getChar(String prompt) {
            System.out.print(prompt);
            return input.next().charAt(0);
        }
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
    
    //Manual Mode for extra credit
    public static void moveSingularDisk(int n){
        if(pegC.size() == n){
            System.out.println("You Won!");
            return;
        }
        char discToMove = getChar("Please specify the peg with the top disc you intend to move: ");
        char pegToMoveTo = getChar("Please specify the peg you intend to move to: ");

        moveCount++;
        ArrayList<Integer> sourcePeg = getPeg(discToMove);
        ArrayList<Integer> destPeg = getPeg(pegToMoveTo);
        
        int diskToMove = sourcePeg.get(sourcePeg.size() - 1);

        if (!destPeg.isEmpty()) {
            int topDestDisk = destPeg.get(destPeg.size() - 1);
        
        // Validation for Extra Credit
        if (diskToMove > topDestDisk) {
            System.out.println("Please put on a valid peg");
            moveSingularDisk(n);
            return;
        }
        
    }

        sourcePeg.remove(sourcePeg.size() - 1);
        destPeg.add(diskToMove);
        System.out.println("Moved disk " + diskToMove + " from " + sourcePeg + " to " + destPeg);
        displayTowers(n);
        moveSingularDisk(n);
        
    }
    public static ArrayList<Integer> getPeg(char pegName) {
        if (pegName == 'A' || pegName == 'a') return pegA;
        if (pegName == 'B' || pegName == 'b') return pegB;
        if (pegName == 'C' || pegName == 'c') return pegC;
        return null;
    }



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

    }

    public static void displayTowers(int n) {
        // // TODO: Implement tower visualization
        // // System.out.println("--- Tower State ---");
        // System.out.println("----------------------------------------------------");
        // System.out.printf("Peg A:     Peg B:     Peg C:      " + "\n");
        // System.out.println("----------------------------------------------------");
        // for(int i = 0; i <= pegA.size(); i++){
        //     System.out.printf("  |          |          |%n");
        // }
        // System.out.println();
        System.out.println("A: " + pegA);
        System.out.println("B: " + pegB);
        System.out.println("C: " + pegC);

        int paddingSize = 10;
        int largestPegADisk = (1 + 2 * (pegA.get(0)));
        int totalSpacesToFill = (1 + 2 * (pegA.get(0)) + paddingSize);
        
        String space = " ";
        String equalSign = "=";
        int spaceCounter = n;
        int equalsCounter = 3;
 
        // System.out.print("Peg B:");
        // System.out.println("Peg C:");


        System.out.print("Peg A:");
        System.out.print(space.repeat(largestPegADisk + 1));
        System.out.print("Peg B:");
        System.out.print(space.repeat(largestPegADisk + 1));
        System.out.print("Peg C:");
        System.out.println(space.repeat(largestPegADisk + 1));

        // First Line of All Pegs Done
        System.out.print(space.repeat(spaceCounter));
        System.out.print("|            |             |");
        System.out.println(space.repeat(spaceCounter));

        // Starting for all pegs done
        for(int i = 1; i <= n; i++){
            System.out.print(space.repeat(spaceCounter - i)); 
            System.out.print(equalSign.repeat(equalsCounter));
            System.out.print(space.repeat(11 - i)); 
            System.out.print(" |             |");
            System.out.println();
            equalsCounter += 2;
        }
        

    }

    // Starting Peg C
    
    
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
        int n = getIntInput("Welcome to Tower of Hanoi! Please input how many pegs you would like to play with: ");
        System.out.println("Tower of Hanoi - " + n + " disks");
        initializetowers(n);

        displayTowers(n);
        moveSingularDisk(n);
        printStatistics(n);
        
    }
}