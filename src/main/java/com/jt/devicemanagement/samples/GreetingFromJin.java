package com.jt.devicemanagement.samples;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("local")
@Service
public class GreetingFromJin implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello Jin";
    }
}
