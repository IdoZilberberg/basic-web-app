package com.ido.core.services.util;

import com.ido.core.entities.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ido Zilberberg on 11/26/2015.
 *
 * Container for Blog entities (it is not an entity). Adds metadata
 */
public class BlogList {

  private List<Blog> blogs = new ArrayList<>();

  public List<Blog> getBlogs() {
    return blogs;
  }

  public void setBlogs(List<Blog> blogs) {
    this.blogs = blogs;
  }
}
