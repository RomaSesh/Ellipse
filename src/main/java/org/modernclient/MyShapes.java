package org.modernclient;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class MyShapes extends Application {

        @Override
        public void start(Stage primaryStage) {
            Stop[] stops = new Stop[] { new Stop(0, Color.DODGERBLUE),
                    new Stop(0.5, Color.LIGHTBLUE),
                    new Stop(1.0, Color.LIGHTGREEN)};
            // Создаем эллипс с радиусами 100 и 50
            Ellipse ellipse = new Ellipse(110, 70);// радиус по оси X = 100, по оси Y = 50
            ellipse.setFill(Color.LIGHTBLUE); // Устанавливаем цвет заливки
            ellipse.setFill(Color.LIGHTBLUE);              // Светло-голубой, полностью непрозрачный
            ellipse.setFill(Color.web("#ADD8E6"));         // Светло-голубой, полностью непрозрачный
            ellipse.setFill(Color.web("#ADD8E680"));       // Светло-голубой, .5 непрозрачный
            ellipse.setFill(Color.web("0xADD8E6"));        // Светло-голубой, полностью непрозрачный
            ellipse.setFill(Color.web("0xADD8E680"));      // Светло-голубой, .5 непрозрачный
            ellipse.setFill(Color.rgb(173, 216, 230));     // Светло-голубой, полностью непрозрачный
            ellipse.setFill(Color.rgb(173, 216, 230, .5)); // Light blue, .5 opaque
            // Создаем текстовый элемент с заданным шрифтом
            Text text = new Text("My Shapes");
            text.setFont(Font.font("Arial Bold", 24));// Установка шрифта
            text.setFill(Color.DARKBLUE); // Устанавливаем цвет текста
            Reflection r = new Reflection();
            r.setFraction(.8);// Интенсивность отражения (80%)
            r.setTopOffset(1.0); // Смещение отражения от исходного текста
            text.setEffect(r); // Применение эффекта к тексту

            // Создаем контейнер StackPane для автоматического центрирования элементов
            Group group = new Group(ellipse, text);
            // Manually placing components is tedious and error-prone
            ellipse.setCenterX(175);
            ellipse.setCenterY(115);
            // Устанавливаем координаты центра эллипса
            text.setX(175-(text.getLayoutBounds().getWidth()/2));
            text.setY(115+(text.getLayoutBounds().getHeight()/2));
            // Устанавливаем координаты текста относительно центра эллипса
            text.setOnMouseClicked(mouseEvent -> {
                System.out.println(mouseEvent.getSource().getClass() + " clicked.");
            });// обработка щелчка мыши

            // Создаем сцену с контейнером StackPane в качестве корневого узла
            Scene scene = new Scene(group, 350, 230, Color.LIGHTYELLOW);


            // Настраиваем и показываем окно
            primaryStage.setTitle("JavaFX Centered Shapes");// Заголовок окна
            primaryStage.setScene(scene); // Установка сцены
            primaryStage.show(); // Показ окна
        }

        public static void main(String[] args) {
            launch(args); // Запуск JavaFX-приложения
        }
    }
