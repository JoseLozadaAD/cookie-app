package org.assuresoft.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assuresoft.utils.Constants;

import java.io.IOException;

@WebServlet("/delete-cookie")
public class DeleteCookieController extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Cookie cookie = new Cookie(Constants.COOKIE_NAME, "");

    cookie.setMaxAge(0);
    response.addCookie(cookie);
    response.sendRedirect("index.html");
  }
}
