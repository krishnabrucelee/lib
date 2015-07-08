/**
 *
 */
package com.java.library.model.entity;

/**
 * @author Assistanz
 */
public class Book {

    /**
     * Book Id.
     */
    private Integer id;

    /**
     * Book Title.
     */
    private String title;

    /**
     * Book author.
     */
    private String author;

    /**
     * Delete by book id.
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     *            the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
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
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isDeleted=" + isDeleted + "]";
    }

}
