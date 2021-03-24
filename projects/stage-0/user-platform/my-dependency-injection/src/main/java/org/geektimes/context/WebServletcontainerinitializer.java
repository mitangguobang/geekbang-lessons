package org.geektimes.context;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

public class WebServletcontainerinitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext servletContext) throws ServletException {
        // 增加 ServletContextListener
        ComponentContext context = new ComponentContext();
        context.init(servletContext);
    }
}
