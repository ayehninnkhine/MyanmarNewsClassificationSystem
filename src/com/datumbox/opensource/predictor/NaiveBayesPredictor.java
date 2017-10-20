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
package com.datumbox.opensource.predictor;

import com.ahk.wordsegmenter.BurmeseWordSegmenter;
import com.datumbox.opensource.classifiers.NaiveBayes;
import com.datumbox.opensource.dataobjects.FeatureStats;
import com.datumbox.opensource.dataobjects.NaiveBayesKnowledgeBase;
import com.datumbox.opensource.features.FeatureWord;
import com.datumbox.opensource.features.TextTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vasilis Vryniotis <bbriniotis at datumbox.com>
 * @see <a href="http://blog.datumbox.com/developing-a-naive-bayes-text-classifier-in-java/">http://blog.datumbox.com/developing-a-naive-bayes-text-classifier-in-java/</a>
 */
public class NaiveBayesPredictor {

    /**
     * Reads the all lines from a file and places it a String array. In each 
     * record in the String array we store a training example text.
     * 
     * @param url
     * @return
     * @throws IOException 
     */
    public static String[] readLines(URL url) throws IOException {

        Reader fileReader = new InputStreamReader(url.openStream(), Charset.forName("UTF-8"));
        List<String> lines;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[lines.size()]);
    }
    
    /**
     * Main method
     * 
     * @param st
     * @return 
     * @throws java.io.IOException
     */
    public String predictClass(String st) throws IOException {
        //map of dataset files
        Map<String, URL> trainingFiles = new HashMap<>();
        trainingFiles.put("Politic", NaiveBayesPredictor.class.getResource("/datasets2/Politic.txt"));
        trainingFiles.put("Business", NaiveBayesPredictor.class.getResource("/datasets2/Business.txt"));
        trainingFiles.put("Sport", NaiveBayesPredictor.class.getResource("/datasets2/Sport.txt"));
        trainingFiles.put("Entertainment", NaiveBayesPredictor.class.getResource("/datasets2/Entertainment.txt"));
        
        //loading examples in memory
        Map<String, String[]> trainingExamples = new HashMap<>();
        for(Map.Entry<String, URL> entry : trainingFiles.entrySet()) {
            trainingExamples.put(entry.getKey(), readLines(entry.getValue()));
        }
        
        //train classifier
        NaiveBayes nb = new NaiveBayes();
        nb.setChisquareCriticalValue(2.366); //0.50 pvalue
        nb.train(trainingExamples);
        
        //get trained classifier knowledgeBase
        NaiveBayesKnowledgeBase knowledgeBase = nb.getKnowledgeBase();
        
        nb = null;
        trainingExamples = null;
        
        
        //Use classifier
        nb = new NaiveBayes(knowledgeBase);
        String outputEn = nb.predict(st);
        //System.out.format("The sentense \"%s\" was classified as \"%s\".%n", exampleEn, outputEn);
        //System.out.println(outputEn);
        return outputEn;
    }
    public FeatureStats trainClassifier() throws IOException
    {
        Map<String, URL> trainingFiles = new HashMap<>();
        trainingFiles.put("Politic", NaiveBayesPredictor.class.getResource("/datasets2/Politic.txt"));
        trainingFiles.put("Business", NaiveBayesPredictor.class.getResource("/datasets2/Business.txt"));
        trainingFiles.put("Sport", NaiveBayesPredictor.class.getResource("/datasets2/Sport.txt"));
        trainingFiles.put("Entertainment", NaiveBayesPredictor.class.getResource("/datasets2/Entertainment.txt"));
        
        //loading examples in memory
        Map<String, String[]> trainingExamples = new HashMap<>();
        for(Map.Entry<String, URL> entry : trainingFiles.entrySet()) {
            trainingExamples.put(entry.getKey(), readLines(entry.getValue()));
        }
        
        //train classifier
        NaiveBayes nb = new NaiveBayes();
        nb.setChisquareCriticalValue(2.366); //0.50 pvalue
        FeatureStats features=nb.train(trainingExamples);
        return features;
    }
    public Map<String,Double> getCategoryScores(String text) throws IOException
    {
        Map<String, URL> trainingFiles = new HashMap<>();
        trainingFiles.put("Politic", NaiveBayesPredictor.class.getResource("/datasets2/Politic.txt"));
        trainingFiles.put("Business", NaiveBayesPredictor.class.getResource("/datasets2/Business.txt"));
        trainingFiles.put("Sport", NaiveBayesPredictor.class.getResource("/datasets2/Sport.txt"));
        trainingFiles.put("Entertainment", NaiveBayesPredictor.class.getResource("/datasets2/Entertainment.txt"));
        
        //loading examples in memory
        Map<String, String[]> trainingExamples = new HashMap<>();
        for(Map.Entry<String, URL> entry : trainingFiles.entrySet()) {
            trainingExamples.put(entry.getKey(), readLines(entry.getValue()));
        }
        
        //train classifier
        NaiveBayes nb = new NaiveBayes();
        nb.setChisquareCriticalValue(2.366); //0.50 pvalue
	nb.train(trainingExamples);
        
        //get trained classifier knowledgeBase
        NaiveBayesKnowledgeBase knowledgeBase = nb.getKnowledgeBase();
        
        nb = null;
        trainingExamples = null;
        
        
        //Use classifier
        nb = new NaiveBayes(knowledgeBase);
         Map<String, Double> predictionScores=nb.getScores(text);
        return predictionScores;
    }
    public List<FeatureWord> getTestFeatures(String text) throws IOException
    {
 
        Map<String, URL> trainingFiles = new HashMap<>();
        trainingFiles.put("Politic", NaiveBayesPredictor.class.getResource("/datasets2/Politic.txt"));
        trainingFiles.put("Business", NaiveBayesPredictor.class.getResource("/datasets2/Business.txt"));
        trainingFiles.put("Sport", NaiveBayesPredictor.class.getResource("/datasets2/Sport.txt"));
        trainingFiles.put("Entertainment", NaiveBayesPredictor.class.getResource("/datasets2/Entertainment.txt"));
        
        //loading examples in memory
        Map<String, String[]> trainingExamples = new HashMap<>();
        for(Map.Entry<String, URL> entry : trainingFiles.entrySet()) {
            trainingExamples.put(entry.getKey(), readLines(entry.getValue()));
        }
        
        //train classifier
        NaiveBayes nb = new NaiveBayes();
        nb.setChisquareCriticalValue(2.366); //0.50 pvalue
	nb.train(trainingExamples);
        
        //get trained classifier knowledgeBase
        NaiveBayesKnowledgeBase knowledgeBase = nb.getKnowledgeBase();
        
        nb = null;
        trainingExamples = null;
        
        
        //Use classifier
        nb = new NaiveBayes(knowledgeBase);
        List<FeatureWord> featureList=nb.getTestFeaturesByList(text);
        return featureList;
    }
    public String getPreprocessedText(String st) throws IOException
    {
        String preprocessedString="";
        BurmeseWordSegmenter wordsegmenter=new BurmeseWordSegmenter();
        preprocessedString=wordsegmenter.segment(st);
        preprocessedString=TextTokenizer.preprocess(preprocessedString);
        return preprocessedString;
    }
}
