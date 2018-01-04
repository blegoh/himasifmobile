package com.example.brianr.himasifmobile;

import android.text.Html;

import java.util.ArrayList;

/**
 * Created by Brian R on 03/01/2018.
 */

public class Random {
    int sisa;
    int jumlah;
    int kelompok;
    int setiap;
    String matkul;

    public Random(String matkul,int jumlah, int kelompok, int setiap, int sisa) {
        this.matkul=matkul;
        this.sisa = sisa;
        this.jumlah = jumlah;
        this.kelompok = kelompok;
        this.setiap = setiap;
    }
    public StringBuffer hitung() {
        ArrayList<Integer> a = new ArrayList<>();
        StringBuffer Result = new StringBuffer();
        try {
//            long St = System.nanoTime();

//            writer = new PrintWriter("Hasil.txt", "UTF-8");

            for (int i = 0; i < jumlah; i++) {
                a.add(i + 1);
            }
            int num = 1;
            Result.append("Nama Matkul\t\t\t\t\t\t\t\t\t\t\t\t : "+matkul+"\n");
            Result.append("Jumlah Mahasiswa\t\t\t\t\t\t : " + a.size()+"\n");
            Result.append("Jumlah Kelompok\t\t\t\t\t\t\t : " + kelompok+"\n");
            Result.append("Jumlah Setiap Kelompok\t : " + setiap+"\n");
            Result.append("Sisa Anggota Kelompok\t\t : " + sisa+"\n\n");
//            Result.append("\n------------------------------\n");
            if (sisa > 0) {
                for (int i = num; i <= sisa; i++) {
                    Result.append("Kelompok - " + i + "\n");
                    for (int j = 0; j < setiap + 1; j++) {
                        if (a.isEmpty()) {
                            continue;
                        }
                        int x = (int) (Math.random() * a.size());
                        Result.append(a.get(x) + "\n");
                        a.remove(x);
                    }
                    num = i + 1;
                    Result.append("\n");
                }
            }
            for (int i = num; i <= kelompok; i++) {
                Result.append("Kelompok - " + i + "\n");
                for (int j = 0; j < setiap; j++) {
                    if (a.isEmpty()) {
                        continue;
                    }
                    int x = (int) (Math.random() * a.size());
                    Result.append(a.get(x) + "\n");
                    a.remove(x);
                }
                Result.append("\n");
            }
            Result.append(Html.fromHtml("<b>Copyright \u00a9 HIMASIF UNEJ</b>"));
//            Long Ed = System.nanoTime();
//            Result.append("\n\n------------------------------\n\n");
//            String time = String.format("Time Case : %.3f Seconds \n",(float)(Ed - St) / 1000000000);
//            Result.append(time);
//            Time(St, Ed);

//            writer.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
//        File open = new File("Hasil.txt");
//        System.out.println(Result.toString());

        return Result;
    }
}
