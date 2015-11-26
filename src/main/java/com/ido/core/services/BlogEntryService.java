package com.ido.core.services;

import com.ido.core.entities.BlogEntry;

/**
 * Created by Ido Zilberberg on 11/25/2015.
 */
public interface BlogEntryService {

  public BlogEntry find(final Long id);
}
