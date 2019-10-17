package CC;

public class ILogger {
	
	public String content;
	
	public ILogger() {
		content = "";
	}
	
	public void setLog(String message){
		content = content +message+ "\n";
	}
	
	public String getLog(){
		return content;
	}
}