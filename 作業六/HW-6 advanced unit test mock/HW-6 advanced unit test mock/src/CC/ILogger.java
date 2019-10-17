package CC;

public class ILogger {
	
	public String content;
	
	public void setLog(String message)
	{
		content = message;
	}
	
	public String getLog()
	{
		return content;
	}
}