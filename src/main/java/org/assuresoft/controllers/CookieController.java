package org.assuresoft.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assuresoft.model.CookieData;
import org.assuresoft.utils.Constants;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieController extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String name = request.getParameter("name");

    CookieData cookieData = new CookieData();
    cookieData.setName(name);

    Cookie cookie = new Cookie(Constants.COOKIE_NAME, cookieData.getName());

    cookie.setMaxAge(3600);
    response.addCookie(cookie);
    response.sendRedirect("index.html");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (Constants.COOKIE_NAME.equals(cookie.getName())) {
          request.setAttribute("cookieValue", cookie.getValue());
          break;
        }
      }
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher("showCookie.jsp");
    dispatcher.forward(request, response);
  }
}
