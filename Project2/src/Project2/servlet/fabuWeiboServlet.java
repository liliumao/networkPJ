package Project2.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project2.bll.UserAction;

/**
 * Servlet implementation class fabuWeiboServlet
 */
public class fabuWeiboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fabuWeiboServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String txt = request.getParameter("fabu");
		//servlet���ж�΢���ǲ��Ǵ���140������ص�
		if(txt.length() > 140)
			txt = txt.substring(0, 140);
		String idS = request.getParameter("id");
		String type= request.getParameter("type");
		int id = Integer.parseInt(idS);
		if(txt.length() == 0)
		{
			//�ж��ǲ��ǿյ�
			request.setAttribute("word", 0);
			response.sendRedirect("../Project2/Main.jsp?id="+id+"&type="+type+"&page=1");
			return;
		}
		try
		{
			//���ǿյľ�ִ��
			boolean ans = UserAction.insertWeibo(txt, id);
			if(ans==true)
			{
				response.sendRedirect("../Project2/Main.jsp?id="+id+"&type="+type+"&page=1");
			}
			else
			{
				request.getSession().setAttribute("wrong1", "fabuwrong");
				response.sendRedirect("../Project2/Main.jsp?id="+id+"&type="+type+"&page=1");
			}
		}
		catch(Exception e)
		{
			//���ݿ���󱨴�
			request.getSession().setAttribute("wrong1", "fabuwrong");
			response.sendRedirect("../Project2/Main.jsp?id="+id+"&type="+type+"&page=1");
		}
		//System.out.println(id+txt);
	}

}
