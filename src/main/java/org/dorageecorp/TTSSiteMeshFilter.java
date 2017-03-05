package org.dorageecorp;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * SiteMesh 의 데코레이터 등록을 위한 필터
 * 
 * @author soup
 *
 */
public class TTSSiteMeshFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/", "/WEB-INF/views/layout/mainLayout.jsp");
		builder.addDecoratorPath("/main", "/WEB-INF/views/layout/projectLayout.jsp");
		builder.addDecoratorPath("/project/**", "/WEB-INF/views/layout/projectLayout.jsp");
		builder.addDecoratorPath("/kcmsus/**", "/WEB-INF/views/layout/projectLayout.jsp");
		builder.addExcludedPath("/noneProject");
		builder.addExcludedPath("/register");
	}

}
