package Pwater.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;

import Pwater.Model.Account;

@RestController
public class Home {

	
	public Home(){
		Key key = MacProvider.generateKey();
		String compactJws = Jwts.builder()
		  .setSubject("Joe")
		  .signWith(SignatureAlgorithm.HS512, key)
		  .compact();
		System.out.println(key.toString());
		System.out.println(compactJws);
		//unitTest: assert Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject().equals("Joe");
		System.out.println(Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws));
	}

    @RequestMapping(value = {"/","/Home","/home"}, method = RequestMethod.GET, produces = "application/json")
    public List index() {
    	List account = new Account().GetAll();
  //   	try {

		//     Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);

		//     //OK, we can trust this JWT

		// } catch (SignatureException e) {

		//     //don't trust the JWT!
		// }
    	return account;
    }

}