package ACCESSCODE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OoooSmartClock implements IDialog {

	private IDialog dialog = null;
	private int zoneIndex = -1;
	private Date currentDate = null;
	
	//new 
	public int show(){
		return 3;
	}
	public void setUpDialog(IDialog _dialog) {
		this.dialog = _dialog;
	}
	
	public void setTimeZone() throws Exception {
		if (dialog == null)
			throw new Exception("NODATA_CHOOSED");
		
		setTimeZone(dialog.show());
	}
	
	public void setTimeZone(int index) {
		zoneIndex = index;
	}
	
	public int getTimeZone() {
		return zoneIndex;
	}
	
	public void setCurrentTime(Date date) {
		currentDate = date;
	}
	
	public String getCurrentTimeStamp() {	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(currentDate);
	}
	
	public String getLocalCurrentTimeStamp() {		
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		DateFormat dfTime = new SimpleDateFormat("HH:mm:ss");
		DateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");
		
		String returnFormatString = dfDate.format(currentDate);
		
		if (cal.get(Calendar.MONTH) == (10-1) && cal.get(Calendar.DAY_OF_MONTH) == 10) {
			returnFormatString += " DOUBLE-TEN";
		}
		else if (cal.get(Calendar.MONTH) == (8-1) && cal.get(Calendar.DAY_OF_MONTH) == 8) {
			returnFormatString += " FATHER'S DAY";
		}
		else if (cal.get(Calendar.MONTH) == (12-1) && cal.get(Calendar.DAY_OF_MONTH) == 25) {
			returnFormatString += " X'MAS";
		}
		
		if (cal.get(Calendar.HOUR_OF_DAY) == 12 && 
				(cal.get(Calendar.MINUTE) == 0 || (cal.get(Calendar.MINUTE) == 1 && cal.get(Calendar.SECOND) == 0))) {
			returnFormatString += " NOON";
		}
		else if (cal.get(Calendar.HOUR_OF_DAY) == 0 && 
				(cal.get(Calendar.MINUTE) == 0 || (cal.get(Calendar.MINUTE) == 1 && cal.get(Calendar.SECOND) == 0))) {
			returnFormatString += " MIDNIGHT" ;
		}
		else returnFormatString += " " + dfTime.format(currentDate) ;
		
		return returnFormatString;
	}

	@Override
	public int show() {
		// TODO Auto-generated method stub
		return 0;
	}
}
