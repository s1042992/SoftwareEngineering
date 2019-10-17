package CC;

public class IRocketSystemBaseMock implements IRocketSystemBase {
	
	ILogger logger;
	
	public IRocketSystemBaseMock(ILogger logger) {
		this.logger = logger;
	}
	
	
	@Override
	public void ignite(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
		logger.setLog("IGNITE 0 1000 AT 0" + "IGNITE 1 500 AT 2");
	}

	@Override
	public void shutoff(int x) {
		// TODO Auto-generated method stub
		logger.setLog("SHUTOFF 0 AT 5" + "SHUTOFF 1 AT 6");
	}

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		logger.setLog(str);
	}
	

	
}