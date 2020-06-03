// Model アプリケーションの主たる処理やデータの格納などを行う
package jp.co.aforce.models;

import jp.co.aforce.util.DBUtil;

public class UserModel {

	// DB上にある全てのユーザ情報を取得

	public String getAllUsers(String username) {

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `users` WHERE `username`='"+username+"'";
			DBUtil.execute(SQL);
			System.out.println("getAllUsersに成功しました");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getAllUsersに例外が発生しました");
		} finally {
			DBUtil.closeConnection();
		}
		return null;




	}
}
