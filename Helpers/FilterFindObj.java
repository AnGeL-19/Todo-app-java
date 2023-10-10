package mx.com.gm.HolaMundo.Helpers;

import mx.com.gm.HolaMundo.models.Category;

import java.util.ArrayList;
import java.util.List;

public class FilterFindObj {



    public static List<Category> filterFindTwoObjets(List<Category> objFilter, List<Category> objFind){

        List<Category> newObj = new ArrayList<>();

        for (int i = 0; i < objFilter.toArray().length; i++) {

            System.out.println(objFilter.get(i));

            for (int j = 0; j < objFind.toArray().length; j++) {


                if ( objFilter.get(i).getId_category() == objFind.get(j).getId_category()  ){
                    break;
                }

                if ( objFilter.get(i).getId_category() != objFind.get(j).getId_category()  ){
                    newObj.add(objFilter.get(i));

                    break;
                }

            }

        }

        return newObj;

    }


}
