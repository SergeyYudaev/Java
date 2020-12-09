package HomeWork8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;



public class Main extends JFrame {

    private static Main gameWindow;
    private static long lastFrameTime;
    private static Image background;
    private static Image gameOver = null;
    private static Image drop = null;
    private static float dropLeft = 200;
    private static float dropTop = -100;
    private static float dropV = 200;
    private static int score = 0;

    public static void main(String[] args) throws  IOException {
        gameWindow = new Main();
        background = ImageIO.read(new File("D:/Java/Lessons/GB/HW8/src/main/java/HomeWork8/background.png"));
        gameOver = ImageIO.read(new File("D:/Java/Lessons/GB/HW8/src/main/java/HomeWork8/game_over.png"));
        drop = ImageIO.read(new File("D:/Java/Lessons/GB/HW8/src/main/java/HomeWork8/drop.png"));
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLocation(500, 300);
        gameWindow.setSize(906, 478);
        gameWindow.setResizable(false);
        lastFrameTime = System.nanoTime();
        final GameField gameField = new GameField();

        gameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float dropRight = dropLeft + drop.getWidth(null);
                float dropBottom = dropTop + drop.getHeight(null);
                boolean isDrop = x >= dropLeft && x <= dropRight && y >= dropTop && y <= dropBottom;
                if (isDrop) {
                    dropTop = -100;
                    dropLeft = (int) (Math.random() * gameField.getWidth() - drop.getWidth(null));
                    dropV = dropV + 20;
                    score++;
                    gameWindow.setTitle("Score: " + score);

                }
            }
        });
        gameWindow.add(gameField);
        gameWindow.setVisible(true);
    }

    private static void onRepaint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        dropTop = dropTop + dropV * deltaTime;
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, (int) dropLeft, (int) dropTop, null);
        if (dropTop > gameWindow.getHeight()) g.drawImage(gameOver, 280, 120, null);

    }

    private static class GameField extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }

}

