package com.atguigu.javaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet extends GenericServlet {
    //继承了之后 一大堆的东西都不用写了 都直接在父类了 destroy（）等等的
	
	//对当前的 Servlet 进行初始化: 覆盖 init 方法   
	@Override
	public void init(javax.servlet.ServletConfig config) throws ServletException {  //config 参数是服务器传递过来的
		super.init(config);
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		//获取请求方式是 GET 还是 POST
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;  //需要强转  不够好哦  要是封装下 
		String method = httpServletRequest.getMethod();
		System.out.println(method); 
		
		//1. 获取请求参数: username, password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2. 获取当前 WEB 应用的初始化参数: user, password.
		//需要使用 ServletContext 对象. 
		String initUser = getServletContext().getInitParameter("user");  //父类里面封装好了的参数 是从上下文中获取的哦
		String initPassword = getServletContext().getInitParameter("password");

		PrintWriter out = response.getWriter();
		
		//3. 比对
		//4. 打印响应字符串. 
		if(initUser.equals(username) && initPassword.equals(password)){
			out.print("Hello: " + username);
		}else{
			out.print("Sorry: " + username);
		}
		
		
	}

}
