package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * Servlet implementation class GetNoteServlet
 */
@WebServlet("/GetNoteServlet")
public class GetNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JsonElement note;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); //���ñ����ʽ
		
		int id = Integer.valueOf(request.getParameter("id")); //����ȡ�Ĳ���idת����int����
		
		Gson gson = new Gson();
		
		response.getWriter().append(gson.toJson(note));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}