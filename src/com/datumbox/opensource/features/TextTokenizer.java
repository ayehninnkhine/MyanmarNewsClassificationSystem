/* 
 * Copyright (C) 2014 Vasilis Vryniotis <bbriniotis at datumbox.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.datumbox.opensource.features;

import com.datumbox.opensource.dataobjects.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * TextTokenizer class used to tokenize the texts and store them as Document
 * objects.
 * 
 * @author Vasilis Vryniotis <bbriniotis at datumbox.com>
 * @see <a href="http://blog.datumbox.com/developing-a-naive-bayes-text-classifier-in-java/">http://blog.datumbox.com/developing-a-naive-bayes-text-classifier-in-java/</a>
 */
public class TextTokenizer {
    
    /**
     * Preprocess the text by removing punctuation, duplicate spaces and 
     * lowercasing it.
     * 
     * @param text
     * @return 
     * @throws java.io.IOException 
     */
    public static String preprocess(String text) throws IOException {
        
        text=TextTokenizer.normalize(text);
        text=text.replaceAll("__","_");
      // System.out.println(text);
        URL url=TextTokenizer.class.getResource("/datasets2/stopword.txt");
        Reader fileReader = new InputStreamReader(url.openStream(), Charset.forName("UTF-8"));
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(text.contains(line))
                    text=text.replaceAll(line,"_");
            }
        }
        return text;
    }
    
    /**
     * A simple method to extract the keywords from the text. For real world 
     * applications it is necessary to extract also keyword combinations.
     * 
     * @param text
     * @return 
     */
    public static String[] extractKeywords(String text) {
        return text.split("_");
    }
    
    /**
     * Counts the number of occurrences of the keywords inside the text.
     * 
     * @param keywordArray
     * @return 
     */
    public static Map<String, Integer> getKeywordCounts(String[] keywordArray) {
        Map<String, Integer> counts = new HashMap<>();
        
        Integer counter;
        for(int i=0;i<keywordArray.length;++i) {
            counter = counts.get(keywordArray[i]);
            if(counter==null) {
                counter=0;
            }
            counts.put(keywordArray[i], ++counter); //increase counter for the keyword
        }
        
        return counts;
    }
    
    /**
     * Tokenizes the document and returns a Document Object.
     * 
     * @param text
     * @return 
     */
    public static Document tokenize(String text) throws IOException {
       String preprocessedText = preprocess(text);
       // String preprocessedText=text;
        String[] keywordArray = extractKeywords(preprocessedText);
        
        Document doc = new Document();
        doc.tokens = getKeywordCounts(keywordArray);
        return doc;
    }
      public static String normalize(String inputStr)
    {
        inputStr=inputStr.replaceAll("။", "");
        inputStr=inputStr.replaceAll("၊","");
        inputStr=inputStr.replaceAll("\\d","");
        inputStr=inputStr.replaceAll("[\\[\\](){}]","");
        inputStr=inputStr.replaceAll("\\,", "");
        inputStr=inputStr.replaceAll("\"","");
        inputStr=inputStr.replaceAll("“", "");
        inputStr=inputStr.replaceAll("”", "");
        inputStr=inputStr.replaceAll("‘‘", "");
        inputStr=inputStr.replaceAll("’’", "");
        inputStr=inputStr.replaceAll("’", "");
        inputStr=inputStr.replaceAll("‘", "");
        inputStr=inputStr.replaceAll("\\/", "");
        inputStr=inputStr.replaceAll("#", "");
        inputStr=inputStr.replaceAll("-", "");
        inputStr=inputStr.replaceAll("““","");
        inputStr=inputStr.replaceAll("””", "");
        inputStr=inputStr.replaceAll("\\.","");
        inputStr=inputStr.replaceAll("[\u1040-\u1049]","");
        return inputStr;
        
    }
}
