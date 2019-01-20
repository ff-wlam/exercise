/**
 * AppConfig.java
 * Jan 18, 2019
 * <p>
 * Copyright © FirstFuel Software. 2010-2019 All right reserved. The copyright to
 * the computer program(s) herein is the property of FirstFuel Software. The
 * program(s) may be used and/or copied only with the written permission of
 * FirstFuel Software.
 * </p>
 */
package net.williamlam.applause.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p> AppConfig
 * </p>
 * @version 1.0
 * @author wlam
 * @since Jan 18, 2019
 */
@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan(basePackages = {"net.williamlam.applause"})
public class AppConfig {
}