package com.lulu.keranjangbelanja;


import java.util.ArrayList;
import java.util.List;

public class KatalogFotoUtil {
    private static final int[] ridArray = {
            R.drawable.foto,
            R.drawable.foto2,
            R.drawable.foto3,
    };

    private static final String[] filenameArray = {
            "foto",
            "foto2",
            "foto3"
    };

    private static List<KatalogFoto> katalogFotoList;

    public static void init(){
        katalogFotoList = new ArrayList<>();
        int nArray = ridArray.length;
        for(int i=0; i<nArray;i++){
            katalogFotoList.add(new KatalogFoto(ridArray[i], filenameArray[i]));
        }
    }

    public static List<KatalogFoto> getKatalogFotoList() {
        return katalogFotoList;
    }

    public static KatalogFoto getKatalogFotoAt(int i){
        return katalogFotoList.get(i);
    }
}

