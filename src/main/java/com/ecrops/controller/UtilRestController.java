package com.ecrops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecrops.config.RegularExpressionclassMethod;
import com.ecrops.entity.VAADetails;
import com.ecrops.entity.VillSecListMaoIntf;
import com.ecrops.repo.VAADetailsRepo;
import com.ecrops.repo.VillSecListMaoIntfRepo;

@RestController

@RequestMapping("/util")
public class UtilRestController {
@Autowired VillSecListMaoIntfRepo villSecListMaoIntfRepo;
@Autowired VAADetailsRepo vAADetailsRepo;
	
	@GetMapping("/villseclistt")
	List<VillSecListMaoIntf> getList(@RequestParam ("dcode")String dcode, @RequestParam ("mcode")String mcode) {

//		String[] season = cropyear.split("@");
//		String seasonType = season[0];
//		Integer seasonYear = Integer.parseInt(season[1]);
//		//System.out.println("seasonType=>" + seasonType);
//		//System.out.println("seasonYear=>" + seasonYear);

		Integer ddcode = Integer.parseInt(dcode);
		Integer mmcode = Integer.parseInt(mcode);

	

		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();

		System.out.println("dcode------------->"+ddcode);
		
	    boolean val= regexpressionmethod.districtCode(ddcode.toString());
		boolean val2= regexpressionmethod.year(mmcode.toString());
		
	System.out.println("val-------------->"+val);
	System.out.println("val2-------------->"+val2);
	
	if(val && val2 ) {
		List<VillSecListMaoIntf> listt = villSecListMaoIntfRepo.getVillsecList(ddcode, mmcode);
		
		System.out.println("list size=>" + listt.size());
		System.out.println("list =>" + listt.toString());
		return listt;
	   }
	
	return null; 
	}



//--------------------------------Rep_VaaDetails-----------------------------------//

@GetMapping("/vaadetails1")
List<VAADetails> getVAADetails(@RequestParam ("mcode")String mcode) {
	String mmcode = (String)mcode;
	RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();
	boolean val2= regexpressionmethod.year(mmcode.toString());
System.out.println("val2-------------->"+val2);

if( val2 ) {
	List<VAADetails> listt = vAADetailsRepo.getVaaDet( mmcode);
	System.out.println("list size=>" + listt.size());
	System.out.println("list =>" + listt.toString());
	return listt;
   }
return null; 
}


}
