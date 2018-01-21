/*
 * Melnik Boris 21/01/2018
 * ����� �� ����� �� ������ �� �볺��-�������� �������������
 * IDE - ����� ������� � WebTools �������, ���� �������� ������ ��������� ������� �� ������
 * � ���� ��� ������ ���������, ��������� �� ��-���������� ��������!*/

package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

	private static final String login = "boris";
	private static final String pass = "1234";
	private boolean authorised = false;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		
		response.setIntHeader("Refresh", 5);

		try (PrintWriter out = response.getWriter()) {
			// out.println("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n");
			if (!authorised) {
				out.println("<html><head><title>Login Screen</title></head><body style=\"background:#CCFFCC\"><div style=\"max-width:500px;margin:auto;\"><div style=\"color:red;text-align:center;font-size:40px;\">Login Screen.</div><br><form method=\"post\">Login:<input type=\"text\" name=\"login\"><br>Password:<input type=\"password\" name=\"pass\"><br><input type=\"submit\" value=\"Enter\"></form></div></body></html>");

				if (request.getParameter("login") != null) {
					if ((!request.getParameter("login").equals(login))||(!request.getParameter("pass").equals(pass))) {
						out.println("Wrong login or password!");
					}
					if(request.getParameter("login").equals(login)&&request.getParameter("pass").equals(pass)) {
						authorised=true;
						//out.println("<meta http-equiv=\"refresh\" content=\"1;url=localhost:8080/EE1MelnikBoris/Servlet\"/>");
						}
				}

			} else {
				out.println("YOU ARE AUTHORISED!");
			}
			out.close();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		processRequest(request, response);

	}

}