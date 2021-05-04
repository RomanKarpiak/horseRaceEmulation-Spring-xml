package com.roman;

import com.roman.service.EmulationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpathXmlApplicationContext.xml");
        EmulationService emulationRace = context.getBean(EmulationService.class);
        emulationRace.emulate();
        context.close();
            }
}
