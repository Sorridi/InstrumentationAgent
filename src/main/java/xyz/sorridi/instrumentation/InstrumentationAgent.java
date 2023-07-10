package xyz.sorridi.instrumentation;

import java.lang.instrument.*;

public class InstrumentationAgent
{
    public static volatile Instrumentation instrumentation;

    public static void premain(String args, Instrumentation instance)
    {
        instrumentation = instance;
    }

    public static long getObjectSize(Object object)
    {
        if (instrumentation == null)
        {
            throw new IllegalStateException("Agent not initialized.");
        }

        return instrumentation.getObjectSize(object);
    }
}
