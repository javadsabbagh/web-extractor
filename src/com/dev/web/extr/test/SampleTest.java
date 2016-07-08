package com.dev.web.extr.test;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static junit.framework.Assert.assertFalse;
import static org.loadui.testfx.Assertions.verifyThat;


import org.loadui.testfx.GuiTest;
import static org.loadui.testfx.GuiTest.find;
import static org.loadui.testfx.controls.Commons.hasText;
/**
 *  @see https://github.com/TestFX/TestFX#features
 * @author Sabbagh
 */
public class SampleTest extends GuiTest {

    @Override
    protected Parent getRootNode() {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
            return parent;
        } catch (IOException ex) {
            // TODO ...
        }
        return parent;
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
