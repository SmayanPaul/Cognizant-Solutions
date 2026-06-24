package com.junit.advanced.timeout;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class PerformanceTester {
    public void performTask() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class PerformanceTesterTest {
    @Test
    public void testPerformTaskTimeout() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            tester.performTask();
        });
    }

    public static void main(String[] args) {
        org.junit.platform.launcher.LauncherDiscoveryRequest request = org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request()
            .selectors(org.junit.platform.engine.discovery.DiscoverySelectors.selectClass(PerformanceTesterTest.class))
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
