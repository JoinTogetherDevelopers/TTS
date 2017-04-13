package org.dorageecorp;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * SiteMesh 의 데코레이터 등록을 위한 필터
 *
 * @author soup
 */
public class TTSSiteMeshFilter extends ConfigurableSiteMeshFilter {

    /**
     * Decorators
     */
    public static final String WEB_INF_VIEWS_LAYOUT_MAIN_LAYOUT_JSP = "/WEB-INF/views/layout/mainLayout.jsp";
    public static final String WEB_INF_VIEWS_LAYOUT_PROJECT_LAYOUT_JSP = "/WEB-INF/views/layout/projectLayout.jsp";

    /**
     * Path
     */
    public static final String CONSOLE = "/console/*";
    public static final String REGISTER = "/register";
    public static final String NONE_PROJECT = "/noneProject";
    public static final String KCMSUS = "/kcmsus/**";
    public static final String PROJECT = "/project/**";
    public static final String MAIN = "/main";
    public static final String HOME = "/";

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath(HOME, WEB_INF_VIEWS_LAYOUT_MAIN_LAYOUT_JSP);
        builder.addDecoratorPath(MAIN, WEB_INF_VIEWS_LAYOUT_PROJECT_LAYOUT_JSP);
        builder.addDecoratorPath(PROJECT, WEB_INF_VIEWS_LAYOUT_PROJECT_LAYOUT_JSP);
        builder.addDecoratorPath(KCMSUS, WEB_INF_VIEWS_LAYOUT_PROJECT_LAYOUT_JSP);
        builder.addExcludedPath(NONE_PROJECT);
        builder.addExcludedPath(REGISTER);
        builder.addExcludedPath(CONSOLE);
    }

}
