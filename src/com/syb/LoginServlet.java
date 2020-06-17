package com.syb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/loginSession")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        //获取id
//        String id = session.getId();
//        System.out.println(id);
        //获取session创建时间
//        System.out.println(new Date(session.getCreationTime()));

        if (account.equals(SessionEnum.SESSION_KEY.getAccount()) && password.equals(SessionEnum.SESSION_KEY.getPassword())) {

            //获取session
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10);
            session.setAttribute(SessionEnum.SESSION_KEY.getAccount(), account);
            session.setAttribute(SessionEnum.SESSION_KEY.getPassword(), password);

            request.setAttribute("account",account);
            request.setAttribute("password",password);
            request.getRequestDispatcher("/successLogin").forward(request, response);

        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }
}
