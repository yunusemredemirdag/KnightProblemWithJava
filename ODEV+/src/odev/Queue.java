package odev;

public class Queue {
    
    Eleman bas,son;
    int sayac;
    Queue(){
        bas=null;
        son=null;
        sayac=0;
    }
    
    
    void ekle(Eleman yeni){
        
        if(bosmu()){
            bas=yeni;
            son=yeni;
        }else{
            son.ileri=yeni;
            son=yeni;
        }
        sayac++;
        
    }
    
    Eleman sil(){
        
        Eleman sonuc=bas;
        if(sayac == 0){
            System.out.println("Kuyruk boş..");
            return null;
        }else{
            bas=bas.ileri;
        }
        sayac--;
        return sonuc;
        
    }
    
    boolean bosmu(){
        return sayac == 0;
    }
    
    int size(){
        return sayac;
    }
    
}
class Eleman{
    
    int x,y;
    Eleman ileri;
    Eleman(int x,int y){
        this.x=x;
        this.y=y;
        ileri=null;
    }
    
}