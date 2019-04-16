package com.example.yangyang.gp_health_aid.db;

import com.example.yangyang.gp_health_aid.bean.Passage;

public class HistoryDB {
    private static String [] passage_uri  = {
    };

    private static String [] passage_title = {

    };

    private static String [] pic_uri = {

    };


    public static void formPassage(){

        if(passage_title.length>0) {
            for (int i = 0; i < passage_title.length; i++) {
                Passage passage = new Passage();
                passage.setPassage_uri(passage_uri[i]);
                passage.setTitle(passage_title[i]);
                passage.setPic_uri(pic_uri[i]);
                passage.save();
            }
        }

    }

}
