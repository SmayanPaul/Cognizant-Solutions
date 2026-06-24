package com.mockito.advanced;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

interface NetworkClient {
    String connect();
}

class NetworkService {
    private final NetworkClient networkClient;

    public NetworkService(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public String connectToServer() {
        return "Connected to " + networkClient.connect();
    }
}

public class NetworkServiceTest {
    @Test
    public void testServiceWithMockNetworkClient() {
        NetworkClient mockNetworkClient = mock(NetworkClient.class);
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");
        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();
        assertEquals("Connected to Mock Connection", result);
    }

    public static void main(String[] args) {
        System.setProperty("net.bytebuddy.experimental", "true");
        org.junit.platform.launcher.LauncherDiscoveryRequest request = org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request()
            .selectors(org.junit.platform.engine.discovery.DiscoverySelectors.selectClass(NetworkServiceTest.class))
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
