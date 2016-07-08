package com.dev.web.extr.app;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author Sabbagh
 */

//public class GuiceApp extends Application implements ExampleApp {
// 
//    public static void main(String[] args) {
//        launch(args);
//    }
// 
//    private GuiceContext context = new GuiceContext(this, () -> Arrays.asList(new GuiceModule()));
// 
//    @Inject private FXMLLoader fxmlLoader;
// 
//    @Override public void start(Stage primaryStage) throws IOException {
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
//    @Override protected void configure() {
//        bind(Service.class).to(Service.class);
//    }
//}
