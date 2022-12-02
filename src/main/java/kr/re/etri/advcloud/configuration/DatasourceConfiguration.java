package kr.re.etri.advcloud.configuration;

import javax.sql.DataSource; 

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import kr.re.etri.advcloud.common.annotation.Mapper;

@Configuration
@EnableTransactionManagement
public class DatasourceConfiguration extends AbstractDatasourceConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(DatasourceConfiguration.class);
	
	@Primary
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name="txManager")
	public DataSourceTransactionManager txManager(@Qualifier("dataSource") DataSource dataSource) {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource);
		txManager.setGlobalRollbackOnParticipationFailure(true);
		txManager.setRollbackOnCommitFailure(true);

		return txManager;
	}
	
	@Primary
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource, ApplicationContext applicationContext) {
		// 
		try {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:sqlmap/config/mybatisConfig.xml"));
			sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:sqlmap/sql/db/**/*.xml"));
			sqlSessionFactoryBean.setTypeAliases(findModel());
			//sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
			
			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Primary
	@Bean(name="mapperScanner")
	public MapperScannerConfigurer mapperScanner() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setAnnotationClass(Mapper.class);
		mapperScannerConfigurer.setBasePackage(BASE_PACKAGE);
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

		return mapperScannerConfigurer;
	}

}