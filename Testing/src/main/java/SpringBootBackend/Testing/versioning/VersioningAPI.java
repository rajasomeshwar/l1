package SpringBootBackend.Testing.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningAPI {
  @GetMapping("v1/person")
  public PersonV1 GetPersonWithDifUrl()
  {
	  return new PersonV1("Rajasomeshwar Bitla");
  }
  // get more detailss
  @GetMapping("v2/person")
  public PersonV2 GetPersonWithDifUrl1()
  {
	  return new PersonV2(new Name("Rajasomeshwar"," Bitla"));
  }
  @GetMapping(path="/person", params="version=1")
  public PersonV1 GetPersonWithDifParams()
  {
	  return new PersonV1("Rajasomeshwar Bitla");
  }
  // get more detailss
  @GetMapping(path="/person",params="version=2")
  public PersonV2 GetPersonWithDifParams2()
  {
	  return new PersonV2(new Name("Rajasomeshwar"," Bitla"));
  }
   @GetMapping(path="/person/headers",headers="X-API-VERSION=1")
   public PersonV1 GetPersonWithHeader()
   {
	   return new PersonV1("Rajasomeshwar bitla");
   }
   @GetMapping(path="/person/headers",headers="X-API-VERSION=2")
   public PersonV2 GetPersonWithHeaderDif()
   {
	   return new PersonV2(new Name("Rajasomeshwar"," Bitla"));
   }
   @GetMapping(path="/person/accept",produces="application/vnd.company.app-v1+json")
   public PersonV1 GetPersonWithApects()
   {
	   return new PersonV1("Rajasomeshwar bitla");
   }
   @GetMapping(path="/person/accept",produces="application/vnd.company.app-v2+json")
   public PersonV2 GetPersonWithApectsD()
   {
	   return new PersonV2(new Name("Rajasomeshwar"," Bitla"));
   }
}
