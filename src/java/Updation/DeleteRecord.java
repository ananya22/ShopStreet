package Updation;



import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteRecord extends HttpServlet{

 Connection con=null;
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
                    
                response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Dbclass db=new Dbclass();
                           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Delete Category</title>");            
            out.println("</head>");
   out.println("<body>");
   
                 con=db.dbConnect();
                 ResultSet rs=null;
                int id=Integer.parseInt(request.getParameter("id"));
                Statement stmt1;
     try {
         stmt1 = con.createStatement();
          String sql="select * from category where categoryId="+id;
                             rs=   stmt1.executeQuery(sql);
                             if(rs.next())
                             {
                                 stmt1.executeUpdate("delete from category where categoryId='"+id+"'");
                                  System.out.println("Record Deleted");
                             }
                             else
                             {
                                System.out.println("Record not found");  
                             }
         } catch (SQLException ex) {
         Logger.getLogger(DeleteRecord.class.getName()).log(Level.SEVERE, null, ex);
     
         
     }
     	
response.sendRedirect("Admin/Pages/CategoryUpdate.jsp");
     
         out.println("</body>");
            out.println("</html>");
                          
                   
     } 
               
                
        

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		doGet(request,response);
	}
}