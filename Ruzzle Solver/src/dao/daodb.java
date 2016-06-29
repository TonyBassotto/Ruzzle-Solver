package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class daodb {
	Connection c=daourl.getInstance().getConnection();

	public Collection<String> dizionario() {
		LinkedList<String>lista=new LinkedList<String>();
		String sql="select nome from parola";
		try {
			PreparedStatement st= c.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				lista.add(rs.getString("nome"));
			}
			rs.close();
			st.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return lista;
	}
	
}
