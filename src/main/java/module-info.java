module com.youcefmei {
    requires javafx.fxml;
    requires javafx.controls;
    requires transitive javafx.base;
    requires transitive javafx.graphics;
    requires static lombok;
    opens com.youcefmei.controllers to javafx.fxml;
    exports com.youcefmei;
    exports com.youcefmei.controllers;
}