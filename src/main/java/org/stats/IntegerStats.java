package org.stats;

import lombok.Data;

@Data
public class IntegerStats {
    static int countInteger = 0;
    static Long minInteger ;
    static Long maxInteger ;
    static Long sumInteger = 0L;
    static Long avgInteger ;

    public void setIntegerStats(Long integerNumber){
        setSumInteger(integerNumber);
        setCountInteger();
        setMinInteger(integerNumber);
        setMaxInteger(integerNumber);
        setAvgInteger(integerNumber);
    }
    public void setSumInteger(Long sumInteger) {
        IntegerStats.sumInteger += sumInteger;
    }
    public void setCountInteger( ) {
        countInteger++;
    }
    public void setMinInteger(Long min) {
        if ( minInteger==null || minInteger>min )   minInteger = min;
    }
    public void setMaxInteger(Long max) {
        if (maxInteger==null || maxInteger<max) maxInteger =  max;
    }
    public void setAvgInteger(Long avgInteger) {
        avgInteger = sumInteger/countInteger;
        IntegerStats.avgInteger = avgInteger;
    }
}
