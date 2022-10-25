module io.github.oakdh.hyperion
{
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens io.github.oakdh.hyperion.scene.controller to javafx.fxml;
    exports io.github.oakdh.hyperion;
}
