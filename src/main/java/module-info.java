module io.github.oakdh.hyperion {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;

    requires org.json;

    opens io.github.oakdh.hyperion.scene.controller to javafx.fxml, javafx.base;
    exports io.github.oakdh.hyperion;
    exports io.github.oakdh.hyperion.scene.controller;
}
