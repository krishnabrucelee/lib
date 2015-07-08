/**
 *
 */
package com.java.library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.library.model.entity.Member;
import com.java.library.utils.DbUtil;

/**
 * @author Assistanz
 *
 */
public class MemberDaoImpl implements MemberDao {

    /**
     * A connection (session) with a specific database.
     */
    private Connection connection = DbUtil.getConnection();

    /**
     * Constant Index value.
     */
    public static final Integer ISDELETED = 3, ID = 4;
    /**
     * List All members from Database.
     *
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
     * Update Member by its id.
     *
     * @param memberId id
     * @return updated details
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
                preparedStatement.setBoolean(ISDELETED, false);
                preparedStatement.setInt(ID, member.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 2;
        }
        return 1;
    }

    /**
     * Delete member by its id.
     *
     * @param memberId id
     * @return memberId
     */
    public Integer deleteMember(Integer memberId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set isDeleted = ? where userid = ? ");
            // Parameters start with 1
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, memberId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberId;
    }

    /**
     * Add Member to database.
     *
     * @param name member name
     * @param email member email
     * @param id member id
     * @return 0/1
     */
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
                preparedStatement.setBoolean(ISDELETED, false);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 2;
        }
        return 1;

    }

    /**
     * Search member by its id.
     *
     * @param memberId id
     * @return list of members
     */
    public List<Member> searchMemberById(Integer memberId) {
        List<Member> searchMemberEntities = new ArrayList<Member>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, memberId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Member searchEntity = new Member();
                searchEntity.setId(rs.getInt("userId"));
                searchEntity.setName(rs.getString("firstname"));
                searchEntity.setEmail(rs.getString("email"));

                searchMemberEntities.add(searchEntity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchMemberEntities;
    }
}
