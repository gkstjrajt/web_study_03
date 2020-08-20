package web_study_03;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResearchServlet")
public class ResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] seasons = request.getParameterValues("season");
		if ( seasons == null ) {
			seasons = new String[] {"선택한 항목이 없음"};
		}
		String arrSeason = Arrays.stream(seasons).collect(Collectors.joining(", "));
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("season", arrSeason);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("researchResult.jsp");
		dispatcher.forward(request, response);
//		response.sendRedirect("researchResult.jsp?name=" + name + "&gender" + gender + "&season" + arrSeason);
	}

}
