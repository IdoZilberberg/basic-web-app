package com.ido.core.entities;

/**
 * Created by Ido Zilberberg on 11/25/2015.
 * <p>
 * This is a Model (for JPA)
 */
public class BlogEntry {

  private Long id;

  private String title;

  private Blog blog;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Blog getBlog() {
    return blog;
  }

  public void setBlog(Blog blog) {
    this.blog = blog;
  }
}
