package com.junit.advanced.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionThrower {
    public void throwException() {
        throw new IllegalArgumentException("Invalid argument provided");
    }
}

public class ExceptionThrowerTest {
    @Test
    public void testThrowException() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException();
        });
    }

    public static void main(String[] args) {
        org.junit.platform.launcher.LauncherDiscoveryRequest request = org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request()
            .selectors(org.junit.platform.engine.discovery.DiscoverySelectors.selectClass(ExceptionThrowerTest.class))
            .build();
        org.junit.platform.launcher.Launcher launcher = org.junit.platform.launcher.core.LauncherFactory.create();
        org.junit.platform.launcher.listeners.SummaryGeneratingListener listener = new org.junit.platform.launcher.listeners.SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
        org.junit.platform.launcher.listeners.TestExecutionSummary summary = listener.getSummary();
        System.out.println("Tests run: " + summary.getTestsStartedCount());
        System.out.println("Tests succeeded: " + summary.getTestsSucceededCount());
        System.out.println("Tests failed: " + summary.getTestsFailedCount());
        for (org.junit.platform.launcher.listeners.TestExecutionSummary.Failure failure : summary.getFailures()) {
            failure.getException().printStackTrace();
        }
    }
}
