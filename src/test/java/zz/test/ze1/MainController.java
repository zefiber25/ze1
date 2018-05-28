package zz.test.ze1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController
{
  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index()
  {
    return userService.getSignature();
  }

}
