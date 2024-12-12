package InternalAssesment.Activities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class CreativityTest {
    private Creativity creativity;

    @BeforeEach
    void setUp() {
        creativity = new Creativity() {
            @Override
            protected void setupComboBoxes() {
                // Simplify combo box setup for testing
                newspaperComboBox = new JComboBox<>(new String[]{"Done", "Doing", "To do", "Not selected"});
                debateComboBox = new JComboBox<>(new String[]{"Done", "Doing", "To do", "Not selected"});
                tripComboBox = new JComboBox<>(new String[]{"Done", "Doing", "To do", "Not selected"});
            }
        };
    }

    @Test
    void testFrameNotNull() {
        assertNotNull(creativity.getFrame(), "Frame should not be null");
    }

    @Test
    void testFrameTitle() {
        assertEquals("Choose user", creativity.getFrame().getTitle(), "Frame title should be 'Choose user'");
    }

    @Test
    void testComboBoxesExist() {
        assertNotNull(creativity.getNewspaperComboBox(), "Newspaper combo box should not be null");
        assertNotNull(creativity.getDebateComboBox(), "Debate combo box should not be null");
        assertNotNull(creativity.getTripComboBox(), "Trip combo box should not be null");
    }
}
