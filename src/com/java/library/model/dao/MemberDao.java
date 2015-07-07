/**
 * 
 */
package com.java.library.model.dao;

import com.java.library.model.entity.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.java.library.utils.DbUtil;

/**
 * @author Assistanz
 *
 */
public class MemberDao {
	
	private Connection connection;

	public MemberDao() {
		connection = DbUtil.getConnection();
	}

	/**
	 * List All members from Database
	 * @return members
	 */
	public List<Member> getAllMembers() {
		List<Member> members = new ArrayList<Member>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users where isDeleted <> 1 ");
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return members;
	}

	/**
	 * Update Member 
	 * @param memberId
	 * @return
	 */
	public Integer updateMember(Integer memberId) {
		Member member = new Member();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users where email='" + member.getEmail() + "'");

			if (rs.next()) {

				return 0;
			} else {
				PreparedStatement preparedStatement = connection
						.prepareStatement("update users set firstname=?, email=?, isDeleted=?" + "where userid=?");
				// Parameters start with 1
				preparedStatement.setString(1, member.getName());
				preparedStatement.setString(2, member.getEmail());
				preparedStatement.setBoolean(3, false);
				preparedStatement.setInt(4, member.getId());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
		}
		return 1;
	}

	/**
	 * Add member 
	 * @param memberId
	 * @return
	 */
	public Integer deleteMember(Integer memberId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update users set isDeleted = ? where userid = ? ");
			// Parameters start with 1
			preparedStatement.setBoolean(1, true);
			preparedStatement.setInt(2, memberId);
			preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberId;
	}

	public Integer addUser(String name, String email, String id) {
		Member member = new Member();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users where email='" + email + "'");

			if (rs.next()) {
				return 0;
			} else {

				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into users(firstname,email,isDeleted) values (?, ?, ? )");
				// Parameters start with 1
				preparedStatement.setString(1, member.getName());
				preparedStatement.setString(2, member.getEmail());
				preparedStatement.setBoolean(3, false);
				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
		}
		return 1;

	}

}
