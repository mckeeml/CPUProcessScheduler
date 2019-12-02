import java.util.Comparator;

public class myProcesses {
	
	// Declare and initialize variables
	protected int processTurnTime;
	protected int processID;
	protected int processBurstTime;
	protected int processPriority;

	// Default Constructor
	public myProcesses() {
	}

	// Parameterized Constructor for myProcesses
	public myProcesses(int processID, int processBurstTime, int processPriority, int processTurnTime) {
		this.processID = processID;
		this.processBurstTime = processBurstTime;
		this.processPriority = processPriority;
		this.processTurnTime = processTurnTime;
	}

	// Accessor method for getPriority
	public int getPriority() {
		return this.processPriority;
	}

	// Accessor method for getBurst
	public int getBurst() {
		return this.processBurstTime;
	}

	// Mutator method for setBurst
	public void setBurst(int newBurst) {
		this.processBurstTime = newBurst;
	}

	// Accessor method for getTurnTime
	public int getTurnTime() {
		return this.processTurnTime;
	}

	// Mutator method for setTurnTime
	public void setTurnTime(int newTurnTime) {
		this.processTurnTime = newTurnTime;

	}

	public static Comparator<myProcesses> processPriorityCompare = new Comparator<myProcesses>() {

		public int compare(myProcesses p1, myProcesses p2) {
			int firstPriority = p1.getPriority();
			int secondPriority = p2.getPriority();

			// ascending order
			return firstPriority - secondPriority;

		}
	};
	public static Comparator<myProcesses> processBurstCompare = new Comparator<myProcesses>() {

		public int compare(myProcesses p1, myProcesses p2) {
			int firstBurst = p1.getBurst();
			int secondBurst = p2.getBurst();

			// ascending order
			return firstBurst - secondBurst;

		}
	};

	@Override
	public String toString() {
		return "[ Process ID=" + processID + ", Process Burst= " + processBurstTime + ", Process Priority "
				+ processPriority + " Process Turn Time " + processTurnTime + "]";
	}

}
