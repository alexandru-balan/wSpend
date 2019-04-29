import java.io.IOException;
import java.io.PrintWriter;
import wSpend.DB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
    
    public Login() {
        super();
        firstName = lastName = email = "";
    }

    public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB database = new DB();
		if(database.searchInDataBase(request.getParameter("email"),request.getParameter("password"))) {
			email = request.getParameter("email");
			firstName = database.getFirstName("email");
			lastName = database.getLastName("email");
			
			try(PrintWriter out = response.getWriter();){
				
				out.println("<!DOCTYPE html>\r\n" + 
						"<html lang=\"en\">\r\n" + 
						"\r\n" + 
						"<head>\r\n" + 
						"    <meta charset=\"UTF-8\">\r\n" + 
						"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
						"    <title>wSpend</title>\r\n" + 
						"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n" + 
						"        crossorigin=\"anonymous\">\r\n" + 
						"    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.10/css/all.css\" integrity=\"sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg\"\r\n" + 
						"        crossorigin=\"anonymous\">\r\n" + 
						"    <link rel=\"icon\" href=\"Front_End/res/icons/logo.png\">\r\n" + 
						"    <link rel=\"stylesheet\" href=\"Front_End/styles/master.css\">\r\n" + 
						"    <link rel=\"stylesheet\" href=\"Front_End/styles/index.css\">\r\n" + 
						"    <link rel=\"stylesheet\" href=\"Front_End/styles/profile.css\">\r\n" + 
						"</head>\r\n" + 
						"\r\n" + 
						"<body>\r\n" + 
						"\r\n" + 
						"    <header>\r\n" + 
						"        <!--This is the navbar on the top of the screen-->\r\n" + 
						"        <nav class=\"navbar navbar-expand-lg\">\r\n" + 
						"            <a class=\"navbar-brand\" href=\"index.jsp\">wSpend</a>\r\n" + 
						"            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#content\" aria-controls=\"content\">\r\n" + 
						"                <span>\r\n" + 
						"                    <i class=\"fas fa-bars\"></i>\r\n" + 
						"                </span>\r\n" + 
						"            </button>\r\n" + 
						"\r\n" + 
						"            <div class=\"collapse navbar-collapse\" id=\"content\">\r\n" + 
						"                <ul class=\"navbar-nav ml-auto\">\r\n" + 
						"                    <li class=\"nav-item\">\r\n" + 
						"                        <a class=\"nav-link\" href=\"Front_End/sources/team.jsp\">Team</a>\r\n" + 
						"                    </li>\r\n" + 
						"                    <li class=\"nav-item\">\r\n" + 
						"                        <a class=\"nav-link\" href=\"Front_End/sources/pricing.jsp\">Pricing</a>\r\n" + 
						"                    </li>\r\n" + 
						"                    <li class=\"nav-item\">\r\n" + 
						"                        <a class=\"nav-link\" href=\"Front_End/sources/contact.jsp\">Contact</a>\r\n" + 
						"                    </li>\r\n" + 
						"                    <li class=\"nav-item\">\r\n" + 
						"                        <a class=\"nav-link\" href=\"configdata.jsp\">Budget Configuration</a>\r\n" + 
						"                    </li>\r\n" + 
						"                </ul>\r\n" + 
						"            </div>\r\n" + 
						"        </nav>\r\n" + 
						"\r\n" + 
						"    </header>\r\n" + 
						"\r\n" + 
						"    <main>\r\n" + 
						"       <div id=\"containerProfileBox\">\r\n" + 
						"            <div id=\"profileBox\">\r\n" + 
						"                <img src=\"Front_End\\res\\photos\\profile\\profile.jpg\">");
				out.println("<h1>"+database.getFirstName(email)+"</h1>");
				out.println("<h2>"+database.getLastName(email)+"</h2>");
				out.println("<h3>"+email+"</h3>");
				out.println("<a id=\"link\" href=\"configdata.jsp\"><button class=\"btn btn-primary\">Budget configuration</button></a>    \r\n" + 
						"            </div><div id=\"incomes\">");
				out.println("<h1>"+"INCOMES : "+database.getTotalIncomes(email)+"</h1></div>\r\n" + 
						"            <div id=\"expenses\">");
				out.println("<h1>"+"EXPENSES : "+database.getTotalExpenses(email)+"</h1></div>\r\n" + 
						"            <div id=\"remaining\">");
				out.println("<h1>"+"REMAINING : "+(database.getTotalIncomes(email)-database.getTotalExpenses(email)-database.getTotalSavings(email))+"</h1></div>\r\n" + 
						"            <div id=\"savings\">");
				out.println("<h1>"+"SAVINGS : "+database.getTotalSavings(email)+"</h1></div>\r\n" + 
						"       </div>\r\n" + 
						"    </main>\r\n" + 
						"\r\n" + 
						"    <!--Scripts part-->\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\r\n" + 
						"        crossorigin=\"anonymous\"></script>\r\n" + 
						"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"\r\n" + 
						"        crossorigin=\"anonymous\"></script>\r\n" + 
						"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"\r\n" + 
						"        crossorigin=\"anonymous\"></script>\r\n" + 
						"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquerymobile/1.4.5/jquery.mobile.min.js\"></script>\r\n" + 
						"\r\n" + 
						"    <!--<script>\r\n" + 
						"        (function () {\r\n" + 
						"            ('#logForm').on('submit', function (e) {\r\n" + 
						"                e.preventDefault();\r\n" + 
						"                post('C:\\Users\\balan\\Documents\\GitHub\\wSpend\\post.txt',\r\n" + 
						"                    ('#logForm').serialize(),\r\n" + 
						"                );\r\n" + 
						"            });\r\n" + 
						"        });\r\n" + 
						"    </script>-->\r\n" + 
						"\r\n" + 
						"</body>\r\n" + 
						"\r\n" + 
						"</html>");
			}
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
