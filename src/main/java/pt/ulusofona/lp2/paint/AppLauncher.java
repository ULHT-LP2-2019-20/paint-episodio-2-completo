package pt.ulusofona.lp2.paint;

import pt.ulusofona.lp2.paint.provided.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class AppLauncher {

    static final int WIDTH = 800;  // altura da área pintável
    static final int HEIGHT = 600;  // largura da área pintável

    static Ponto[] pontos;

    static void createAndShowGUI() {

        // inicializa a janela do Paint
        JFrame frame = new JFrame("Paint (Episódio 2)");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());

        // inicializa a área "pintável" do Paint
        Screen screen = new Screen(WIDTH, HEIGHT);
        screen.reset();
        frame.getContentPane().add(screen, BorderLayout.CENTER);

        // inicializa a barra de ferramentas
        JToolBar toolBar = criaBarraFerramentas(frame);
        JButton moveEsquerdaBtn = new JButton(getIcon("icon_left.png"));
        toolBar.add(moveEsquerdaBtn);
        JButton moveDireitaBtn = new JButton(getIcon("icon_right.png"));
        toolBar.add(moveDireitaBtn);
        JButton moveBaixoBtn = new JButton(getIcon("icon_down.png"));
        toolBar.add(moveBaixoBtn);
        JButton moveCimaBtn = new JButton(getIcon("icon_up.png"));
        toolBar.add(moveCimaBtn);

        // mostra no écran o Paint
        frame.pack();
        frame.setVisible(true);

        // cria 10 pontos em posições aleatórias
        pontos = new Ponto[10];
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            pontos[i] = new Ponto(x, y, getCorAleatoria());
        }

        // desenha os pontos nas respectivas posições usando a classe auxiliar Screen
        for (Ponto ponto: pontos) {
            ponto.pinta(screen);
        }

        // define o que acontece quando se carrega no botão "moveEsquerdaBtn"
        moveEsquerdaBtn.addActionListener(event -> {
            screen.reset();  // primeiro limpar o écran anterior
            for (Ponto ponto: pontos) {
                ponto.moveEsquerda();
                ponto.pinta(screen);
            }
            System.out.println(Arrays.toString(pontos));
        });

        // define o que acontece quando se carrega no botão "moveDireitaBtn"
        moveDireitaBtn.addActionListener(event -> {
            screen.reset();  // primeiro limpar o écran anterior
            for (Ponto ponto: pontos) {
                ponto.moveDireita();
                ponto.pinta(screen);
            }
            System.out.println(Arrays.toString(pontos));
        });

        // define o que acontece quando se carrega no botão "moveBaixoBtn"
        moveBaixoBtn.addActionListener(event -> {
            screen.reset();  // primeiro limpar o écran anterior
            for (Ponto ponto: pontos) {
                ponto.moveBaixo();
                ponto.pinta(screen);
            }
            System.out.println(Arrays.toString(pontos));
        });

        // define o que acontece quando se carrega no botão "moveCimaBtn"
        moveCimaBtn.addActionListener(event -> {
            screen.reset();  // primeiro limpar o écran anterior
            for (Ponto ponto: pontos) {
                ponto.moveCima();
                ponto.pinta(screen);
            }
            System.out.println(Arrays.toString(pontos));
        });
    }

    static JToolBar criaBarraFerramentas(JFrame frame) {
        JToolBar toolBar = new JToolBar();
        frame.getContentPane().add(toolBar, BorderLayout.WEST);
        toolBar.setLayout(new GridLayout(10, 1, 0, 5));
        toolBar.setFloatable(false);
        toolBar.setBorderPainted(true);
        toolBar.setMargin(new Insets(10, 5, 10, 5));
        return toolBar;
    }

    static ImageIcon getIcon(String iconName) {
        return new ImageIcon(AppLauncher.class.getResource("/" + iconName));
    }

    // esta função retorna uma côr aleatória
    static Color getCorAleatoria() {
        return new Color(new Random().nextInt(0xFFFFFF));
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
