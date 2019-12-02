/*
 * Project 2: KeeJoh O'Hearon, Michael Mckee
 * Create a program for CPU scheduling algorithms:
 FCFS Scheduling algorithm
 SJF Scheduling algorithm
 Non-preemptive Priority Scheduling algorithm 
 RR Scheduling algorithm

Input: two-dimensional array (Process ID, Burst time, Priority) 
Output: display the turnaround time for all processes.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SchedulingAlgorithms {

    /* Main Method*/
    public static void main(String[] args) {

        // Create a Scanner object
        Scanner newScanner = new Scanner(System.in);


        // Initialize Variables
        boolean moreProcesses = true;
        int processCount = 0;
        int processTurnTime = 0;


        ArrayList<myProcesses> allTheProcesses = new ArrayList<myProcesses>(); //create process container
        ArrayList<myProcesses> allTheProcessesTemp = new ArrayList<myProcesses>();//create temporary process container

        // Welcome Message & User Input Prompt
        System.out.println(
                "Welcome. This program will have you enter a Process ID, Process Burst Time, and Process Priority. \n"
                        + "You will then choose which process scheduling algorithm to run. \n"
                        + "For Round Robin the time quantum is set as 4. The results of each algorithm and their corresponding information will be displayed \n"
                        + "for your enjoyment.Thank you for using McKee and O'Hearon Future Industries! \n");

        System.out.println("Please enter the number of processes you would like to schedule as a positive integer:");
        int numberOfProcess = newScanner.nextInt();//takes user input


        try {
            while (moreProcesses == true) {
                System.out.println("Please enter a process id as a positive integer");
                int processID = newScanner.nextInt();//takes user input

                System.out.println("Please enter a process burst time as a positive integer");
                int processBurst = newScanner.nextInt();//takes user input

                System.out.println(
                        "Please enter a process priority as a positive integer (A lower number is given higher priority)");
                int processPriority = newScanner.nextInt();//takes user input

                allTheProcesses.add(new myProcesses(processID, processBurst, processPriority, processTurnTime));
                allTheProcessesTemp.add(new myProcesses(processID, processBurst, processPriority, processTurnTime));
                processCount++;

                if (processCount == numberOfProcess) {
                    moreProcesses = false;
                    break;
                }

                System.out.println("Are you done entering new processes? Yes or No?");
                String enterMore = newScanner.next();//takes user input

                if ((!enterMore.toLowerCase().equals("y") && !enterMore.toLowerCase().equals("yes"))
                        && (!enterMore.toLowerCase().equals("n") && !enterMore.toLowerCase().equals("no"))) {
                    System.out.println(
                            "The input you have provided does not correspond to a valid input please run the program again.");
                    System.exit(1);
                }
                if (enterMore.toLowerCase().equals("y") || enterMore.toLowerCase().equals("yes")) {
                    moreProcesses = false;

                }

            }
        } catch (Exception e) {
            System.out.println("One or more of your entries was incorrect please run the program again.");
            System.exit(1);
        }
        System.out.println("Which scheduling algorithm would you like to run? \n "
                + "(For schedulers that run based off burst(SJF) or priority those with same values will run based off time of entry. \n"
                + "time of entry is not arrival time arrival time is 0 for all processes.) \n " + "Enter 1 for First "
                + "Come First Serve 2 for Shortest Job First 3 for non-preemptive Priority or 4 for Round Robin ");
        int algorithmSelection = newScanner.nextInt();

        // Case Selection for algorithm selection via user input
        switch (algorithmSelection) {
            case 1:
                /* First Come First Serve */
                FCFSScheduling runFCFSScheduling = new FCFSScheduling(allTheProcesses);
                runFCFSScheduling.turnAroundTime();
                runFCFSScheduling.printProcesses();
                break;
            case 2:
                /* Shortest Job First */
                Collections.sort(allTheProcesses, myProcesses.processBurstCompare);
                SJFScheduling runSJFScheduling = new SJFScheduling(allTheProcesses);
                runSJFScheduling.turnAroundTime();
                runSJFScheduling.printOrderByBurst();
                break;
            case 3:
                /* Non Preemptive Priority Scheduling */
                Collections.sort(allTheProcesses, myProcesses.processPriorityCompare);
                PriorityScheduling runPriorityScheduling = new PriorityScheduling(allTheProcesses);
                runPriorityScheduling.turnAroundTime();
                runPriorityScheduling.printOrderByPriority();
                break;
            case 4:
                /* Round Robin */
                myProcesses findMaxBurst = Collections.max(allTheProcesses, myProcesses.processBurstCompare);
                int maxBurst = findMaxBurst.getBurst();
                RRScheduling runRRScheduling = new RRScheduling(allTheProcesses, allTheProcessesTemp);
                runRRScheduling.turnAroundTime(maxBurst);
                runRRScheduling.printProcesses();
                break;
            default:
                /* Exits on Incorrect User Input */
                System.out.println("That is not a correct entry please re-run the program.");
                System.exit(1);
                break;
        }
    }

}