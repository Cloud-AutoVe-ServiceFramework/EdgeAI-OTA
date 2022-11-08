package kr.re.etri.advcloud.configuration;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import kr.re.etri.advcloud.common.annotation.Model;

public abstract class AbstractDatasourceConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractDatasourceConfiguration.class);
	protected static final String BASE_PACKAGE = "kr.re.etri.advcloud";
	
	protected Class<?>[] findModel() {
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AnnotationTypeFilter(Model.class));

		Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents(BASE_PACKAGE);
		Class<?>[] classes = new Class[beanDefinitions.size()];

		int i = 0;
		for (BeanDefinition beanDef : beanDefinitions) {
			try {
				Class<?> cl = Class.forName(beanDef.getBeanClassName());
				classes[i] = cl;

				i++;
			} catch (Exception e) {
				logger.error("Got exception: " + e.getMessage());
			}
		}

		return classes;
	}
	
}
