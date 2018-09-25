package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PixelTest {

    private JFrame window;//hlavni okno
    private JPanel panel;// panel, do ktereho umistujeme BufferedImage
    private BufferedImage img;//objekt, do ktereho kreslime

    public PixelTest() {
        //zakladni vytvoreni okna
        window = new JFrame();
        //oknu se musi rucne nastavit, jak se ma chovat pri pokusu o uzavreni
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800,600);

        panel = new JPanel();//inicializace panelu
        window.add(panel);//umisteni panelu do okna

        //inicializace image, nastaveni sirky a vysky (nastaveni typu - pro nas nedulezite)
        img = new BufferedImage(800,600, BufferedImage.TYPE_INT_RGB);

        window.setVisible(true);
        //drawPixel(100,50, Color.GREEN.getRGB());//0x00ff00

        panel.addMouseListener(new MouseAdapter() {//nastaveni udalosti na kliknuti mysi
            @Override
            public void mouseClicked(MouseEvent e) {

                drawPixel(e.getX(),e.getY(),Color.GREEN.getRGB());
            }
        });
    }

    private void drawPixel(int x, int y, int color) {
        img.setRGB(x, y, color); //nastaveni pixelu
        panel.getGraphics().drawImage(img, 0, 0 , null );// obnoveni informace v okne
    }

    public static void main(String[] args) {
        new PixelTest();
    }
}
