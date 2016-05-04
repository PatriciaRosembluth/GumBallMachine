
public class GumballMachine {
	
	MachineState state = new SoldOutState();
	private int count;
	private String operation;

	public GumballMachine(int count) {
		this.count = count;
		if (count > 0)
			state  = new NoQuarterState();
	}

	public void insertQuarter() {
		operation = "insert";
		if (state.getState() == "NO_QUARTER") {
			state = new HasQuarterState();
		}
		else if (state.getState() == "HAS_QUARTER") {
			count++;
		}
		state.ShowMessage(count, operation);			
	}

	public void ejectQuarter() {
		operation = "eject";
		if (state.getState() == "HAS_QUARTER") {
			state = new NoQuarterState();
		}
		else if (state.getState() == "NO_QUARTER"){
			count --;
		}
		state.ShowMessage(count, operation);
	}

	public void turnCrank() {
		operation = "turnCrank";
		if (state.getState() == "HAS_QUARTER") {
			state = new SoldState();
		}
		state.ShowMessage(count, operation);
		dispense();
	}

	public void dispense() {
		operation = "dispense";
		if (state.getState() == "SOLD") {
			state.ShowMessage(count, operation);
			count --;
			if (count == 0) {
				state = new SoldOutState();
				count--;
			}
		}
		else if (state.getState() == "HAS_QUARTER"){
			count ++;
		}
		state.ShowMessage(count, operation);
			
	}

}