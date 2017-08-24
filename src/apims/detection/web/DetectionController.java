package apims.detection.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apims.detection.service.DetectionService;
import apims.util.LoginManager;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class DetectionController {


	@Resource
	private DetectionService service;

	private String goLogin = "redirect:/login.do";	// go : login.do

	@RequestMapping("/detection/jumin.do")
	public String jumin(HttpServletRequest request,
						HttpServletResponse response,
						@RequestParam HashMap<String, Object> pMap,
						ModelMap model){
		try {
			List<EgovMap> list = service.getJuminList(pMap);
			model.put("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(!LoginManager.goDirect(request)){
			return goLogin;
		}

		return "detection/jumin";
	}

	@RequestMapping("/detection/phon.do")
	public String phon(HttpServletRequest request,
						HttpServletResponse response,
						@RequestParam HashMap<String, Object> pMap,
						ModelMap model){
		try {
			List<EgovMap> list = service.getPhonList(pMap);
			model.put("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(!LoginManager.goDirect(request)){
			return goLogin;
		}

		return "detection/phon";
	}


}
