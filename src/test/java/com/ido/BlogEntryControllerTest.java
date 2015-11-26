package com.ido;

import com.ido.core.entities.BlogEntry;
import com.ido.core.services.BlogEntryService;
import com.ido.rest.mvc.BlogEntryController;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Ido Zilberberg on 11/25/2015.
 */
public class BlogEntryControllerTest {

  @InjectMocks
  private BlogEntryController controller;

  @Mock
  BlogEntryService service;

  private MockMvc mockMvc;



  @Before
  public void setup() {

    // Necessary for mocking the controller
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


  }

  @Test
  public void test() throws Exception {

    // print() dumps to console what the mock mvc does - useful!
    mockMvc.perform(get("/test")).andDo(print());

  }


  @Test
  @Ignore
  public void testPost() throws Exception {

    // print() dumps to console what the mock mvc does - useful!
    mockMvc.perform(post("/test2")
        .content("{\"title\":\"FromMock\"}") // if got HTTP/400 (Bad Request), check JSON formatting!
        .contentType(MediaType.APPLICATION_JSON)) // without it, getting HTTP/415 (HttpMediaTypeNotSupportedException)
        .andExpect(jsonPath("$.title", is("FromMock"))) // $ is root
        .andDo(print());

  }



  @Test
  public void getExistingBlogEntry() throws Exception {
    BlogEntry entry = new BlogEntry();
    entry.setId(1L);
    entry.setTitle("HelloWorld");

    when(service.find(1L)).thenReturn(entry);

    mockMvc
        .perform(get("/rest/blog-entries/1"))
        .andDo(print())
        .andExpect(jsonPath("$.title", is(entry.getTitle())))
        // grab href element from all the links
        .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
        .andExpect(status().isOk());
  }

  @Test
  public void getNonExistingBlogEntry() throws Exception {

    when(service.find(1L)).thenReturn(null);

    mockMvc
        .perform(get("/rest/blog-entries/1"))
        .andExpect(status().isNotFound());
  }

}
