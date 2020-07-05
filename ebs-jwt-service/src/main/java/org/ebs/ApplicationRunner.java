package org.ebs;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.samplers.ConstSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class);
    }

    @Bean
    public io.opentracing.Tracer tracer() {
        Configuration.SamplerConfiguration samplerConfiguration = new Configuration.SamplerConfiguration();
        samplerConfiguration.withType(ConstSampler.TYPE);
        samplerConfiguration.withParam(1);
        return new Configuration("ebs-jwt-service").
                withSampler(samplerConfiguration).
                withReporter(new Configuration.ReporterConfiguration()).getTracer();
    }
}
