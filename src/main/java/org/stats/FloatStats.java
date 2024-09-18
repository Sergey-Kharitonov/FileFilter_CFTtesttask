package org.stats;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class FloatStats {

    static int countFloat = 0;
    static BigDecimal minFloat ;
    static BigDecimal maxFloat ;
    static BigDecimal sumFloat = BigDecimal.ZERO;
    static BigDecimal avgFloat ;

    public void setFloatStats(BigDecimal floatNumber){
        setSumFloat(floatNumber);
        setCountFloat();
        setMinFloat (floatNumber);
        setMaxFloat (floatNumber);
        setAvgFloat (floatNumber);
    }

    public void setSumFloat(BigDecimal sumFloat) {
        FloatStats.sumFloat =  FloatStats.sumFloat.add(sumFloat);

    }
    public void setCountFloat ( ) {
        countFloat ++;
    }
    public void setMinFloat (BigDecimal min) {
        if ( minFloat ==null ||  minFloat.compareTo(min)>0 )   minFloat  = min;

    }
    public void setMaxFloat (BigDecimal max) {
        if (maxFloat ==null || maxFloat.compareTo(max)<0 ) maxFloat=max;
    }

    public void setAvgFloat (BigDecimal avgFloat ) {
        avgFloat = sumFloat.divide(BigDecimal.valueOf(countFloat), RoundingMode.HALF_UP) ;
        FloatStats.avgFloat  = avgFloat ;
    }
}




