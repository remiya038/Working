package setting;

import java.beans.Beans;
import java.sql.Timestamp;

public class Beans_setting extends Beans {
	private int mode;
	private Timestamp date;


	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

}
