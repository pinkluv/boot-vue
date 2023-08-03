package kr.co.trito.api.sample.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.trito.api.sample.dto.EquipMasDto;
import kr.co.trito.api.sample.dto.ParamsDto;
import kr.co.trito.api.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sample")
public class SampleController {

	
	private final SampleService sampleService; 
	
	
	@GetMapping("/test")
	public List<EquipMasDto> test() {
		log.info("--------- message test ---------");
		
		return sampleService.selectAllEquipMas();		
	}
	
    @GetMapping("/PathVariable/{type}/{id}")
    @ResponseBody	
    public String pathVariableTest(@PathVariable Integer id, @PathVariable String type
    ) {
        //type : member, id : 1
    	log.info("type : {}", type);
    	log.info("id : {}", id);
        return "success";
    }	
	
    
    @GetMapping("/RequestParam")
    @ResponseBody
    public String requestParam(
            @RequestParam(required = false, value = "id") Integer memberId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) boolean active
    ) {
    	log.info("memberId : {}", memberId);
    	log.info("name : {}", name);    	
    	log.info("description : {}", description);    	
    	log.info("address : {}", address);    	
    	log.info("active : {}", active);    	
        return "success";
    }
    
    
    @GetMapping("/RequestParamMap")
    @ResponseBody    
    public String requestParamMap(@RequestParam Map<String, Object> allParameters) {
    	log.info("AllParameters : {}", allParameters.toString());    	
        return "success";
    }    
    
    
    @PostMapping("/RequestParamArr")
    @ResponseBody    
    public String requestParamArr(@RequestParam(required = false, value="arr[]") List<Integer> arr) {    	
    	log.info("List : {}", arr.toString()); 
        return "success";
    }    
    
    @PostMapping("/ModelAttribute")
    @ResponseBody String modelAttribute(@ModelAttribute ParamsDto dto) {
    	log.info("@ModelAttribute - ParamsDto : {}", dto);
    	return "success"; 
    }
   
    //Json이나 Xml로 전송된 파라미터를 매핑할 때 사용하는 어노테이션
    @PostMapping("/RequestBody")
    @ResponseBody String requestBody(@RequestBody  ParamsDto dto) {
    	log.info("@RequestBody - ParamsDto : {}", dto);
    	return "success"; 
    }    
    
    @PostMapping("/RequestBodyList")
    @ResponseBody String requestBodyList(@RequestBody  List<ParamsDto> list) {
    	log.info("@RequestBodyList - List : {}", list);
    	return "success"; 
    }     
}

