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
        Configuration.ReporterConfiguration reporterConfiguration = new Configuration.ReporterConfiguration();
        Configuration.SenderConfiguration senderConfiguration = new Configuration.SenderConfiguration();
        senderConfiguration.withAgentHost("192.168.1.56").withAgentPort(6831);
        reporterConfiguration.withSender(senderConfiguration);
        return new Configuration("ebs-jwt-service").
                withSampler(samplerConfiguration).
                withReporter(reporterConfiguration).getTracer();
    }
}
