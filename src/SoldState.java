public class SoldState implements MachineState{

	public void ShowMessage(int coins, String operation) {
		if(coins == 0 && operation == "insert"){
			System.out.println(Messages.INSERT_WHEN_SOLD);
		}else if(coins == 0 && operation == "eject"){
			System.out.println(Messages.EJECT_WHEN_SOLD);
		}else if(coins == 1 && operation == "turnCrank"){
			System.out.println(Messages.TURN_SUCCESSFULLY);
		}else if(coins == 1 && operation == "dispense"){
			System.out.println(Messages.DISPENSE_SUCCESSFULLY);
		}
	}

	public String getState() {
		return "SOLD";
	}
}
