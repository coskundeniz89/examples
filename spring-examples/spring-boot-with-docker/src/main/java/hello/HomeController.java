package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
  @RequestMapping("/")
  public String home(){
    return "Hello World!".toLowerCase(java.util.Locale.ENGLISH);
  }
}
