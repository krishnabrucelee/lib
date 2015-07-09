/**
 *
 */
package com.java.library.model.dao;

import java.util.List;

import com.java.library.model.entity.Member;

/**
 * @author Assistanz
 */
public interface MemberDao {
    
    /**
     * Get Book List.
     *
     * @return list of books
     */
    List<Member> getAllMembers();
    
    /**
     * Update member by its id.
     *
     * @param memberId
     *            id
     * @return updated details
     */
    Integer updateMember(Integer memberId);
    
    /**
     * Delete Member.
     *
     * @param memberId
     *            id
     * @return delete member details.
     */
    Integer deleteMember(Integer memberId);
    
    /**
     * Add member details.
     * 
     * @param member
     *            member details
     * @return member
     */
    Integer addMember(Member member);
    
    /**
     * Search member by its id.
     *
     * @param memberId
     *            id
     * @return search details
     */
    List<Member> searchMemberById(Integer memberId);
    
}
