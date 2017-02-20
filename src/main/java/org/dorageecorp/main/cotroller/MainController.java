package org.dorageecorp.main.cotroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dorageecorp.main.bo.MainBO;
import org.dorageecorp.main.model.Project;
import org.dorageecorp.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Slf4j
public class MainController {

	@Autowired
	private MainBO mainBO;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("main");
		
		String userId = CookieUtil.getCookieValue(request, "userId");

		try {
			List<Project> totalProject = mainBO.getTotalProjects();
			List<Project> myProject = mainBO.getMyProjects(userId);

			mav.addObject("totalProject", totalProject);
			mav.addObject("myProject", myProject);
		} catch (Exception e) {
//			log.error("Main Error", e);
		}

		return mav;
	}
}