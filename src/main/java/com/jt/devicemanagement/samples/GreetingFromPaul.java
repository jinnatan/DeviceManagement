package com.jt.devicemanagement.samples;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("default")
@Service
public class GreetingFromPaul implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello Paul";
    }
}
