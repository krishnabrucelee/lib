/**
 * 
 */
package com.java.library.service;


import com.java.library.model.dao.MemberDao;

/**
 * @author Assistanz
 *
 */
public class MemberServiceImpl implements MemberService {

	/**
	 * List all Member from id
	 */
	public String getMemberList() {
		MemberDao dao = new MemberDao();
		dao.getAllMembers();
		return null;	
	}

	/**
	 * Update member from its id
	 */
	public String updateMember(Integer memberId) {
		MemberDao dao = new MemberDao();
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
	 * Delete member from its id
	 */
	public String deleteMember(Integer memberId) {
		MemberDao dao = new MemberDao();
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
	 * Add member by its id
	 */
	public String addMember(String name, String email, String id) {
		MemberDao dao = new MemberDao();
		Integer add = dao.addUser(name, email, id);
		if (add == 0) {
			return "Member Already exits!!";
		} else if (add == 1) {
			return "Member Sucessfully Added!!";
		} else {
			return "Internal Error!!";
		}

	}

	/**
	 * Search Member by id
	 */
	public String SearchMember(Integer memberId) {
		MemberDao dao = new MemberDao();
		dao.SearchMemberById(memberId);
		return null;
		
	}
}
