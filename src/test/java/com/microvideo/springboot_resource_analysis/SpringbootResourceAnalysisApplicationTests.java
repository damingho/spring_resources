package com.microvideo.springboot_resource_analysis;

import com.microvideo.springboot_resource_analysis.domain.JavaBean;
import com.microvideo.springboot_resource_analysis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootTest
public class SpringbootResourceAnalysisApplicationTests {

    @Test
    public void contextLoads() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        JavaBean javaBean = (JavaBean) beanFactory.getBean("javaBean");
        javaBean.setName("zhangsan");
        System.out.println(javaBean.getName());
    }

}
