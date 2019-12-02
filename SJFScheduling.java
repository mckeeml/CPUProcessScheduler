import java.util.*;

public class SJFScheduling extends myProcesses {
	private ArrayList<myProcesses> priorityProcesses;

	public SJFScheduling(ArrayList<myProcesses> priorityProcesses) {
		this.priorityProcesses = priorityProcesses;
	}

	public void turnAroundTime() {
		for (int i = 0; i < priorityProcesses.size(); i++) {
			processTurnTime = processTurnTime + priorityProcesses.get(i).getBurst();
			priorityProcesses.get(i).setTurnTime(processTurnTime);

		}
	}

	public void printOrderByBurst() {
		for (myProcesses str : priorityProcesses) {
			System.out.println(str);
		}
	}
}