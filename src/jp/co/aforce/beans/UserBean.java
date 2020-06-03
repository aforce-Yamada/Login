package jp.co.aforce.beans;

import java.io.Serializable;

public class UserBean implements Serializable {
	//static final long serialVersionUIDが必要
	private static final long serialVersionUID = 1L;

	// フィールド
	// private List<UserBean> users = new ArrayList<UserBean>();

	private String username;

	// 引数なしのデフォルトコンストラクタ
    public UserBean() {
    }

    // allusersフィールドのsetter,gette
    // 返り値の型 メソッド名(引数の型 引数名) {メソッドの処理}
    public String getAllUsers() {
    	return username;
    }

    public void setAllUsers(String username) {
    	this.username = username;
    }





}
