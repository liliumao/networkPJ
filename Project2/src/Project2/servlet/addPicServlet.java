package Project2.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;  
import com.jspsmart.upload.SmartUpload;  
import com.jspsmart.upload.SmartUploadException;  

import Project2.bll.User;

/**
 * Servlet implementation class addPicServlet
 */
public class addPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private   ServletConfig   config;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
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
		//����һ��smart upload
		 request.setCharacterEncoding("UTF-8"); 
		 String filePath = "C:/Users/asus/Documents/Eclispe/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project2/Pic/";
		 //System.out.println(request.getRealPath("/"));
	     //String messages="";
	     //String forward="";
	     String id = ""+((User)request.getSession().getAttribute("user")).getId();
	     SmartUpload su = new SmartUpload();      
	     long maxsize = 2 * 1024 * 1024;// ����ÿ���ϴ��ļ��Ĵ�С��Ϊ2MB  
	     String allowedFilesList = "png";  
	     String denidFilesList = "exe,bat,jsp,htm,html";  
	          
	     try
	     {  
	    	 su.initialize(config, request, response);//��ʼ��
	         su.setMaxFileSize(maxsize);// �����ϴ��ļ��Ĵ�С  
	         su.setAllowedFilesList(allowedFilesList);// ���������ϴ����ļ�����  
	         su.setDeniedFilesList(denidFilesList);     
	         su.upload();// �ϴ��ļ�  
	         {  
	             File file = su.getFiles().getFile(0);// ��ȡ�ϴ����ļ�����Ϊֻ�ϴ���һ���ļ������Կ�ֱ�ӻ�ȡ              
	             if (!file.isMissing())
	             {// ���ѡ�����ļ�  
	                 //String now = new Date().getTime() + "";//��ȡ��ǰʱ�䲢��ʽ��Ϊ�ַ���  
	                 String photoAddr=filePath + id + "."+file.getFileExt();//filePathֵ  
	                 
	                 file.saveAs(photoAddr,File.SAVEAS_AUTO);              
	             }
	             else
	             {  
	                 //messages="��ѡ��Ҫ�ϴ����ļ���";  
	                 //forward="/Project2/error.jsp";  
	            	 request.getSession().setAttribute("wrong1", "picwrong2");
	             }                  
	         }              
	     }
	     catch (java.lang.SecurityException e)
	     {  
	    	 //messages="<li>�ϴ��ļ�ʧ�ܣ��ϴ����ļ�����ֻ����Ϊ��png</li>";  
	         //forward="/Project2/error.jsp";    
	    	 request.getSession().setAttribute("wrong1", "picwrong1");
	     }
	     catch (SmartUploadException e)
	     {  
	         //messages="�ϴ��ļ�ʧ�ܣ�";  
	         //forward="/Project2/error.jsp";  
	    	 request.getSession().setAttribute("wrong1", "picwrong");
	     }
	     catch (SQLException e)
	     {  
	    	 request.getSession().setAttribute("wrong1", "picwrong");
	     }                  
	     //request.setAttribute("messages",messages);          
	     response.sendRedirect("Main.jsp?id="+id+"&type=2&page=1");
	 }  
}
