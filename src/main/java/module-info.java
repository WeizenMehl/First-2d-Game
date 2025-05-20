module org.example.first2dgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens org.example.first2dgame to javafx.fxml;
    exports org.example.first2dgame;
}