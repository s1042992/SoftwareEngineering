package CC;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
public class RocketController  {
	
	IRocketSystemBase rocket;
	
	//public int countIgnite = 0, countShutoff = 0, countLog = 0;
	
	public void setUpRocketSystem(IRocketSystemBase system) {
		this.rocket = system;
	}
	
	public void fireUp(String controlQueryString) {
		try {
			ControlQuery[] controls = extractControlQuery(controlQueryString);
			int countOfControls = controls.length;
			
			for (int time = 0, i = 0; time <= controls[countOfControls - 1].activeTime; time++) {
				if (controls[i].activeTime == time) {
					if (controls[i].operation == 1) {
						rocket.ignite(controls[i].nozzle, controls[i].pressure);
					}
					else {
						rocket.shutoff(controls[i].nozzle);
					}
					i++;
					TimeUnit.SECONDS.sleep(1);
				}
			}
			
		} catch (Exception e) {
			rocket.log(e.getMessage());
		}
	}
	
	public ControlQuery[] extractControlQuery(String controlQueryString) throws Exception {
		String[] controlQueryStrings = controlQueryString.split("\n");
		ControlQuery[] controls = new ControlQuery[controlQueryStrings.length];
		
		for (int i = 0; i < controlQueryStrings.length; i++)
			controls[i] = new ControlQuery(controlQueryStrings[i]);
		
		Arrays.sort(controls);
		
		return controls;
	}
	
	public class ControlQuery implements Comparable<ControlQuery> {
		
		private int operation;
		private int nozzle;
		private int pressure;
		private int activeTime;
		
		public ControlQuery(String queryString) throws Exception {
			String[] elements = queryString.split(" ");
			int queryElementLen = elements.length;
			if (elements[0].equals("IGNITE")) {
				if (queryElementLen != 5) {
					throw new Exception("ERROR_QUREY_FORMAT");
				}
				else if (elements[1].matches("[0-3]") && elements[2].matches("^[1-9][0-9]+") && elements[3].equals("AT") && elements[4].matches("[0-9]+")) {
					operation = 1;
					nozzle = Integer.parseInt(elements[1]);
					pressure = Integer.parseInt(elements[2]);
					activeTime = Integer.parseInt(elements[4]);
				}
				else throw new Exception("ERROR_QUREY_FORMAT");
			}
			else if (elements[0].equals("SHUTOFF")) {
				if (queryElementLen != 4) {
					throw new Exception("ERROR_QUREY_FORMAT");
				}
				else if (elements[1].matches("[0-3]") && elements[2].equals("AT") && elements[3].matches("[0-9]+")) {
					operation = 0;
					nozzle = Integer.parseInt(elements[1]);
					pressure = -1;
					activeTime = Integer.parseInt(elements[3]);
				}
				else throw new Exception("ERROR_QUREY_FORMAT");
			}
			else throw new Exception("ERROR_QUREY_FORMAT");
		}
		
		@Override
		public int compareTo(ControlQuery another) {
			if (this.activeTime > another.activeTime)
				return 1;
			else
				return -1;
		}
		
	}

	
	
}
