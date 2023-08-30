module com.example.alieninvasiongame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.alieninvasiongame to javafx.fxml;
    exports com.example.alieninvasiongame;
}