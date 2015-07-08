/**
 *
 */
package com.java.library.service;

/**
 * @author Assistanz
 */
public interface MemberService {

    /**
     * Get all member details.
     * @return member details
     */
     String getMemberList();

     /**
      * Update member by its id.
      * @param memberId id
      * @return updated details
      */
     String updateMember(Integer memberId);

    /**
     * Delete Member.
     * @param memberId id
     * @return delete member details.
     */
     String deleteMember(Integer memberId);

    /**
     * Add Member details in database.
     * @param name member name.
     * @param email member email
     * @param id member id
     * @return added member details
     */
     String addMember(String name, String email, String id);

     /**
      * Search member by its id.
      * @param memberId id
      * @return search details
      */
     String searchMember(Integer memberId);
}
