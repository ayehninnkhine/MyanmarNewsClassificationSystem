/*
 * Copyright (C) 2017 ahk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.datumbox.opensource.test;

import com.datumbox.opensource.features.FeatureWord;
import com.datumbox.opensource.predictor.NaiveBayesPredictor;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ahk
 */
public class TestFeatureTest {
    public static void main(String args[]) throws IOException
    {
        NaiveBayesPredictor obj=new NaiveBayesPredictor();
        List<FeatureWord> test=obj.getTestFeatures("ဂွါဒီယိုလာ_သည်_လောလောဆယ်_တွင်_ကမ္ဘာပေါ်_၌_အကောင်းဆုံး_နည်းပြ_တစ်ဦး_ဖြစ်သည်_ဟု_ဇာ_ဗီ_က_ပြောသည်_။_\n" +
"ဂျာမန်_ကလပ်_မိန့်ဇ်_ဂိုးသမား_လော_ရစ်_ကာ_ရီ_ယပ်စ်_ကို_လီဗာပူး_အသင်း_က_ဒေါ်လာ_ခုနစ်_သန်း_ဖြင့်_ခေါ်_ယူ_လိုက်_သည်_။_\n" +
"ကာ_ရီ_ယပ်စ်_သည်_လီဗာပူး_တွင်_နံပါတ်_(_၁_)_ဂျာစီ_ဝတ်ဆင်_မည်_ဖြစ်_ကာ_လက်ရှိ_လီဗာပူး_ပထမ_ဦးစားပေး_ဂိုးသမား_ဆိုင်မွန်_မစ်_နို_လက်_က_နံပါတ်_(_၂၂_)_ဂျာစီ_ဆက်လက်_ဝတ်ဆင်_မည်_ဖြစ်သည်_။_");
        for(FeatureWord w: test)
        {
            System.out.println(w.getWord()+"{"+w.getCategory()+"}");
           
        }
    }
}
