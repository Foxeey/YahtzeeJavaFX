package com.example.dicegame;

import java.util.Arrays;

public class KontrolerKosci {

    public int los[] = new int[5];
    public int punkty[] = new int[13];
    int strit[] = new int[4];
    boolean duplicated = false;
    int player = 1;

    public void getLos(int los2[]) {
        for(int i=0; i<los.length; i++) {
            los[i] = los2[i];
        }
        Arrays.sort(los);
    }
    public void liczPunkty1() {
        for(int i=0; i<los.length; i++) {
            if(los[i] == 1) {
               punkty[0] += 1;
            }
        }
    }
    public void liczPunkty2() {
        for(int i=0; i<los.length; i++) {
            if(los[i] == 2) {
                punkty[1] += 2;
            }
        }
    }
    public void liczPunkty3() {
        for(int i=0; i<los.length; i++) {
            if(los[i] == 3) {
                punkty[2] += 3;
            }
        }
    }
    public void liczPunkty4() {
        for(int i=0; i<los.length; i++) {
            if(los[i] == 4) {
                punkty[3] += 4;
            }
        }
    }
    public void liczPunkty5() {
        for(int i=0; i<los.length; i++) {
            if(los[i] == 5) {
                punkty[4] += 5;
            }
        }
    }
    public void liczPunkty6() {
        for(int i=0; i<los.length; i++) {
            if(los[i] == 6) {
                punkty[5] += 6;
            }
        }
    }
    public void liczPunkty3x() {

        for(int i=0; i<3; i++) {
            if (los[i] == los[i+1] && los[i+1] == los[i+2]) {
                punkty[6] = liczSume();
            }
        }
    }
    public void liczPunkty4x() {
        for (int i = 0; i < 2; i++) {
            if (los[i] == los[i+1] && los[i+1] == los[i+2] && los[i+2] == los[i+3]) {
                punkty[7] = liczSume();
            }
        }
    }
    public void liczPunkty3x2x() {
        if(los[0] == los[1] && los[1] == los[2] && los[3] == los[4]) {
            punkty[8] = 25;
        } else if(los[0] == los[1] && los[2] == los[3] && los[3] == los[4]) {
            punkty[8] = 25;
        }
    }
    public void liczMalyStrit() {
        duplicated = false;

        for(int k=0; k<los.length;k++) {
            for(int m=0; k<los.length;m++) {
                if(los[k] == los[m]) {
                    duplicated = true;
                    break;
                }
            }
        }
        if(duplicated) {
            int j = 0;
            strit[3] = 0;
            for (int i = 0; i < los.length - 1; i++) {
                if (los[i] == los[i + 1]) {
                    continue;
                } else {
                    strit[j] = los[i];
                    j++;
                }
                if(strit[3]==0) {
                    strit[3] = los[4];
                }
            }
            if((strit[0]+1) == strit[1] && (strit[1]+1) == strit[2] && (strit[2]+1) == strit[3]) {
                punkty[9] = 30;
            }
        } else {
            if((los[0]+1) == los[1] && (los[1]+1) == los[2] && (los[2]+1) == los[3] && (los[3]+1) == los[4]) {
                punkty[9] = 30;
            } else if((los[1]+1) == los[2] && (los[2]+1) == los[3] && (los[3]+1) == los[4] && (los[4]+1) == los[5]) {
                punkty[9] = 30;
            }
        }
    }
    public void liczDuzyStrit() {
        if((los[0]+1) == los[1] && (los[1]+1) == los[2] && (los[2]+1) == los[3] && (los[3]+1) == los[4]) {
            punkty[10] = 40;
        }
    }
    public void liczGeneral() {
        if(los[0] == los[1] && los[1] == los[2] && los[2] == los[3] && los[3] == los[4]) {
            punkty[11] = 50;
        }
    }
    public void liczSzansa() {
        punkty[12] = liczSume();
    }
    public void liczWynik() {
        zerujPunkty();
        liczPunkty1();
        liczPunkty2();
        liczPunkty3();
        liczPunkty4();
        liczPunkty5();
        liczPunkty6();
        liczPunkty3x();
        liczPunkty4x();
        liczPunkty3x2x();
        liczMalyStrit();
        liczDuzyStrit();
        liczGeneral();
        liczSzansa();
    }
    public void zerujPunkty() {
        for(int i=0; i<punkty.length; i++) {
            punkty[i] = 0;
        }
    }
    public int liczSume() {
        int punkt = 0;
        for(int i=0; i<los.length; i++) {
            punkt += los[i];
        }
        return punkt;
    }
}
