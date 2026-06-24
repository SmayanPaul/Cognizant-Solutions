package com.mockito.exercises;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.mockito.Mockito.inOrder;

interface ExternalApi {
    void firstAction();
    void secondAction();
}

class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void runPipeline() {
        api.firstAction();
        api.secondAction();
    }
}

public class MyServiceTest {
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.runPipeline();
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).firstAction();
        inOrder.verify(mockApi).secondAction();
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
