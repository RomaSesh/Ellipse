package org.modernclient;

import com.almasb.fxgl.dsl.EventBuilder;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MyShapes extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Создаем массив остановок для градиента (не используется в текущем коде)
        Stop[] stops = new Stop[]{new Stop(0, Color.DODGERBLUE),
                new Stop(0.5, Color.LIGHTBLUE),
                new Stop(1.0, Color.LIGHTGREEN)};

        // Создаем эллипс с радиусами 110 и 70
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE); // Устанавливаем цвет заливки эллипса

        // Создаем текстовый элемент с заданным шрифтом
        Text text = new Text("My Shapes");
        text.setFont(Font.font("Arial Bold", 24)); // Устанавливаем шрифт текста
        text.setFill(Color.DARKBLUE); // Устанавливаем цвет текста

        // Создаем эффект отражения для текста
        Reflection r = new Reflection();
        r.setFraction(.8); // Устанавливаем интенсивность отражения (80%)
        r.setTopOffset(1.0); // Устанавливаем смещение отражения от исходного текста
        text.setEffect(r); // Применяем эффект к тексту

        // Создаем контейнер StackPane для автоматического центрирования элементов
        StackPane stackPane = new StackPane(ellipse, text);
        stackPane.setStyle("-fx-background-color: lightyellow;"); // Устанавливаем цвет фона StackPane

        // Создаем RotateTransition для анимации вращения
        RotateTransition rotate = new RotateTransition(Duration.millis(2500), stackPane);
        rotate.setToAngle(360); // Устанавливаем конечный угол вращения
        rotate.setFromAngle(0); // Устанавливаем начальный угол вращения
        rotate.setInterpolator(Interpolator.LINEAR); // Устанавливаем линейную интерполяцию анимации

        // Создаем привязку для свойства обводки текста к статусу анимации
        text.strokeProperty().bind(Bindings.when(rotate.statusProperty().isEqualTo(Animation.Status.RUNNING))
                .then(Color.GREEN) // Устанавливаем цвет обводки в зеленый, если анимация выполняется
                .otherwise(Color.DARKBLUE)); // Устанавливаем цвет обводки в темно-синий, если анимация не выполняется

        // Обработка щелчка мыши на StackPane
        stackPane.setOnMouseClicked(mouseEvent -> {
            if (rotate.getStatus().equals(Animation.Status.RUNNING)) {
                rotate.pause(); // Если анимация запущена, ставим её на паузу
            } else {
                rotate.play(); // Если анимация на паузе, запускаем её
            }
        });

        // Создаем сцену с контейнером StackPane в качестве корневого узла
        Scene scene = new Scene(stackPane, 350, 230);
        // Настраиваем и показываем окно приложения
        primaryStage.setTitle("JavaFX Centered Shapes"); // Заголовок окна
        primaryStage.setScene(scene); // Устанавливаем сцену
        primaryStage.show(); // Показываем окно
    }

    public static void main(String[] args) {
        launch(args); // Запуск JavaFX-приложения
    }

    public void handleMouseClick(MouseEvent mouseEvent) {
    }
}
