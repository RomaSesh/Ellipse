package org.modernclient;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyShapes extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Создаем эллипс с радиусами 110 и 70
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE); // Устанавливаем цвет заливки эллипса

        // Создаем текстовый элемент с заданным шрифтом
        Text text = new Text("My Shapes");
        text.setFont(Font.font("Arial Bold", 24)); // Устанавливаем шрифт текста
        text.setFill(Color.DARKBLUE); // Устанавливаем цвет текста

        // Создаем контейнер StackPane для центрирования эллипса и текста
        StackPane stackPane = new StackPane(ellipse, text);
        stackPane.setStyle("-fx-background-color: lightyellow;"); // Устанавливаем цвет фона StackPane

        // Создаем текстовый элемент для отображения статуса анимации
        Text statusText = new Text("Анимация на паузе");
        statusText.setFont(Font.font("Arial", 16));
        statusText.setFill(Color.DARKBLUE);

        // Создаем контейнер VBox для размещения StackPane и текста статуса
        VBox root = new VBox(stackPane, statusText);
        root.setSpacing(20); // Устанавливаем отступ между элементами
        root.setStyle("-fx-background-color: lightyellow;"); // Устанавливаем цвет фона VBox

        // Создаем RotateTransition для анимации вращения StackPane
        RotateTransition rotate = new RotateTransition(Duration.millis(2500), stackPane);
        rotate.setToAngle(360); // Устанавливаем конечный угол вращения
        rotate.setFromAngle(0); // Устанавливаем начальный угол вращения
        rotate.setInterpolator(Interpolator.LINEAR); // Устанавливаем линейную интерполяцию анимации
        rotate.setCycleCount(Animation.INDEFINITE); // Устанавливаем бесконечное повторение анимации

        // Обработка щелчка мыши на StackPane
        stackPane.setOnMouseClicked(mouseEvent -> {
            if (rotate.getStatus().equals(Animation.Status.RUNNING)) {
                rotate.pause(); // Если анимация запущена, ставим её на паузу
                statusText.setText("Анимация на паузе"); // Обновляем статус
            } else {
                rotate.play(); // Если анимация на паузе, запускаем её
                statusText.setText("Анимация запущена"); // Обновляем статус
            }
        });

        // Создаем сцену с контейнером VBox в качестве корневого узла
        Scene scene = new Scene(root, 350, 230);
        // Настраиваем и показываем окно приложения
        primaryStage.setTitle("JavaFX Centered Shapes"); // Заголовок окна
        primaryStage.setScene(scene); // Устанавливаем сцену
        primaryStage.show(); // Показываем окно
    }

    public static void main(String[] args) {
        launch(args); // Запуск JavaFX-приложения
    }
}