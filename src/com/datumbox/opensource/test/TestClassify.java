/*
 * Copyright (C) 2016 ahk
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

import com.ahk.wordsegmenter.BurmeseWordSegmenter;
import com.datumbox.opensource.predictor.NaiveBayesPredictor;
import java.io.IOException;

/**
 *
 * @author ahk
 */
public class TestClassify {
    
    public static void main(String args[]) throws IOException
    {
        NaiveBayesPredictor obj=new NaiveBayesPredictor();
        BurmeseWordSegmenter segmenter=new BurmeseWordSegmenter();
         String st="အစိုးရသစ်၏ရင်းနှီးမြှုပ်နှံမှုမူဝါဒတွင်စီးပွားရေးလုပ်ငန်းများကိုအငြင်းပွားဖွယ်သိမ်းယူခြင်းမှအကာအကွယ်ပေးမည်ဟုထည့်သွင်းဖော်ပြထားကြောင်းသတင်းရရှိသည်။\n" +
"အစိုးရသစ်စီးပွားရေးမူဝါဒ၁၂ချက်ကိုအထောက်အကူပြုရန်ရည်ရွယ်၍ရင်းနှီးမြှုပ်နှံမှုမူဝါဒကိုအစိုးရသစ်ကထုတ်ပြန်ခြင်းဖြစ်သည်ဟုဘဏ္ဍာရေးနှင့်စီမံကိန်းဝန်ကြီးဌာနကဆိုသည်။\n" +
"နိုင်ငံတော်၏စီးပွားရေးမူဝါဒ၁၂ချက်ကိုအစိုးရသစ်လက်ထက်တွင်ထုတ်ပြန်ပြီးသုံးလကျော်အကြာ၌အဆိုပါရင်းနှီးမြှုပ်နှံမှုမူဝါဒကိုနိုဝင်ဘာ၁၉ရက်တွင်ထပ်မံထုတ်ပြန်ခြင်းဖြစ်သည်။\n" +
"အဆိုပါမူဝါဒတွင်နိုင်ငံခြားသားလုပ်ငန်းရှင်နှင့်ပြည်တွင်းလုပ်ငန်းရှင်များတန်းတူအခွင့်အရေးပေးမည်ဖြစ်ပြီးအစိုးရ၏ထိန်းကျောင်းမှုသည်လည်းကြို\n" +
"တင်ခန့်မှန်းနိုင်အောင်ဆောင်ရွက်ပေးမည်ဟုအစိုးရသစ်ကကတိပြုထားသည်။နိုင်ငံတော်လုံခြုံရေး၊\n" +
"ယဉ်ကျေးမှုနှင့်လူမှုရေးဆိုင်ရာကိစ္စရပ်များတွင်နိုင်ငံခြားသားများအားခွင့်မပြုကြောင်းနှင့်ခွင့်မပြုခြင်းကိုလည်းပွင့်ပွင့်လင်းလင်းထုတ်ပြန်ကြေညာမည်ဟုဆိုသည်။\n" +
"အဆိုပါမူဝါဒတွင်လက်ရှိအစိုးရသည်ဦးစားပေးဆွဲဆောင်မှုရင်းနှီးမြှုပ်နှံမှုရှစ်မျိုးထုတ်ပြန်ခဲ့သည်။၎င်းတို့မှာတန်ဖိုးမြင့်လယ်ယာထုတ်ကုန်၊နည်းပညာလုပ်ငန်းများ၊\n" +
"အသေးစားအလတ်စားလုပ်ငန်းများနှင့်အခြေခံအဆောက်အအုံဖွံ့ဖြိုးရေးလုပ်ငန်းများ၊ဖွံ့ဖြိုးမှုနည်းပါးသည့်ဒေသများတွင်ရင်းနှီးမြှုပ်နှံမည့်လုပ်ငန်းများ၊\n" +
"အလုပ်အကိုင်အခွင့်အလမ်းဖန်တီးပေးမည့်လုပ်ငန်းများ၊စက်မှုမြို့တော်နှင့်အစုအဖွဲ့စီးပွားရေးလုပ်ငန်းနှင့်ခရီးသွားလုပ်ငန်းများတွင်ရင်းနှီးမြှုပ်နှံမှုလုပ်ငန်းများကို\n" +
"ဦးစားပေးကြိုဆိုမည်ဟုအစိုးရကထုတ်ပြန်သည့်ကြေညာချက်တွင်ဖော်ပြထားသည်။";
         //st=st.replaceAll(" ", "");
         System.out.println(segmenter.segment(st));
        String category=obj.predictClass(segmenter.segment(st));
        System.out.println(category);
    }
}
