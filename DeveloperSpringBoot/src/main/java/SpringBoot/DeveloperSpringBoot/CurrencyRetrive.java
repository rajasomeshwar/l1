package SpringBoot.DeveloperSpringBoot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CurrencyRetrive {
	@Autowired
	private CurrencyConfigration cc;
	@RequestMapping("/currency-service")
	 public CurrencyConfigration reterive()
	 {
		 return cc;
	 }

}
