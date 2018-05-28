package zz.test.ze1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService
{

  @Value("${zeSignature}")
  private String zeSignature;

  public String getSignature()
  {
    return "Proudly handcrafted by ZZ ! :)";
  }

}
