package pt.ulusofona.lp2.paint;

import pt.ulusofona.lp2.paint.provided.Screen;

import java.awt.*;

public class Ponto {

    int x, y;
    Color cor;

    Ponto(int x, int y, Color cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

    void moveCima() {
        if (this.y > 1) {
            this.y--;
        }
    }

    void moveBaixo() {
        if (this.y < AppLauncher.HEIGHT - 2) {
            this.y++;
        }
    }

    void moveEsquerda() {
        if (this.x > 1) {
            this.x--;
        }
    }

    void moveDireita() {
        if (this.x < AppLauncher.WIDTH - 2) {
            this.x++;
        }
    }

    void pinta(Screen screen) {
        // desenha 5 pontos em forma de estrela para se ver melhor
        screen.drawPixel(x, y, cor);
        screen.drawPixel(x+1, y, cor);
        screen.drawPixel(x-1, y, cor);
        screen.drawPixel(x, y+1, cor);
        screen.drawPixel(x, y-1, cor);
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "x=" + x +
                ", y=" + y +
                ", cor=" + cor +
                '}';
    }
}
