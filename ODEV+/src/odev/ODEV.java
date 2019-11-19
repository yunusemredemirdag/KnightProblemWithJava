package odev;

import java.util.Vector;

public class ODEV {

    int[][] tahta;
    int[] at;
    int[] hedef;
    int[] ax,ay;
    Queue kuyruk, kuyruk1;
    Vector vecx, vecy;
    Vector kisa;
    Vector yigitx, yigity;
    Vector kontrolx, kontroly;
    Vector kisax,kisay;
    Vector appx,appy;
    boolean c = false;

    ODEV() {
        tahta = new int[8][8];
        for (int i = 0; i < tahta.length; i++) {
            for (int j = 0; j < tahta[0].length; j++) {
                tahta[i][j] = 0;
            }
        }
        at = new int[2];
        hedef = new int[2];
        kuyruk = new Queue();
        kuyruk1 = new Queue();
        vecx = new Vector(1, 1);
        vecy = new Vector(1, 1);
        kisa = new Vector(1, 1);
        yigitx = new Vector(1, 1);
        yigity = new Vector(1, 1);
        kontrolx = new Vector(1, 1);
        kontroly = new Vector(1, 1);
        kisax=new Vector(1,1);
        kisay=new Vector(1,1);
        appx=new Vector(1,1);
        appy=new Vector(1,1);
    }

    void baslamanoktasi(int x, int y) {
        at[0] = x;
        at[1] = y;
        tahta[x][y] = 1;
    }

    void hedefnokta(int x, int y) {
        hedef[0] = x;
        hedef[1] = y;
        tahta[x][y] = 1;
    }

    int kisabul() {
        int a =20000;
        int k=0;
        for(int i=0;i<kisa.size();i++){
            k=(int) kisa.elementAt(i);
            if(a>=k)
                a=k;
        }
        return a-1;
    }

    void sayibul() {
        
        int a,b;
        int kx,ky;
        int s,d;
        c=true;
        for(int i=yigitx.size()-1;i>=0;i--){
            
            a=(int)yigitx.elementAt(i);
            b=(int)yigity.elementAt(i);
            hesapla(a,b);
            for(int j=0;j<kontrolx.size();j++){
                
                kx=(int)kontrolx.elementAt(j);
                ky=(int)kontroly.elementAt(j);
                s=kuyruk1.son.x;
                d=kuyruk1.son.y;
                if(kx == s && ky == d ){
                    kuyruk1.ekle(new Eleman(a, b));
                    break;
                }
                
            }
            kontrolx.removeAllElements();
            kontroly.removeAllElements();
            
        }
        c=false;
        
        kisa.add(kuyruk1.size());
        Eleman tmp;
        while(kuyruk1.bas != null){
            tmp=kuyruk1.sil();
            System.out.println(tmp.x + "  " + tmp.y);
            kisax.add(tmp.x);
            kisay.add(tmp.y);
        }
        System.out.println("------------");
    }

    void islem() {

        Eleman silinen;
        int a, b;
        kuyruk.ekle(new Eleman(at[0], at[1]));
        for (int j = 0;;) {
            hesapla(at[0], at[1]);
            for (int i = 0; i < vecx.size(); i++) {
                a = (int) vecx.elementAt(i);
                b = (int) vecy.elementAt(i);
                if (hedef[0] == a && hedef[1] == b) {
                    kuyruk1.ekle(new Eleman(a, b));
                    kuyruk1.ekle(new Eleman(kuyruk.bas.x, kuyruk.bas.y));
                    sayibul();
                    continue;
                }
                if (tahta[a][b] == 0) {
                    kuyruk.ekle(new Eleman(a, b));
                    tahta[a][b] = 1;
                }
            }
            vecx.removeAllElements();
            vecy.removeAllElements();
            silinen=kuyruk.sil();
            a=silinen.x;
            b=silinen.y;
            yigitx.add(a);
            yigity.add(b);
            if(kuyruk.bosmu()){
                break;
            }else{
                at[0]=kuyruk.bas.x;
                at[1]=kuyruk.bas.y;
            }
        }

    }

    void hesapla(int x, int y) {

        int xcontrol, ycontrol;
        if ((xcontrol = x + 1) < 8 && (ycontrol = y - 2) >= 0) {
            if (c) {
                kontroly.add(ycontrol);
                kontrolx.add(xcontrol);
            } else {
                vecx.add(xcontrol);
                vecy.add(ycontrol);
            }
        }
        if ((xcontrol = x + 2) < 8 && (ycontrol = y - 1) >= 0) {
            if (c) {
                kontroly.add(ycontrol);
                kontrolx.add(xcontrol);
            } else {
                vecx.add(xcontrol);
                vecy.add(ycontrol);
            }
        }
        if ((xcontrol = x + 2) < 8 && (ycontrol = y + 1) < 8) {
            if (c) {
                kontroly.add(ycontrol);
                kontrolx.add(xcontrol);
            } else {
                vecx.add(xcontrol);
                vecy.add(ycontrol);
            }
        }
        if ((xcontrol = x + 1) < 8 && (ycontrol = y + 2) < 8) {
            if (c) {
                kontroly.add(ycontrol);
                kontrolx.add(xcontrol);
            } else {
                vecx.add(xcontrol);
                vecy.add(ycontrol);
            }
        }
        if ((xcontrol = x - 1) >= 0 && (ycontrol = y + 2) < 8) {
            if (c) {
                kontroly.add(ycontrol);
                kontrolx.add(xcontrol);
            } else {
                vecx.add(xcontrol);
                vecy.add(ycontrol);
            }
        }
        if ((xcontrol = x - 2) >= 0 && (ycontrol = y + 1) < 8) {
            if (c) {
                kontroly.add(ycontrol);
                kontrolx.add(xcontrol);
            } else {
                vecx.add(xcontrol);
                vecy.add(ycontrol);
            }
        }
        if ((xcontrol = x - 2) >= 0 && (ycontrol = y - 1) >= 0) {
            if (c) {
                kontroly.add(ycontrol);
                kontrolx.add(xcontrol);
            } else {
                vecx.add(xcontrol);
                vecy.add(ycontrol);
            }
        }
        if ((xcontrol = x - 1) >= 0 && (ycontrol = y - 2) >= 0) {
            if (c) {
                kontroly.add(ycontrol);
                kontrolx.add(xcontrol);
            } else {
                vecx.add(xcontrol);
                vecy.add(ycontrol);
            }
        }
    }
    
    void enkisayolapplet(){
        
        int a;
        int k=0;
        int toplam=0;
        int f=kisabul()+1;
        for(int i=0;i<kisa.size();i++){
            a=(int)kisa.elementAt(i);
            if(a == f){
                for(int j=toplam;j<toplam+a;j++){
                    appx.add(kisax.elementAt(j));
                    appy.add(kisay.elementAt(j));
                }
            }else{
                toplam+=a;
            }
            
        }
        ax=new int[appx.size()];
        ay=new int[appy.size()];
        for(int i=0;i<ax.length;i++){
            ax[i]=(int)appx.elementAt(i);
            ay[i]=(int)appy.elementAt(i);
        }
    }
    
    /*int duzhesapla(int x,int y){
        
        int result=0;
        int a=0;
        int k=0;
        int sayac=0;
        Queue k1=new Queue();
        for(int i=0;;){
            
            if(a == x && k == y){
                result++;
                return result;
            }
            
          if(sayac==0){
              k1.ekle(new Eleman(a, k));
              k++;
              sayac++;
              result++;
          }else if(sayac == 8){
              a++;
              k=0;
              sayac=0;
              k1.ekle(new Eleman(a,k));
              k1.sil();
          }else{
              k1.ekle(new Eleman(a, k));
              k1.sil();
              k++;
              sayac++;
              result++;
          }
          
          
        }
    }*/
    
}

