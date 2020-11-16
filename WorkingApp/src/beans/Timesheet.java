 package beans;
import java.io.Serializable;
import java.sql.Timestamp;

public class Timesheet implements Serializable {
private int emp_no;
private Timestamp punchin;
private Timestamp punchout;
private Timestamp exe_date;

public int getEmp_no() {
	return emp_no;
}
public void setEmp_no(int emp_no) {
	this.emp_no = emp_no;
}
public Timestamp getPunchin() {
	return punchin;
}
public void setPunchin(Timestamp punchin) {
	this.punchin = punchin;
}
public Timestamp getPunchout() {
	return punchout;
}
public void setPunchout(Timestamp punchout) {
	this.punchout = punchout;
}
public Timestamp getExe_date() {
	return exe_date;
}
public void setExe_date(Timestamp exe_date) {
	this.exe_date = exe_date;
}

 }
