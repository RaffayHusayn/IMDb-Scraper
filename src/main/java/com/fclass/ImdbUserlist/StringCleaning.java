package com.fclass.ImdbUserlist;

import java.util.List;

public class StringCleaning {

    public void stringSplitor(String combinedString, List<String>directorList, List<String>castList){
        if(!combinedString.equals("")){
            char firstChar = combinedString.charAt(0);
            if( firstChar== ('D')){
               directorAndCastSplitor(combinedString,directorList,castList);
            }else if(firstChar == 'S'){
                starSplitor(combinedString, castList);
            }
            else{
                directorList.add("some problem");
                castList.add("some problem");
            }

        }
    }

    public void directorAndCastSplitor(String combinedString, List<String>directorList, List<String>castList) {
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


        } catch (Exception e) {

                e.printStackTrace();
        }
    }
    public void starSplitor(String combinedString , List<String> stars){
        try{
            String[] cast = combinedString.replace("Stars: ", "").split(",", 15);
            for(String c:cast){
                stars.add(c.strip());
            }

        } catch(Exception e){
            e.printStackTrace();

        }
    }
}
