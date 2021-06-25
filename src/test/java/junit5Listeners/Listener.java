package junit5Listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        //TestWatcher.super.testDisabled(context, reason);
        System.out.println("--------------------------------------");
        System.out.println("this test was disabled: " + context.getTestMethod() + " - with reason: " + reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        //TestWatcher.super.testSuccessful(context);
        System.out.println("--------------------------------------");
        System.out.println("this test was successful: " + context.getTestMethod());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        //TestWatcher.super.testAborted(context, cause);
        System.out.println("--------------------------------------");
        System.out.println("this test was aborted: " + context.getTestMethod() + " - with reason: " + cause.getMessage());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        //TestWatcher.super.testFailed(context, cause);
        System.out.println("--------------------------------------");
        System.out.println("this test failed: " + context.getTestMethod() + " - with reason: " + cause.getMessage());
    }
}
