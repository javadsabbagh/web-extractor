package com.dev.extr.app;

import java.io.IOException;
import java.util.Arrays;

import com.gluonhq.ignite.guice.GuiceContext;
import com.google.common.util.concurrent.Service;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Sabbagh
 */

//public class GuiceApp extends Application implements ExampleApp {
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    private GuiceContext context = new GuiceContext(this, () > Arrays.asList(new GuiceModule()));
//
//    @Inject
//    private FXMLLoader fxmlLoader;
//
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        context.init();
//        fxmlLoader.setLocation(getViewLocation());
//        Parent view = fxmlLoader.load();
//
//        primaryStage.setTitle("Guice Example");
//        primaryStage.setScene(new Scene(view));
//        primaryStage.show();
//    }
//}
//
//class GuiceModule extends AbstractModule {
//    @Override
//    protected void configure() {
//        bind(Service.class).to(Service.class);
//    }
//}