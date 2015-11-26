package com.ido.rest.mvc;

import com.ido.core.entities.BlogEntry;
import com.ido.core.services.BlogEntryService;
import com.ido.rest.resources.BlogEntryResource;
import com.ido.rest.resources.asm.BlogEntryResourceAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ido Zilberberg on 11/24/2015.
 */
@Controller
@RequestMapping("/rest/blog-entries") // this is a prefix for all the individual methods' @RequestMapping
public class BlogEntryController {

  private BlogEntryService service;

  public BlogEntryController(BlogEntryService service) {
    this.service = service;
  }

  // Using a path variable
  @RequestMapping(value="/{blogEntryId}", method = RequestMethod.GET)
  public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable final Long blogEntryId) {
    BlogEntry entry = service.find(blogEntryId);
    if( entry != null ) {
      BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);
      return new ResponseEntity<>(res, HttpStatus.OK);
  } else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }








//  @RequestMapping("/test")
//  public ResponseEntity<Object> test()  {
//
//    BlogEntry entry = new BlogEntry();
//    entry.setTitle("Hello");
//
//    return new ResponseEntity<>(entry, HttpStatus.OK);
//  }
//
//  @RequestMapping(value="/test2", method = RequestMethod.POST)
//  public @ResponseBody BlogEntry testPost(@RequestBody BlogEntry entry)  {
//    return entry;
//  }


}
