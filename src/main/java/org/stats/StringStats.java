package org.stats;

import lombok.Data;

@Data
public class StringStats {
    static int countString = 0;
    static int minString ;
    static int maxString ;

    public void setStringStats(String string){
        int stringNumber = string.length();
        setCountString();
        setMinString(stringNumber);
        setMaxString(stringNumber);
    }

    public void setCountString( ) {
        countString++;
    }
    public void setMinString(int min) {
        if ( minString==0 || minString>min ) minString = min;
    }
    public void setMaxString(int max) {
        if (maxString==0 || maxString<max) maxString =  max;
    }

}

