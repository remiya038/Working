package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Timesheet;

public class Dao2 {
	// PropertiesからDBの情報の読み込み
	ResourceBundle rb = ResourceBundle.getBundle("main");


    String url = rb.getString("URL");
    String id =rb.getString("ID");
    String pass = rb.getString("PASS");

///////////////////////出勤
   public Timesheet punchin(int emp_no, Timestamp time) {
      Connection conn = null;
      int numRow = 0;
      Timesheet timesheet = new Timesheet();
      PreparedStatement stat = null;
      ResultSet rset = null;
      timesheet.setEmp_no(emp_no);
      timesheet.setPunchin(time);
      try {
    	 // Class.forName("org.postgresql.Driver");
          conn = DriverManager.getConnection(this.url, this.id, this.pass);
         String sql = "INSERT INTO timesheet (emp_no, punchin,exe_date) VALUES (?,?,?)";
         stat = conn.prepareStatement(sql);
         stat.setInt(1, emp_no);
         stat.setTimestamp(2, time);
         stat.setTimestamp(3, time);
			//SQLの発行、INSERTした行数をnumRowに格納
         numRow = stat.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();



      } finally {
         if (numRow > 0) {
							//成功時にコミット
						try {
							conn.commit();

						} catch (SQLException e) {
							e.printStackTrace();
						}
						}else {
							try {
								conn.rollback();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
      try {
	stat.close();
} catch (SQLException e) {
	e.printStackTrace();
}
             }

          if (rset != null) {
                try {
	rset.close();
} catch (SQLException e) {
	e.printStackTrace();
}
}
       return timesheet;
    }
///////////////////////退勤
   public int punchout(int emp_no, Timestamp time,String dateStr) {
		      Connection conn = null;
		      int numRow = 0;
		      PreparedStatement stat = null;
		      ResultSet rset = null;
		      try {
		         conn = DriverManager.getConnection(this.url, this.id, this.pass);
		         String sql = "UPDATE timesheet SET punchout = ? WHERE to_char(exe_date,'YYYY-MM-DD') LIKE ? AND emp_no = ?";
		         stat = conn.prepareStatement(sql);
		         stat.setTimestamp(1, time);
		         stat.setString(2, dateStr);
		         stat.setInt(3, emp_no);
					//SQLの発行、INSERTした行数をnumRowに格納
		         numRow = stat.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         if (numRow > 0) {
									//成功時にコミット
								try {
									conn.commit();

								} catch (SQLException e) {
									e.printStackTrace();
								}
								}else {
									try {
										conn.rollback();
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
		      try {
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		             }

		          if (rset != null) {
		                try {
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		       return numRow;
		    }


////////////////////////勤怠表出力
    public ArrayList<Timesheet> select_emp(int emp_no) {
       Connection conn = null;
       Timesheet data = null;

       PreparedStatement stat = null;
       ResultSet rset = null;
       ArrayList timesheets = new ArrayList();


       try {
          conn = DriverManager.getConnection(this.url, this.id, this.pass);

          String sql = "SELECT * FROM timesheet  WHERE emp_no = ?";
          stat = conn.prepareStatement(sql);
          stat.setInt(1, emp_no);
          rset = stat.executeQuery();
          while(rset.next()) {
             data = new Timesheet();
             data.setEmp_no(rset.getInt("emp_no"));
             data.setPunchin(rset.getTimestamp("punchin"));
             data.setPunchout(rset.getTimestamp("punchout"));
             timesheets.add(data);
          }
       } catch (SQLException e) {
          e.printStackTrace();



       } finally {
          if (stat != null) {
             try {
                stat.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }         }

          if (rset != null) {
             try {
                rset.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }         }

          if (conn != null) {
             try {
                conn.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }         }
       }

       return timesheets;
    }
//社員番号と実行日で検索
public Timesheet search_emp_date(int emp_no,String time) {
    Connection conn = null;
    Timesheet data = null;
    PreparedStatement stat = null;
    ResultSet rset = null;
    try {
       conn = DriverManager.getConnection(this.url, this.id, this.pass);

       String sql = "select * from timesheet where emp_no = ? AND  to_char(exe_date,'yyyy-MM-dd') like (?)";
       stat = conn.prepareStatement(sql);
       stat.setInt(1, emp_no);
       stat.setString(2, time+"%");
       rset = stat.executeQuery();

       if (rset.next()) {
           data = new Timesheet();
           data.setEmp_no(rset.getInt("emp_no"));
           data.setPunchin(rset.getTimestamp("punchin"));
           data.setPunchout(rset.getTimestamp("punchout"));
           data.setExe_date(rset.getTimestamp("exe_date"));
        }

    } catch (SQLException e) {
       e.printStackTrace();
    } finally {
       if (stat != null) {
          try {
             stat.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }         }

       if (rset != null) {
          try {
             rset.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }         }

       if (conn != null) {
          try {
             conn.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }         }
    }

    return data;
 }
}

