package ru.alazarev.gc.instrumentation;

import java.lang.instrument.Instrumentation;

/**
 * Class InstrumentationAgent решение задачи части 5.1.Демонстрация работы GC.
 *
 * @author Aleksey Lazarev
 * @since 25.09.2019
 */
public class InstrumentationAgent {
    private static volatile Instrumentation globalInstrumentation;

    public static void premain(final String agentArgs, final Instrumentation inst) {
        globalInstrumentation = inst;
    }

    public static long getObjectSize(final Object object) {
        if (globalInstrumentation == null) {
            throw new IllegalStateException("Agent not initialized.");
        }
        return globalInstrumentation.getObjectSize(object);
    }
}
