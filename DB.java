package wSpend;
import javax.swing.*;
import java.sql.*;

public class DB {
    Connection conn =null;

    public Connection getConn(){
        return conn;
    }

    private static int check;

    public static int getCheck() {
        return check;
    }

    public static void setCheck(int check) {
        DB.check = check;
    }

    public DB(){
        try{
            String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database,"root","Poligrafie123!");
        }catch (SQLException e){
            System.out.println("error");
        }
    }

    public void writeInDataBase(User user){
        try {
            String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT MAX(idUSERS)+1 FROM users");
            ResultSet rs = pst.executeQuery();
            int userId=0;
            while(rs.next()){
                userId = rs.getInt(1);
            }

            PreparedStatement st = conn.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?)");
            if(userId!=0){
                st.setInt(1,userId);
            }
            else{
                st.setInt(1,1);
            }
            st.setString(2,user.getFirstName());
            st.setString(3,user.getLastName());
            st.setString(4,user.getEmail());
            st.setString(5,user.getPassword());

            int i = st.executeUpdate();

        }catch (SQLException e){
            System.out.println("error");
        }

    }
    
    public void writeInDataBase(Incomes income) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT MAX(idIncomes)+1 FROM incomes");
            ResultSet rs = pst.executeQuery();
            int userIncomes = 0;
            while(rs.next()) {
            	userIncomes = rs.getInt(1);
            }
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO incomes VALUES (?,?,?,?)");
            if(userIncomes!=0) {
            	st.setInt(1, userIncomes);
            }
            else {
            	st.setInt(1, 1);
            }
            st.setString(2, income.getName());
            st.setDouble(3, income.getAmount());
            st.setInt(4, income.getIdUsers());
            
            int i = st.executeUpdate();
    	}catch(Exception e) {}
    }
    
    public void writeInDataBase(Expenses expense) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT MAX(idExpenses)+1 FROM expenses");
            ResultSet rs = pst.executeQuery();
            int userExpenses = 0;
            while(rs.next()) {
            	userExpenses = rs.getInt(1);
            }
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO expenses VALUES (?,?,?,?)");
            if(userExpenses!=0) {
            	st.setInt(1, userExpenses);
            }
            else {
            	st.setInt(1, 1);
            }
            st.setString(2, expense.getName());
            st.setDouble(3, expense.getAmount());
            st.setInt(4, expense.getIdUsers());
            
            int i = st.executeUpdate();
    	}catch(Exception e) {}
    }
    
    public void writeInDataBase(Savings saving) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT MAX(idSavings)+1 FROM savings");
            ResultSet rs = pst.executeQuery();
            int userSavings = 0;
            while(rs.next()) {
            	userSavings = rs.getInt(1);
            }
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO savings VALUES (?,?,?,?)");
            if(userSavings!=0) {
            	st.setInt(1, userSavings);
            }
            else {
            	st.setInt(1, 1);
            }
            st.setString(2, saving.getName());
            st.setDouble(3, saving.getAmount());
            st.setInt(4, saving.getIdUsers());
            
            int i = st.executeUpdate();
    	}catch(Exception e) {}
    }
    
    public boolean searchInDataBase(String email,String password) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT firstName,lastName FROM users WHERE email = ? AND password = ?");
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
            	return true;
            }
            return false;
    	}catch(Exception e) {
    		return false;
    	}
    }
    
    public double getTotalIncomes(String email) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT SUM(amount) FROM incomes WHERE (SELECT idUsers from users where email = ?) = idUsers");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            double totalIncomes = 0;
            if(rs.next()) {
            	totalIncomes = rs.getDouble(1);
            }
            return totalIncomes;
    	}catch(Exception e) {
    		return 0;
    	}
    }

    public double getTotalExpenses(String email) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT SUM(amount) FROM expenses WHERE (SELECT idUsers from users where email = ?) = idUsers");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            double totalExpenses = 0;
            if(rs.next()) {
            	totalExpenses = rs.getDouble(1);
            }
            return totalExpenses;
    	}catch(Exception e) {
    		return 0;
    	}
    }
    
    public double getTotalSavings(String email) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT SUM(value) FROM savings WHERE (SELECT idUsers from users where email = ?) = idUsers");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            double totalSavings = 0;
            if(rs.next()) {
            	totalSavings = rs.getDouble(1);
            }
            return totalSavings;
    	}catch(Exception e) {
    		return 0;
    	}
    }
    
    public String getFirstName(String email) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT firstName FROM users WHERE email = ?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            String firstName = "";
            if(rs.next()) {
            	firstName = rs.getString(1);
            }
           return firstName;
    	}catch(Exception e) {
    		return "";
    	}
    }
    
    public String getLastName(String email) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT lastName from users where email = ?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            String lastName = "";
            if(rs.next()) {
            	lastName = rs.getString(1);
            }
           return lastName;
    	}catch(Exception e) {
    		return "";
    	}
    }
    
    public int getIdUsers(String email) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            PreparedStatement pst = conn.prepareStatement("SELECT idUsers from users where email = ?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            int idUsers = 0;
            if(rs.next()) {
            	idUsers = rs.getInt(1);
            }
           return idUsers;
    	}catch(Exception e) {
    		return 0;
    	}
    }
    
    public String getUpdate(String email) {
    	try {
    		String database = "jdbc:mysql://localhost:3306/wspend";
            conn = DriverManager.getConnection(database, "root", "Poligrafie123!");
            String output;
            output="<head>\r\n" + 
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
            		"    <link rel=\"stylesheet\" href=\"Front_End/styles/configdata.css\">\r\n" + 
            		"    <link rel=\"stylesheet\" href=\"Front_End/styles/update.css\">\r\n" +
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
            		"                        <a class=\"nav-link\" href=\"Front_End/sources/team.html\">Team</a>\r\n" + 
            		"                    </li>\r\n" + 
            		"                    <li class=\"nav-item\">\r\n" + 
            		"                        <a class=\"nav-link\" href=\"#\">Features</a>\r\n" + 
            		"                    </li>\r\n" + 
            		"                    <li class=\"nav-item\">\r\n" + 
            		"                        <a class=\"nav-link\" href=\"Front_End/sources/pricing.html\">Pricing</a>\r\n" + 
            		"                    </li>\r\n" + 
            		"                    <li class=\"nav-item\">\r\n" + 
            		"                        <a class=\"nav-link\" href=\"#\">Contact</a>\r\n" + 
            		"                    </li>\r\n" + 
            		"                </ul>\r\n" + 
            		"            </div>\r\n" + 
            		"        </nav>\r\n" + 
            		"    </header>\r\n" + 
            		"\r\n" + 
            		"    <main>\r\n" + 
            		"       <div id=\"container\">\r\n" + 
            		"           <div id=\"incomes\">";
            PreparedStatement pst1 = conn.prepareStatement("SELECT * from incomes where (SELECT idUsers from users where email = ?) = idUsers");
            pst1.setString(1, email);
            ResultSet rs1 = pst1.executeQuery();
            while(rs1.next()) {
            	output+="<h1>"+rs1.getString("name")+"</h1>"+"<h2>"+rs1.getDouble("amount")+"</h2>";
            }
            output+="</div>\r\n" + 
            		"           <div id=\"expenses\">";
            PreparedStatement pst2 = conn.prepareStatement("SELECT * from expenses where (SELECT idUsers from users where email = ?) = idUsers");
            pst2.setString(1, email);
            ResultSet rs2 = pst2.executeQuery();
            while(rs2.next()) {
            	output+="<h1>"+rs2.getString("name")+"</h1>"+"<h2>"+rs2.getDouble("amount")+"</h2>";
            }
            output+="</div>\r\n" + 
            		"           <div id=\"savings\">";
            PreparedStatement pst3 = conn.prepareStatement("SELECT * from savings where (SELECT idUsers from users where email = ?) = idUsers");
            pst3.setString(1, email);
            ResultSet rs3 = pst3.executeQuery();
            while(rs3.next()) {
            	output+="<h1>"+rs3.getString("name")+"</h1>"+"<h2>"+rs3.getDouble("value")+"</h2>";
            }
            output+=" </div>\r\n" + 
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
            		"\r\n";
            return output;
    	}catch(Exception e) {
    		return "<html>error</html>";
    	}
    	
    }
}
