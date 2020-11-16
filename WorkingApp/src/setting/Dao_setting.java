package setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class Dao_setting {
	// PropertiesからDBの情報の読み込み
	ResourceBundle rb = ResourceBundle.getBundle("main");


    String url = rb.getString("URL");
    String id =rb.getString("ID");
    String pass = rb.getString("PASS");
	///////////////////////設定情報の取得
	   public Beans_setting get() {
		    Connection conn = null;
		    Beans_setting setting = null;
		    PreparedStatement stat = null;
		    ResultSet rset = null;
		    try {
		       conn = DriverManager.getConnection(this.url, this.id, this.pass);
		       String sql = "select * from setting";
		       stat = conn.prepareStatement(sql);
		       rset = stat.executeQuery();
		       if (rset.next()) {
		    	   setting = new Beans_setting();
		    	   setting.setMode(rset.getInt("mode"));
		    	   setting.setDate(rset.getTimestamp("date"));
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
		    return setting;
		 }


///////////////////////設定情報の変更　　　UPDATE table_name SET column_name = value
	   public int update(int mode, Timestamp date) {
		      Connection conn = null;
		      int numRow = 0;
		      PreparedStatement stat = null;
		      ResultSet rset = null;
		      try {
		         conn = DriverManager.getConnection(this.url, this.id, this.pass);
		         String sql = "UPDATE setting SET mode = ?,date = ?";
		         stat = conn.prepareStatement(sql);
		         stat.setInt(1, mode);
		         stat.setTimestamp(2, date);
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

///////////////////////設定情報の変更 modeのみ変更
public int update2(int mode) {
Connection conn = null;
int numRow = 0;
PreparedStatement stat = null;
ResultSet rset = null;
try {
  conn = DriverManager.getConnection(this.url, this.id, this.pass);
  String sql = "UPDATE setting SET mode = ?";
  stat = conn.prepareStatement(sql);
  stat.setInt(1, mode);

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


}
