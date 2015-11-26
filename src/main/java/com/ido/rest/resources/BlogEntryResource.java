package com.ido.rest.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Ido Zilberberg on 11/25/2015.
 *
 * This is the DTO, it contains the public attributes (visible to client-side)
 *
 */
public class BlogEntryResource extends ResourceSupport {
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
