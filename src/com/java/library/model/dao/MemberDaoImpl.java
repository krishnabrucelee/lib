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
            ResultSet rs = statement.executeQuery("select * from users where isDeleted <> 1");
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
     * @param member
     *            id
     * @return updated details
     */
    public Integer updateMember(Member member) {
          try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users where email='" + member.getEmail() + "'");

            if (rs.next()) {

                return 0;
            } else {
                PreparedStatement preparedStatement = connection
                        .prepareStatement("update users set name=?, email=?, isDeleted=?  where id=?");
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
     * @param memberId
     *            id
     * @return memberId
     */
    public Integer deleteMember(Member memberId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set isDeleted = ? where id = ? ");
            // Parameters start with 1
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, memberId.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 2;
        }
        return 1;
    }

    /**
     * Add Member to database.
     *
     * @param member
     *            member details
     * @return 0/1
     */
    public Integer addMember(Member member) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users where email='" + member.getEmail() + "'");

            if (rs.next()) {
                return 0;
            } else {

                PreparedStatement preparedStatement = connection
                        .prepareStatement("insert into users(name,email,isDeleted) values (?, ?, ? )");
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
     * @param memberId
     *            id
     * @return list of members
     */
    public List<Member> searchMemberById(Integer memberId) {
        List<Member> searchMember = new ArrayList<Member>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id=?");
            preparedStatement.setInt(1, memberId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Member search = new Member();
                search.setId(rs.getInt("id"));
                search.setName(rs.getString("name"));
                search.setEmail(rs.getString("email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchMember;
    }

    /**
     * Get member Details from it id.
     * @param memberId id
     * @return member details
     */
    public Member getMemberById(Integer memberId) {
        Member member = new Member();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id=?");
            preparedStatement.setInt(1, memberId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return member;
    }

    @Override
    public List<Member> searchMemberById(Member memberId) {
        // TODO Auto-generated method stub
        return null;
    }

}
