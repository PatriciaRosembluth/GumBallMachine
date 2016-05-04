
public class NoQuarterState implements MachineState {

	public void ShowMessage(int coins, String operation) {
		if(coins == 1 && operation == "eject"){
			System.out.println(Messages.EJECT_SUCCESSFULLY);
		}else if (coins == 0 && operation == "eject"){
			System.out.println(Messages.EJECT_WHEN_NO_QUARTER);
		}else if (coins == 1 && operation == "turnCrank"){
			System.out.println(Messages.TURN_WHEN_NO_QUARTER);
		}else if (coins == 1 && operation == "dispense"){
			System.out.println(Messages.DISPENSE_WHEN_NO_QUARTER);
		}
		
		
		
	}

	public int getState() {
		return 1;
	}

}
