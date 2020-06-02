package jp.co.aforce.models;

import java.util.List;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.util.DBUtil;

public class UserModel {

	// DB上にある全てのユーザ情報を取得

	public List<UserBean> getAllUsers() {
		// TODO 自動生成されたメソッド・スタブ

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `users`";
			DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return null;




	}
}
