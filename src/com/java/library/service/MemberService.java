/**
 * 
 */
package com.java.library.service;

/**
 * @author Assistanz
 *
 */
public interface MemberService {

	/*Get Members List*/
	public String getMemberList();

	/*Update Member*/
	public String updateMember(Integer memberId);

	/*Delete Member*/
	public String deleteMember(Integer memberId);

	/*Add member*/
	public String addMember(String name, String email, String id);
}
