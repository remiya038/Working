package setting;

import java.sql.Timestamp;

import logic.Convert;

public class Logic_setting {
	Dao_setting dao = new Dao_setting();
	Convert con = new Convert();


	public Beans_setting check() {
		Beans_setting settinglist = null;

		settinglist = dao.get();
		return settinglist;
	}


	//変更ボタンを押されたとき
	public int update(int mode,String date,String time) {
		//引数の文字列をtimestamp型に
		String timestamp_tmp = date+ " " + time + ":00";
		Timestamp timestamp =con.strTimestamp(timestamp_tmp);

		//Daoからデータベースの更新
		int row = dao.update(mode, timestamp);

		return row;
	}

	public int update2(int mode) {
		int row = dao.update2(mode);
		return row;
	}



	//設定情報を取得しbeansに格納
	public Beans_setting get() {
		Beans_setting setting;
		//Daoからデータベースの情報を取得
		setting = dao.get();

		return setting;
	}
}
