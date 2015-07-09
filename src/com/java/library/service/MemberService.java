/**
 *
 */
package com.java.library.service;

import java.util.List;

import com.java.library.model.entity.Member;

/**
 * @author Assistanz
 */
public interface MemberService {
    
    /**
     * Get all member details.
     *
     * @return member details
     */
    List<Member> getMemberList();
    
    /**
     * Update member by its id.
     *
     * @param memberId
     *            id
     * @return updated details
     */
    String updateMember(Integer memberId);
    
    /**
     * Delete Member.
     *
     * @param memberId
     *            id
     * @return delete member details.
     */
    String deleteMember(Integer memberId);
    
    /**
     * Add member details.
     * 
     * @param member
     *            member details
     * @return member
     */
    String addMember(Member member);
    
    /**
     * Search member by its id.
     *
     * @param memberId
     *            id
     * @return search details
     */
    String searchMember(Integer memberId);
}
