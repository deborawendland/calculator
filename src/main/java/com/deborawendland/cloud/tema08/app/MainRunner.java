package com.deborawendland.cloud.tema08.app;

import com.deborawendland.cloud.tema08.config.AppConfig;
import com.deborawendland.cloud.tema08.config.HealthCheckConfig;
import com.deborawendland.cloud.tema08.rxNetty.HealthCheckResource;
import com.deborawendland.cloud.tema08.rxNetty.RxNettyHandler;
import com.deborawendland.cloud.tema08.service.Calculator;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonBootstrapModule;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRunner {

    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext healthCheckContext = new AnnotationConfigApplicationContext(HealthCheckConfig.class);
        HealthCheckResource healthCheck = (HealthCheckResource) healthCheckContext.getBean("healthCheckResource");

        Karyon.forRequestHandler(8888,
                new RxNettyHandler("/healthcheck",
                        new HealthCheckEndpoint(healthCheck),
                        (Calculator) appContext.getBean("calculator")),
                new KaryonBootstrapModule(healthCheck),
                new ArchaiusBootstrapModule("calculator"),
                Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                ShutdownModule.asBootstrapModule(),
                KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();
    }

}

