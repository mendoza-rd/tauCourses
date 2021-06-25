package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisabledEnabledTest {

    @Test
    @Disabled(value = "disabled for demo of @Disabled")
    void firstTest() {
        System.out.println("this is the first test method");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled for demo of OS")
    //@EnabledOnOs(value = OS.LINUX, disabledReason = "Disabled for demo of OS")
    void secondTest() {
        System.out.println("this is the second test method");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging", disabledReason = "disabled for demo")
    void thirdTest() {
        System.out.println("this is the third test method");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "disabled for demo of @DisabledIf")
    void fourthTest() {
        System.out.println("this is the fourth test method");
    }

    boolean provider() {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.THURSDAY);
    }

    @Test
    void fifthTest() {
        System.out.println("this is the fifth test method");
    }
}
