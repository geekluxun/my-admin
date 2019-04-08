package com.geekluxun.myadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-04-08 14:28
 * @Description:
 * @Other:
 */
@Configuration
@ImportResource(locations = {"classpath*:/spring/activiti-config.xml"})
public class AppConfig {
}