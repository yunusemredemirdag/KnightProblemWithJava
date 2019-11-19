package odev;

import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class app extends Applet implements Runnable {

    int[] appx, appy;
    int[] at;
    int cizimx, cizimy;
    int controlx, controly;
    int basx, basy, hx, hy;

    @Override
    public void init() {
        setSize(500, 500);
        ODEV o = new ODEV();
        basx = 0;
        basy = 0;
        hx = 7;
        hy = 7;
        o.baslamanoktasi(basx, basy);
        o.hedefnokta(hx, hy);
        o.islem();
        int x = o.kisabul();
        System.out.println(x);
        //int r=o.duzhesapla(4, 6);
        //System.out.println("********" + r);
        System.out.println("");
        o.enkisayolapplet();
        appx = o.ax;
        appy = o.ay;
        cizimx = (appx[0] + 1) * 50;
        cizimy = (appy[0] + 1) * 50;
        Thread t = new Thread(this);
        t.start();

    }

    @Override
    public void paint(Graphics g) {

        int p = 1;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 10; j++) {
                if (p % 2 == 0) {
                    g.setColor(Color.WHITE);
                    p++;
                } else {
                    g.setColor(Color.BLACK);
                    p++;
                }
                g.fillRect(i * 50, j * 50, 50, 50);
                if(p == 64){
                    break;
                }
            }
        }

        g.setColor(Color.YELLOW);
        g.fillOval(cizimx, cizimy, 50, 50);
        g.setColor(Color.red);
        g.fillOval((basx + 1) * 50, (basy + 1) * 50, 50, 50);
        g.fillOval((hx + 1) * 50, (hy + 1) * 50, 50, 50);

    }

    @Override
    public void run() {
        try {

            for (int k = 1; k < appx.length; k++) {
                controlx = appx[k] - appx[k - 1];
                controly = appy[k] - appy[k - 1];
                cizimx = (appx[k - 1] + 1) * 50;
                cizimy = (appy[k - 1] + 1) * 50;
                if (controlx == 1 && controly == -2) {
                    while (cizimy != (appy[k] + 1) * 50) {
                        cizimy -= 10;
                        repaint();
                        Thread.sleep(150);
                    }
                    while (cizimx != (appx[k] + 1) * 50) {
                        cizimx += 10;
                        repaint();
                        Thread.sleep(150);
                    }
                } else if (controlx == 2 && controly == -1) {
                    while (cizimy != (appy[k] + 1) * 50) {
                        cizimy -= 10;
                        repaint();
                        Thread.sleep(150);
                    }
                    while (cizimx != (appx[k] + 1) * 50) {
                        cizimx += 10;
                        repaint();
                        Thread.sleep(150);
                    }
                } else if (controlx == 2 && controly == 1) {
                    while (cizimy != (appy[k] + 1) * 50) {
                        cizimy += 10;
                        repaint();
                        Thread.sleep(150);
                    }
                    while (cizimx != (appx[k] + 1) * 50) {
                        cizimx += 10;
                        repaint();
                        Thread.sleep(150);
                    }
                } else if (controlx == 1 && controly == 2) {
                    while (cizimy != (appy[k] + 1) * 50) {
                        cizimy += 10;
                        repaint();
                        Thread.sleep(150);
                    }
                    while (cizimx != (appx[k] + 1) * 50) {
                        cizimx += 10;
                        repaint();
                        Thread.sleep(150);
                    }
                } else if (controlx == -1 && controly == 2) {
                    while (cizimy != (appy[k] + 1) * 50) {
                        cizimy += 10;
                        repaint();
                        Thread.sleep(150);
                    }
                    while (cizimx != (appx[k] + 1) * 50) {
                        cizimx -= 10;
                        repaint();
                        Thread.sleep(150);
                    }
                } else if (controlx == -2 && controly == 1) {
                    while (cizimy != (appy[k] + 1) * 50) {
                        cizimy += 10;
                        repaint();
                        Thread.sleep(150);
                    }
                    while (cizimx != (appx[k] + 1) * 50) {
                        cizimx -= 10;
                        repaint();
                        Thread.sleep(150);
                    }
                } else if (controlx == -2 && controly == -1) {
                    while (cizimy != (appy[k] + 1) * 50) {
                        cizimy -= 10;
                        repaint();
                        Thread.sleep(150);
                    }
                    while (cizimx != (appx[k] + 1) * 50) {
                        cizimx -= 10;
                        repaint();
                        Thread.sleep(150);
                    }
                } else if (controlx == -1 && controly == -2) {
                    while (cizimy != (appy[k] + 1) * 50) {
                        cizimy -= 10;
                        repaint();
                        Thread.sleep(150);
                    }
                    while (cizimx != (appx[k] + 1) * 50) {
                        cizimx -= 10;
                        repaint();
                        Thread.sleep(150);
                    }
                }
                Thread.sleep(500);
            }

        } catch (Exception e) {
        }finally{
            
        }
    }

}
