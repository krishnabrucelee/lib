/**
 *
 */
package com.java.library.service;

import java.util.List;

import com.java.library.model.dao.MemberDao;
import com.java.library.model.dao.MemberDaoImpl;
import com.java.library.model.entity.Member;

/**
 * @author Assistanz
 */
public class MemberServiceImpl implements MemberService {
    
    /**
     * List all Member from id.
     */
    @Override
    public List<Member> getMemberList() {
        MemberDao dao = new MemberDaoImpl();
        return dao.getAllMembers();
        
    }
    
    /**
     * Update member from its id.
     */
    @Override
    public String updateMember(Integer memberId) {
        MemberDao dao = new MemberDaoImpl();
        Integer update = dao.updateMember(memberId);
        
        if (update == 0) {
            return "Member Already exits!!";
        } else if (update == 1) {
            return "Member Sucessfully updated!!";
        } else {
            return "Internal Error!!";
        }
        
    }
    
    /**
     * Delete member from its id.
     */
    @Override
    public String deleteMember(Integer memberId) {
        MemberDao dao = new MemberDaoImpl();
        Integer delete = dao.deleteMember(memberId);
        if (delete == 0) {
            return "Member Not Deleted!!";
        } else if (delete == 1) {
            return "Member Sucessfully Deleted!!";
        } else {
            return "Internal Error!!";
        }
    }
    
    /**
     * Add member by its id.
     */
    @Override
    public String addMember(Member member) {
        MemberDao dao = new MemberDaoImpl();
        Integer add = dao.addMember(member);
        if (add == 0) {
            return "Member Already exits!!";
        } else if (add == 1) {
            return "Member Sucessfully Added!!";
        } else {
            return "Internal Error!!";
        }
        
    }
    
    /**
     * Search Member by id.
     */
    @Override
    public String searchMember(Integer memberId) {
        MemberDao dao = new MemberDaoImpl();
        dao.searchMemberById(memberId);
        return null;
        
    }
}
