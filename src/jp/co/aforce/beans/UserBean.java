package jp.co.aforce.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable {
	//static final long serialVersionUIDが必要
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

	List<String>users = new ArrayList<String>();
	users.add("山田");
	users.add("加藤");
    }
}
