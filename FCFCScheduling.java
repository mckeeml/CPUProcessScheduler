import java.util.*;

public class FCFSScheduling extends myProcesses {
	
	private ArrayList<myProcesses> priorityProcesses;
	private int processTurnTime = 0;

	// Default Constructor
	public FCFSScheduling() {
	}

	public FCFSScheduling(ArrayList<myProcesses> priorityProcesses) {
		this.priorityProcesses = priorityProcesses;

	}

	// Method to calculate Turn Around Time
	public void turnAroundTime() {
		for (int i = 0; i < priorityProcesses.size(); i++) {
			processTurnTime = processTurnTime + priorityProcesses.get(i).getBurst();
			priorityProcesses.get(i).setTurnTime(processTurnTime);

		}
	}

	// Method to print processes
	public void printProcesses() {
		for (myProcesses str : priorityProcesses) {
			System.out.println(str);
		}
	}
}