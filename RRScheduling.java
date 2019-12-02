import java.util.ArrayList;
import java.util.Collections;

public class RRScheduling extends myProcesses {
	
	private ArrayList<myProcesses> priorityProcesses;//create process container
	private ArrayList<myProcesses> priorityProcessesTemp;//create temp process container
	
	ArrayList<Integer> skipProcesses = new ArrayList<Integer>();//create process container to store evaluated processes
	
	private int processTurnTime = 0;
	private int currentTurnTime = 0;

	public RRScheduling(ArrayList<myProcesses> priorityProcesses, ArrayList<myProcesses> priorityProcessesTemp) {
		this.priorityProcesses = priorityProcesses;
		this.priorityProcessesTemp = priorityProcessesTemp;

	}

	public void turnAroundTime(int maxBurst) {
		System.out.println(maxBurst);

		while (maxBurst != 0 && maxBurst > 0) {

			for (int i = 0; i < priorityProcesses.size(); i++) {
				int currentBurst = priorityProcessesTemp.get(i).getBurst();
				int tempBurst = currentBurst;
				
				if (i == (priorityProcesses.size() - 1)) {
					maxBurst = maxBurst - 4; 
					System.out.println("I decreased");
				}

				currentBurst = currentBurst - 4;

				if (priorityProcessesTemp.get(i).getBurst() <= 4) {
					currentTurnTime = currentTurnTime + tempBurst;
				}
				if (skipProcesses.contains(i)) {
					continue;
				}

				if (currentBurst > 0) {
					processTurnTime = currentTurnTime + 4;
					currentTurnTime = processTurnTime;
				}

				if (currentBurst <= 0) {
					priorityProcesses.get(i).setTurnTime(currentTurnTime);
					priorityProcessesTemp.get(i).setBurst(0);
					skipProcesses.add(i);
					continue;
				}

				priorityProcessesTemp.get(i).setBurst(currentBurst);
				priorityProcesses.get(i).setTurnTime(processTurnTime);

			}
		}
	}

	public void printProcesses() {
		for (myProcesses str : priorityProcesses) {
			System.out.println(str);
		}
	}
}