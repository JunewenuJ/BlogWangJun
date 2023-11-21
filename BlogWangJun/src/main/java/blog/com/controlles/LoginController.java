package blog.com.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	//ユーザ登録画面を表示させる
	@GetMapping("/register")
	public String getRegisterPage() {
		return "registry.html";        
	}
	//ログイン画面を表示させる
	@GetMapping("/login")
	public String getLoginPage() {
		return "login.html";
	}
	//ブログ一覧画面を表示させる
	@GetMapping("/listOfBlogs")
	public String getListOfBlogsPage() {
		return "list-of-blogs.html";        
	}
	//ブログ画面を表示させる
	@GetMapping("/blog")
	public String getBlogPage() {
		return "blog.html";        
	}
	//ブログ登録画面を表示させる
	@GetMapping("/createBlog")
	public String getCreateBlogPage() {
		return "create-blog.html";        
	}
	//ブログ編集画面を表示させる
	@GetMapping("/editBlog")
	public String getEditBlogPage() {
		return "edit-blog.html";        
	}
	//ブログログアウト画面を表示させる
	@GetMapping("/logout")
	public String getLogoutPage() {
		return "logout.html";        
	}
	
	//ログイン画面から送信されたデータを受け取る  
	@PostMapping("/login/process")
	public String login(@RequestParam String email, @RequestParam String password) {

	    // もし、emailの内容がadmin@test.comと等しいこと
	    // かつpasswordの内容がadminと等しい場合は、/resultに転送(リダイレクト）
	    // そうでない場合//ログイン画面/loginに転送(リダイレクト)
	    if (email.equals("admin@test.com") && password.equals("admin")) {
	        return "redirect:/listOfBlogs";
	    } else {
	        // 否则，重定向到登录页面/login
	        return "redirect:/login";
	    }
	}
		@PostMapping("register/process")
		public String register(@RequestParam String username,@RequestParam String email,@RequestParam String password) {
			if(username.equals("user") && email.equals("admin@test.com") && password.equals("admin")) {
				return "redirect:/listOfBlogs";
			}else {
				return"redirect:/register";
			}
		}

	
}
