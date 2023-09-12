package com.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AppTest {
    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(MyConfig.class);
    }

    @Test
    public void testParentBean() {
        MyBean parentBean = context.getBean("parentBean", MyBean.class);
        assertNotNull(parentBean);
        assertEquals("Hello from Parent Bean!", parentBean.getMessage());
    }

    @Test
    public void testChildBean() {
        ChildBean childBean = context.getBean("childBean", ChildBean.class);
        assertNotNull(childBean);
        childBean.setParentBean(context.getBean("parentBean", MyBean.class));

        // Capture the printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the displayMessage method
        childBean.displayMessage();

        // Reset System.out to its original value
        System.setOut(System.out);

        // Get the captured output as a string
        String printedOutput = outContent.toString().trim();

        // Assert that the printed output matches the expected message
        String expectedOutput = "Child Bean: Hello from Parent Bean!";
        assertEquals(expectedOutput, printedOutput);
    }
}
