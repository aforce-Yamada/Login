package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.models.LoginModel;
import jp.co.aforce.models.UserModel;



// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

    	// GETリクエストはあり得ないので、無条件でログイン画面に飛ばす
    	RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
    	rDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    	// 文字のエンコードをUTF-8 とする。これがないと文字化け。
    	request.setCharacterEncoding("UTF-8");

    	// ユーザによって入力された情報を取り出す
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");

    	// 取り出した情報を loginBean に格納する
        LoginBean loginBean = new LoginBean();
    	loginBean.setUsername(username);
    	loginBean.setPassword(password);

    	// モデルをインスタンス化する
    	LoginModel loginModel = new LoginModel();
    	String forward_jsp = "/views/login.jsp";

    	// 入力された情報がDBに存在するか調べる
    	if (loginModel.loginCheck(username,password)) {

    		// TODO ここはオリジナル処理を考える(余裕があったら) ↓↓
            // 例）ログインしたユーザの情報を表示する
            // DB上にある全てのユーザ情報を取得
    		UserModel userModel = new UserModel();
            // List<UserBean> users = userModel.getAllUsers();
    		userModel.getAllUsers(username);

            System.out.println("ユーザー名：" + username + "パスワード：" + password);
            // List<UserBean> users = userModel.getAllUsers();
    		/* List<UserBean> password 必要？*/
            // TODO ここはオリジナル処理を考える(余裕があったら) ↑↑

    		// リクエストオブジェクトに設定
    		// request.setAttribute("users", users);

    		// ログインに成功した先のJSPを指定
    		forward_jsp = "/views/success.jsp";

    	// ログインが失敗したときの処理
    	} else {
    		// エラーメッセージを認定
    		loginBean.setEmsg("ユーザー名またはパスワードが違います");
    		request.setAttribute("loginBean", loginBean);
    	}
    	// forward_jspに認定されているJSPへディスパッチ
    	RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
    	rDispatcher.forward(request, response);
    }
}
