package ticketBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Train extends TagSupport {
	String from;
	String to;
	


	public String getFrom() {
		return from;
	}



	public void setFrom(String from) {
		this.from = from;
	}



	public String getTo() {
		return to;
	}



	public void setTo(String to) {
		this.to = to;
	}



	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			Class.forName("org.postgresql.Driver");

			// Establish a database connection
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres?user=postgres&password=pff123");

			String sqlQuery = "SELECT trn_name FROM train_data WHERE trn_start = ? AND trn_end = ?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, from); // Set the first parameter
			ps.setString(2, to);   // Set the second parameter
			ResultSet rs = ps.executeQuery();


			// Generate the HTML for the dropdown
			out.println("<select>");
			while (rs.next()) {
				String columnValue = rs.getString("trn_name");
				out.println("<option>" + columnValue + "</option>");
			}
			out.println("</select>");

			// Close database resources
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
}