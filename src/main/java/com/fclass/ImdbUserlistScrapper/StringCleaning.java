package com.fclass.ImdbUserlistScrapper;

import java.util.List;

public class StringCleaning {
    public int directorAndCastSplitor(String combinedString, List<String>directorList, List<String>castList) {
        try {
            String[] split = combinedString.split("\\|", 2);
            String[] director = split[0].replace("Director: ", "").replace("Directors: ", "").split(",", 4);
            String[] cast = split[1].replace(" Stars: ", "").split(",", 15);
            for (String s : cast) {
                castList.add(s.strip());
            }
            for (String d : director) {
                directorList.add(d.strip());
            }


            return 1;
        } catch (Exception e) {

                e.printStackTrace();
                return 0;
        }
    }
}
