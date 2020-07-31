

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Servlet
 */
@WebServlet("/servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	String name=request.getParameter("name");
	String accnum=request.getParameter("accnum");
	out.print("<h1>Last Transactions</h1>");
	out.print("<table border='1'><tr><th>Debit</th><th>Date</th><th>TransactionId</th>");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/b_hcl","root","root");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from obank");
		while(rs.next())
		{
			out.print("<tr<td>");
			out.println(rs.getInt("debit"));
			out.print("</td>");
			out.print("<td>");
			out.println(rs.getInt("date"));
			out.print("</td>");
			out.print("<td>");
			out.println(rs.getInt("transactionid"));
			out.print("</td>");
			out.print("</tr>");
		}
				
	}catch(Exception p) {
		System.out.println(p);
	}
	
	out.print("</table>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
