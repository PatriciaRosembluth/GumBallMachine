public class SoldOutState implements MachineState {

	public void ShowMessage(int coins, String operation) {
		if(coins == 0 && operation == "insert"){
			System.out.println(Messages.INSERT_WHEN_SOLDOUT);
		}else if(coins == 0 && operation == "eject"){
			System.out.println(Messages.EJECT_WHEN_SOLD_OUT);
		}else if(coins == 0 && operation == "turnCrank"){	
			System.out.println(Messages.TURN_WHEN_SOLD_OUT);
		}else if(coins == -1 && operation == "dispense"){	
			System.out.println(Messages.DISPENSE_LAST_GUMBALL);
		}else if(coins == 0 && operation == "dispense"){	
			System.out.println(Messages.DISPENSE_WHEN_SOLD_OUT);
		}
		
	}

	public String getState() {
		return "SOLD_OUT";
	}
}
