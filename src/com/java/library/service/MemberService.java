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
     * @param member
     *            id
     * @return updated details
     */
    String updateMember(Member member);

    /**
     * Delete Member.
     *
     * @param member
     *            id
     * @return delete member details.
     */
    String deleteMember(Member member);

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
     * @param member
     *            id
     * @return search details
     */
    List<Member> searchMember(Member member);



}
