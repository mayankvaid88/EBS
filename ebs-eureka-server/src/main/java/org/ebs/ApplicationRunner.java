package org.ebs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class);
    }

//    @Bean
//    public JaegerTracer getTracer(){
//        Configuration.SamplerConfiguration samplerConfiguration = new Configuration.SamplerConfiguration();
//        samplerConfiguration.withType(ConstSampler.TYPE);
//        samplerConfiguration.withParam(1);
//        Configuration.ReporterConfiguration reporterConfiguration = new Configuration.ReporterConfiguration();
//        Configuration.SenderConfiguration senderConfiguration = new Configuration.SenderConfiguration();
//        senderConfiguration.withAgentHost("192.168.1.56").withAgentPort(6831);
//        reporterConfiguration.withSender(senderConfiguration).withLogSpans(true);
//        return new Configuration("ebs-eureka-server").
//                withSampler(samplerConfiguration).
//                withReporter(reporterConfiguration).getTracer();
//    }
}