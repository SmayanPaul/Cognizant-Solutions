package com.mockito.exercises;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

interface ExternalApi {
    void performAction(String data);
}

class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void doSomething(String input) {
        api.performAction(input);
    }
}

public class MyServiceTest {
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.doSomething("Test Data");
        verify(mockApi).performAction("Test Data");
    }

    public static void main(String[] args) {
        System.setProperty("net.bytebuddy.experimental", "true");
        org.junit.platform.launcher.LauncherDiscoveryRequest request = org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request()
            .selectors(org.junit.platform.engine.discovery.DiscoverySelectors.selectClass(MyServiceTest.class))
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
