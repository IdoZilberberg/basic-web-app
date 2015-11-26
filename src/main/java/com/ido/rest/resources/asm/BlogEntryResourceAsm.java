package com.ido.rest.resources.asm;

import com.ido.core.entities.BlogEntry;
import com.ido.rest.mvc.BlogEntryController;
import com.ido.rest.resources.BlogEntryResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Ido Zilberberg on 11/25/2015.
 * Following this tutorial: https://www.youtube.com/watch?v=wmbS20Nnuq0&list=PL4gCdGOq-cxJrbRMWjrIvGhYqQO1tvYyX&index=4
 * <p>
 * Converter from the JPA (model) object to the Resource (DTO) object
 */
public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

  public BlogEntryResourceAsm() {
    super(BlogEntryController.class, BlogEntryResource.class);

  }

  @Override
  public BlogEntryResource toResource(BlogEntry blogEntry) {
    BlogEntryResource res = new BlogEntryResource();
    res.setTitle(blogEntry.getTitle());

    // HATEOAS link builder - ControllerLinkBuilder.linkTo()
    // For HATEOAS explanation see https://spring.io/understanding/HATEOAS

    // option 1
    Link link1 = linkTo(
        methodOn(BlogEntryController.class)
            // this doesn't call the method, just uses the @RequestMapping to build the link
            .getBlogEntry(blogEntry.getId()))
        .withSelfRel();

    // option 2 - can generate the link using the class-level @RequestMapping
    Link link2 = linkTo(BlogEntryController.class)
        .slash(blogEntry.getId()) // append "/1"
        .withSelfRel();

    res.add(link2);
    return res;
  }
}
