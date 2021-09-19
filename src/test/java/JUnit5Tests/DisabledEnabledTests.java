package JUnit5Tests;

import Listeners.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@ExtendWith(Listener.class)
public class DisabledEnabledTests {

    @Test
    @Disabled(value = "Disabled")
    void firstTest() {
        System.out.println("First");
    }

    @Test
    @EnabledOnOs(value = OS.MAC, disabledReason = "Not MAC")
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled on Windows")
    void secondTest() {
        System.out.println("Second");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging")
    void thirdTest() {
        System.out.println("Third");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "Today is Sunday")
    void fourthTest() {
        System.out.println("Fourth");
    }

    @Test
    // @Enabled
    void fifthTest() {
        System.out.println("Fifth");
    }

    boolean provider() {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
