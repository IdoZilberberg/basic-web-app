package com.ido.core.services.util;

import com.ido.core.entities.BlogEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ido Zilberberg on 11/26/2015.
 *
 * Container for BlogEntry entities (it is not an entity). Adds metadata
 */
public class BlogEntryList {

  private List<BlogEntry> entries = new ArrayList<>();
  private Long blogId;

  public List<BlogEntry> getEntries() {
    return entries;
  }

  public void setEntries(List<BlogEntry> entries) {
    this.entries = entries;
  }

  public Long getBlogId() {
    return blogId;
  }

  public void setBlogId(Long blogId) {
    this.blogId = blogId;
  }
}
