package com.ido;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Michal on 11/24/2015.
 */
@Controller
public class TestController {
  @RequestMapping("/test")
  public String test()  {
    return "view";
  }
}
