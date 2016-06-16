
package com.dev.web.extr.test;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static junit.framework.Assert.assertFalse;
import static org.loadui.testfx.Assertions.verifyThat;
import org.loadui.testfx.GuiTest;
import static org.loadui.testfx.controls.Commons.hasText;

/**
 *
 * @author Sabbagh
 */
public class SampleTest1 extends GuiTest {

    @Override
    protected Parent getRootNode() {
        // see snippet before
        return null;
    }

//    @Test
    public void setBothnamesAndCheckEnabledSearchButton() {
        TextField firstname = find("#firstname");
        firstname.setText("bennet");
        verifyThat("#firstname", hasText("bennet"));

        TextField lastname = find("#lastname");
        lastname.setText("schulz");
        verifyThat("#lastname", hasText("schulz"));

        Button search = find("#search");
        assertFalse(search.disableProperty().get());
    }
}
