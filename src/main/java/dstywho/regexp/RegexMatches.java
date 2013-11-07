package dstywho.regexp;

import java.util.Vector;

public class RegexMatches extends Vector<RegexMatch> {
    
    public String getText(){
        StringBuffer result = new StringBuffer();
        for(RegexMatch match: this){
          result.append(match.getText()); 
        }
        return result.toString();
    }

}
