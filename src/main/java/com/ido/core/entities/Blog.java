package com.ido.core.entities;

/**
 * Created by Ido Zilberberg on 11/26/2015.
 */
public class Blog {

  private Long id;
  private String title;
  private Account owner;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Account getOwner() {
    return owner;
  }

  public void setOwner(Account owner) {
    this.owner = owner;
  }
}
