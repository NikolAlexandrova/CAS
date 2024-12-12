package InternalAssesment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentOptionsTest {
    private StudentOptions studentOptions;

    @BeforeEach
    void setUp() {
        // Simplify by overriding the method that loads resources
        studentOptions = new StudentOptions() {
            @Override
            protected JLabel createImageLabel(String resourcePath, int x, int y, int width, int height) {
                return new JLabel(); // Return a simple JLabel for testing
            }
        };
    }

    @Test
    void testFrameNotNull() {
        assertNotNull(studentOptions.getFrame(), "Frame should not be null");
    }

    @Test
    void testFrameTitle() {
        assertEquals("Choose an option", studentOptions.getFrame().getTitle(), "Frame title should match 'Choose an option'");
    }

    @Test
    void testButtonsExist() {
        assertNotNull(studentOptions.getCreativityButton(), "Creativity button should not be null");
        assertNotNull(studentOptions.getActivityButton(), "Activity button should not be null");
        assertNotNull(studentOptions.getServiceButton(), "Service button should not be null");
    }
}
