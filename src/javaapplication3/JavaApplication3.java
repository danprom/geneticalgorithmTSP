/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Random;

public class JavaApplication3 {
    private static int[][] Cities;

    public static void main(String[] args) {
        
       
        int ilosc_epok = 1;
        double pm = 0.7;

        Random rand = new Random();

        Cities = new int[20][2];
        
        int x=0, y= 1;
        Cities[0][0] = 60;      Cities[0][1] = 200;
        Cities[1][0] = 180;     Cities[1][1] = 200;
        Cities[1][0] = 80;      Cities[2][1] = 180;
        Cities[3][0] = 140;     Cities[3][1] = 180;
        Cities[4][0] = 20;      Cities[4][1] = 160;
        Cities[5][0] = 100;     Cities[5][1] = 160;
        Cities[6][0] = 200;     Cities[6][1] = 160;
        Cities[7][0] = 140;     Cities[7][1] = 140;
        Cities[8][0] = 40;      Cities[8][1] = 120;
        Cities[9][0] = 100;     Cities[9][1] = 120;
        Cities[10][0] = 180;    Cities[10][1] = 100;
        Cities[11][0] = 60;     Cities[11][1] = 80;
        Cities[12][0] = 120;    Cities[12][1] = 80;
        Cities[13][0] = 180;    Cities[13][1] = 60;
        Cities[14][0] = 20;     Cities[14][1] = 40;
        Cities[15][0] = 100;    Cities[15][1] = 40;
        Cities[16][0] = 200;    Cities[16][1] = 40;
        Cities[17][0] = 20;     Cities[17][1] = 20;
        Cities[18][0] = 60;     Cities[18][1] = 20;
        Cities[19][0] = 160;    Cities[19][1] = 20;

        int tours_metoda_sciezkowa[][] = new int[][]
        {
            {9, 10, 17, 2, 12, 1, 11, 13, 15, 6, 7, 4, 19, 14, 5, 16, 3, 8, 18, 0},
            {18, 19, 10, 2, 16, 7, 6, 15, 12, 11, 5, 9, 17, 13, 3, 4, 1, 8, 0, 14},
            {11, 0, 7, 16, 13, 19, 15, 4, 3, 14, 9, 6, 2, 8, 10, 12, 1, 17, 18, 5},
            {4, 12, 18, 17, 10, 13, 2, 11, 19, 5, 16, 0, 14, 9, 1, 8, 3, 7, 6, 15},
            {11, 9, 2, 15, 1, 8, 17, 7, 12, 16, 13, 6, 14, 18, 5, 19, 3, 10, 4, 0},
            {1, 17, 10, 0, 14, 5, 12, 4, 9, 8, 3, 6, 7, 13, 19, 11, 16, 15, 2, 18},
            {5, 13, 14, 12, 17, 3, 19, 18, 11, 4, 2, 8, 10, 1, 15, 6, 9, 7, 16, 0},
            {17, 12, 8, 7, 2, 4, 3, 9, 14, 0, 19, 18, 6, 11, 15, 13, 16, 10, 1, 5},
            {11, 5, 15, 1, 6, 14, 19, 7, 16, 4, 17, 10, 3, 18, 9, 2, 13, 12, 8, 0},
            {11, 17, 19, 0, 18, 3, 16, 9, 5, 2, 4, 1, 14, 12, 8, 6, 10, 7, 13, 15},
            {19, 6, 18, 12, 4, 10, 9, 14, 13, 17, 15, 16, 5, 1, 2, 3, 11, 7, 8, 0},
            {11, 17, 7, 10, 14, 13, 5, 3, 4, 15, 12, 0, 6, 16, 8, 9, 18, 19, 2, 1},
            {12, 19, 3, 0, 7, 18, 10, 6, 4, 16, 14, 8, 1, 17, 5, 13, 2, 9, 15, 11},
            {3, 9, 4, 17, 0, 10, 8, 12, 14, 18, 13, 1, 2, 6, 16, 5, 15, 19, 7, 11},
            {13, 3, 19, 8, 15, 6, 7, 10, 4, 11, 5, 14, 9, 2, 12, 1, 16, 17, 0, 18},
            {10, 6, 15, 5, 9, 4, 17, 3, 12, 19, 13, 14, 7, 0, 1, 11, 18, 8, 2, 16},
            {5, 7, 16, 15, 11, 8, 4, 3, 10, 9, 14, 17, 19, 0, 2, 6, 12, 13, 1, 18},
            {0, 7, 12, 19, 4, 18, 1, 3, 14, 9, 17, 11, 8, 10, 16, 13, 2, 6, 5, 15},
            {16, 5, 9, 3, 13, 18, 11, 7, 19, 1, 17, 6, 10, 14, 4, 2, 15, 8, 0, 12},
            {1, 12, 2, 3, 9, 0, 5, 15, 18, 8, 7, 4, 14, 19, 11, 16, 6, 10, 17, 13},};

       
 // zamiana z sciezkowej do przyleglosciowej
        int tours_metoda_przyleglosciowa[][] = new int[tours_metoda_sciezkowa.length][tours_metoda_sciezkowa[0].length];
        for (int k = 0; k < tours_metoda_sciezkowa.length; k++) {
            for (int i = 0; i < tours_metoda_sciezkowa[k].length - 1; i++) {
                tours_metoda_przyleglosciowa[k][tours_metoda_sciezkowa[k][i]] = tours_metoda_sciezkowa[k][i + 1];
                if (i == tours_metoda_sciezkowa[k].length - 2) {
                    i++;
                    tours_metoda_przyleglosciowa[k][tours_metoda_sciezkowa[k][i]] = tours_metoda_sciezkowa[k][0];

                }
            }
        }

        int il = tours_metoda_przyleglosciowa.length;
        int m = tours_metoda_przyleglosciowa[0].length;

        System.out.print("Metoda przyległosciowa_początkowa");
        for (int i = 0; i < il; i++) {
            System.out.println();
            for (int j = 0; j < m; j++) {
                System.out.print(tours_metoda_przyleglosciowa[i][j] + " ");
            }
        }

        double[] odleglosc_tras = new double[tours_metoda_przyleglosciowa.length];
        for (int i = 0; i < il; i++) {
            double odleglosc_tras_ = 0;
            for (int j = 0; j < m; j++) {

                double odl_X = Math.abs(Cities[j][0] - Cities[tours_metoda_przyleglosciowa[i][j]][0]);
                double odl_Y = Math.abs(Cities[j][1] - Cities[tours_metoda_przyleglosciowa[i][j]][1]);
                odleglosc_tras_ += Math.sqrt((odl_X * odl_X) + (odl_Y * odl_Y));
            }
            odleglosc_tras[i] = odleglosc_tras_;
        }

        int tours_metoda_przyleglosciowa_mutacja[][] = new int[il][m + 1];
        int tours_metoda_przyleglosciowa_przedmutacja[][] = new int[il][m + 1];
        int tours_metoda_przyleglosciowa_turniej[][] = new int[il][m + 1];
        int t = 200000;
        int trasa[] = new int[m];
        for (int i = 0; i < odleglosc_tras.length; i++) {
            if (t > odleglosc_tras[i]) {
                t = (int) odleglosc_tras[i];
                for (int j = 0; j < trasa.length; j++) {
                    trasa[j] = tours_metoda_przyleglosciowa[i][j];
                }

            }
        }

        int tab_epoki[] = new int[ilosc_epok];

        for (int e = 0; e < ilosc_epok; e++) {
            for (int i = 0; i < il; i++) {
                for (int j = 0; j < m; j++) {
                    if (e == 0) {
                        tours_metoda_przyleglosciowa_turniej[i][j] = tours_metoda_przyleglosciowa[i][j];
                    }
                }
            }
            for (int i = 0; i < il; i++) {
                if (e == 0) {
                    tours_metoda_przyleglosciowa_turniej[i][m] = (int) odleglosc_tras[i];
                }
            }
            
            

            int ileturn = 3;//rand.nextInt(il);
            double[][] osobnik = new double[ileturn][m + 1];

            for (int i = 0; i < il; i++) {
                for (int j = 0; j < ileturn; j++) {
                    int los = rand.nextInt(il);
                    for (int k = 0; k < m; k++) {
                        osobnik[j][k] = tours_metoda_przyleglosciowa_turniej[los][k];
                    }
                    osobnik[j][m] = tours_metoda_przyleglosciowa_turniej[los][m];
                }
                int jj = 0;
                double najlepszyy = osobnik[0][m];
                for (int j = 1; j < ileturn; j++) {
                    if (najlepszyy >= osobnik[j][m]) {
                        najlepszyy = osobnik[j][m];
                        jj = j;
                    }
                }
                for (int k = 0; k < m; k++) {
                    tours_metoda_przyleglosciowa_przedmutacja[i][k] = (int) osobnik[jj][k];
                }
                tours_metoda_przyleglosciowa_przedmutacja[i][m] = (int) osobnik[jj][m];
            }
            System.out.println("\n Tablica po selekcji przed mutacją");
            for (int i = 0; i < il; i++) {
                System.out.println();
                for (int j = 0; j < m; j++) {
                    System.out.print(tours_metoda_przyleglosciowa_przedmutacja[i][j] + " ");
                }
            }
for (int i = 0; i < il; i++) {
                for (int j = 0; j < m; j++) {
                    tours_metoda_przyleglosciowa_mutacja[i][j]=tours_metoda_przyleglosciowa_przedmutacja[i][j];
                }
            }
            
///////////////////////////////////////////////////////////////////////////////////
            //mutacja 
            for (int i = 0; i < il; i++) {
                double rm = rand.nextDouble();
                if (rm < pm) {

                    int m1 = rand.nextInt(m);
                    int m2 = rand.nextInt(m);
                    if (m1 == m2) {
                        i--;
                    } else {
                        int zmienna = tours_metoda_przyleglosciowa_mutacja[i][m1];
                        tours_metoda_przyleglosciowa_mutacja[i][m1] = tours_metoda_przyleglosciowa_mutacja[i][m2];
                        tours_metoda_przyleglosciowa_mutacja[i][m2] = zmienna;
                for (int q = 0; q < m; q++) {

                    int zmienna_index = q;
                    int zmienna_wartosc = tours_metoda_przyleglosciowa_mutacja[i][q];
                    for (int j = 0; j < m; j++) {
                        if (tours_metoda_przyleglosciowa_mutacja[i][j] == zmienna_index && zmienna_wartosc == j) {
                            for (int l = 0; l < m; l++) {
                                tours_metoda_przyleglosciowa_mutacja[i][l] =  tours_metoda_przyleglosciowa_przedmutacja[i][l];
                            }
                            i--;

                        }
                    }
                }
            }    
                    
                }
            }
            
            System.out.println("\n Tablica po selekcji po mutacji");
            for (int i = 0; i < il; i++) {
                System.out.println();
                for (int j = 0; j < m; j++) {
                    System.out.print(tours_metoda_przyleglosciowa_mutacja[i][j] + " ");
                }
            }
            
            
/*
            //sprawdzanie cyklów
           
            System.out.println();
            for (int i = 0; i < il; i++) {
                System.out.println();
                for (int j = 0; j < m; j++) {
                    System.out.print(tours_metoda_przyleglosciowa_mutacja[i][j] + " ");
                }
            }
            
            int potomek[][]=new int[il][m];
            int wskaznik=rand.nextInt(m);
            for(int i=0;i<il/2;i++)
            {
                int rodzic1=rand.nextInt(il);
                int rodzic2=rand.nextInt(il);
                
                for(int j=0;j<m;j++)
                {
                    if(i%2==0){
                    potomek[i][j]=tours_metoda_przyleglosciowa_mutacja[rodzic1][wskaznik];
                    wskaznik=tours_metoda_przyleglosciowa_mutacja[rodzic1][wskaznik];
                    }
                    if(i%2!=0)
                    {
                     potomek[i][j]=tours_metoda_przyleglosciowa_mutacja[rodzic1][wskaznik];
                    wskaznik=tours_metoda_przyleglosciowa_mutacja[rodzic1][wskaznik];   
                    }
                    for (int q = 0; q < j; q++) {

                    int zmienna_index = q;
                    int zmienna_wartosc = potomek[i][q];
                    for (int k = 0; k < j; k++) {
                        if (potomek[i][k] == zmienna_index && zmienna_wartosc == k) {
                            j--;
                                wskaznik=rand.nextInt(m);

                        }
                    }
                }
                    
                }
            }
            
            
            */
            
//sukcesja
////////////////////////////////////////////////////////////////////////////////////////////////////
            int ilc = il + il;
            int taboperator[][] = new int[ilc][m];
            int tabwylosowane[] = new int[ilc];

            for (int i = 0; i < ilc; i++) {
                tabwylosowane[i] = 0;
            }
            for (int i = 0; i < il; i++) {
                for (int j = 0; j < m; j++) {
                    taboperator[i][j] = tours_metoda_przyleglosciowa_mutacja[i][j];
                }
            }
            for (int i = 0; i < il; i++) {
                for (int j = 0; j < m; j++) {

                    taboperator[il + i][j] = tours_metoda_przyleglosciowa_turniej[i][j];
                }
            }
            for (int i = 0; i < il; i++) {
                int rand1 = 0;
                do {//losujemy osobniki z oper. genetycznych
                    rand1 = rand.nextInt(ilc);
                } while (tabwylosowane[rand1] == 1);
                tabwylosowane[rand1] = 1;
                for (int j = 0; j < m; j++) {
                    tours_metoda_przyleglosciowa_turniej[i][j] = taboperator[rand1][j];
                }
            }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //obliczanie koncowej odleglosci
            for (int i = 0; i < il; i++) {
                double odleglosc_tras_ = 0;
                for (int j = 0; j < m; j++) {

                    double odl_X = Math.abs(Cities[j][0] - Cities[tours_metoda_przyleglosciowa_turniej[i][j]][0]);
                    double odl_Y = Math.abs(Cities[j][1] - Cities[tours_metoda_przyleglosciowa_turniej[i][j]][1]);
                    odleglosc_tras_ += Math.sqrt((odl_X * odl_X) + (odl_Y * odl_Y));
                }
                odleglosc_tras[i] = odleglosc_tras_;
            }

            for (int i = 0; i < il; i++) {
                tours_metoda_przyleglosciowa_turniej[i][m] = (int) odleglosc_tras[i];
            }

        }

        int temp = 200000;
        int trasak[] = new int[m];
        for (int i = 0; i < tours_metoda_przyleglosciowa_turniej.length; i++) {

            if (temp > tours_metoda_przyleglosciowa_turniej[i][m]) {
                temp = tours_metoda_przyleglosciowa_turniej[i][m];
                for (int j = 0; j < trasak.length; j++) {
                    trasak[j] = tours_metoda_przyleglosciowa_turniej[i][j];
                }
            }

        }
        System.out.println("Trasa początkowa: " + t);
        for (int i = 0; i < m; i++) {
            System.out.print(trasa[i] + " ");
        }
        System.out.println();
        System.out.println("końcowy_wynik: " + temp);
        for (int i = 0; i < m; i++) {
            System.out.print(trasak[i] + " ");
        }

    }
}
