module io.github.oakdh.hyperion {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    requires transitive org.json;

    opens io.github.oakdh.hyperion.scene.controller to javafx.fxml, javafx.base;
    exports io.github.oakdh.hyperion;
}
