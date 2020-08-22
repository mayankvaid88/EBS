package org.ebs;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.samplers.ConstSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
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
        senderConfiguration.withAgentHost("jaeger_agent").withAgentPort(6831);
        reporterConfiguration.withSender(senderConfiguration).withLogSpans(true);
        return new Configuration("ebs-login").
                withSampler(samplerConfiguration).
                withReporter(reporterConfiguration).getTracer();
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
