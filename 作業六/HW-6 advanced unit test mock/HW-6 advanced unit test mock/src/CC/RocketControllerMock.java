package CC;

public class RocketControllerMock implements IRocketSystemBase {
	
	ILogger logger;
	
	
	@Override
	public void ignite(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutoff(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		
	}
	
	public void fireUp(String control_string) {
		logger.setLog(control_string);
	}

	
	
}
