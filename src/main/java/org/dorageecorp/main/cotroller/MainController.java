package org.dorageecorp.main.cotroller;

import lombok.extern.slf4j.Slf4j;
import org.dorageecorp.main.bo.MainBO;
import org.dorageecorp.main.model.Project;
import org.dorageecorp.user.model.User;
import org.dorageecorp.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private MainBO mainBO;

    @GetMapping(value = "/main")
    public ModelAndView main(HttpServletRequest request, Authentication authentication) {
        ModelAndView mav = new ModelAndView("main");

        // String userId = CookieUtil.getCookieValue(request, "userId");
        User currentUser = (User) authentication.getPrincipal();
        String userId = currentUser.getUserId();
        log.debug("login id : {} ", userId);

        try {
            List<Project> totalProject = mainBO.getTotalProjects();

            int seq = 1;
            for (Project project : totalProject) {
                project.setSequence(seq++);
            }

            List<Project> myProject = mainBO.getMyProjects(userId);

            log.debug("Total projects : {} ", totalProject.size());
            log.debug("Total my projects : {} ", myProject.size());

            mav.addObject("totalProject", totalProject);
            mav.addObject("myProject", myProject);
        } catch (Exception e) {
            log.error("Getting project was faild.", e);
        }

        return mav;
    }

}