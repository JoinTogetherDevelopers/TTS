package org.dorageecorp;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Lazy
@EnableTransactionManagement
@MapperScan(basePackages = { "org.dorageecorp.activity.dao", "org.dorageecorp.board.dao", "org.dorageecorp.job.dao",
		"org.dorageecorp.main.dao", "org.dorageecorp.project.dao", "org.dorageecorp.user.dao" })
@Configuration
public class TTSMybatisConfig {

	private static final String PATH_MAPPER = "classpath:/mapper/**/*.xml";
	private static final String TYPE_PACKAGE = "org.dorageecorp";

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setTypeAliasesPackage(TYPE_PACKAGE);
		sessionFactory.setMapperLocations(resolver.getResources(PATH_MAPPER));
		return sessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sqlSessionTemplate;
	}

}
