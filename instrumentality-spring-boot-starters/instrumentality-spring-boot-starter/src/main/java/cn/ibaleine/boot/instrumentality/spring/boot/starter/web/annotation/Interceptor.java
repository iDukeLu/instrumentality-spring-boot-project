package cn.ibaleine.boot.instrumentality.spring.boot.starter.web.annotation;

import cn.ibaleine.boot.instrumentality.spring.boot.starter.web.WebConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.annotation.*;
import java.util.List;

/**
 * 拦截器注解。对实现了 {@link HandlerInterceptor} 接口的类（即，拦截器类）添加此注解后，会自动注册该拦截器类
 * 注意：目前暂不支持 {@link PathMatcher} 的配置
 *
 * @author luhongyu
 * @date 2020.06.08
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Component
@Import(WebConfiguration.class)
public @interface Interceptor {

    /**
     * 拦截路径模型，默认为 /**
     */
    String[] pathPatterns() default {"/**"};

    /**
     * 拦截路径模型
     */
    String[] excludePatterns() default {};

    /**
     * 排序，默认 0
     */
    int order() default 0;

    /**
     * 环境
     */
    String profile() default "";
}
