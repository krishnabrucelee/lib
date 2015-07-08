/**
 *
 */
package com.java.library.model.entity;

/**
 * @author Assistanz Entity Class for Member
 */
public class Member {

    /**
     * Member id.
     */
    private Integer id;

    /**
     * Member name.
     */
    private String name;

    /**
     * Member email.
     */
    private String email;

    /**
     * Member Delete by id.
     */
    private Boolean isDeleted;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted
     *            the isDeleted to set
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", email=" + email + ", isDeleted=" + isDeleted + "]";
    }

}
