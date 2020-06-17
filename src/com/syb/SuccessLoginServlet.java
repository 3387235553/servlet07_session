package com.syb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/successLogin")
public class SuccessLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //获取id
//        String id = session.getId();
//        System.out.println(id);
        //获取session创建时间
//        System.out.println(new Date(session.getCreationTime()));

        if (session != null) {
            Object acObj = session.getAttribute(SessionEnum.SESSION_KEY.getAccount());
            Object psObj = session.getAttribute(SessionEnum.SESSION_KEY.getPassword());

            if (acObj != null && psObj != null) {
                request.setAttribute("account",acObj);
                request.setAttribute("password",psObj);
                request.getRequestDispatcher("success.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);


    }
}
