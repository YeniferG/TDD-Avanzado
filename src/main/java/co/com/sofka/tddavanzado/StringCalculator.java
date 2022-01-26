package co.com.sofka.tddavanzado;

import java.util.ArrayList;

public class StringCalculator {

    public int add(String values) throws Exception {

        if(values.length() > 0) {
            int temp;
            String delimiter = null;
            try {
                temp = Integer.parseInt("" + values.charAt(0));
            } catch(Exception e) {
                if(("" + values.charAt(0)) == "-") {
                    delimiter = null;
                } else {
                    if(("" + values.charAt(0)).equals("[")) {
                        delimiter = "/";
                    }else{
                        delimiter = "" + values.charAt(0);}
                }
            }

            String[] splittedList=values.split("");
            String mensaje="";
            boolean aux=true;
            for(int i=0;i<splittedList.length;i++){
                if (aux){
                    if (!splittedList[i].equals("[")){
                        mensaje+=splittedList[i];
                    }else{
                        mensaje+="/";
                        aux=false;
                    }
                }else{
                    if (splittedList[i].equals("]")){
                        aux=true;
                    }
                }
            }

            String[] splittedList2 = null;
            if(delimiter != null) {
                splittedList2 = mensaje.substring(1, mensaje.length()).split(delimiter);
            } else {
                splittedList2 = mensaje.split("[,|\n|#|/]");
            }

            ArrayList<Integer> numberList = new ArrayList<Integer>();
            int accumulator = 0;
            for(String element: splittedList2) {
                int tempValue = Integer.parseInt(element);
                if(tempValue < 0) {
                    throw new Exception("NegativeNumberException");
                }
                if(tempValue > 1000) {
                    continue;
                }
                numberList.add(tempValue);
            }
            for(Integer number: numberList) {
                accumulator += number;
            }
            return accumulator;
        }
        return 0;
    }

}
