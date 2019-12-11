package com.example.learnkorean;

import java.util.HashMap;

public class vocabitem {

    public static HashMap<String, String> characters = new HashMap<String, String>();
    public static HashMap<String, String> wordlets = new HashMap<String, String>();
    public static HashMap<String, String> words = new HashMap<String, String>();

    public vocabitem() {
        characters.put("ㄱ", "gi-euk");
        characters.put("ㄴ", "ni-eun");
        characters.put("ㄷ", "di-geut");
        characters.put("ㄹ", "ri-eul");
        characters.put("ㅁ", "mi-eum");
        characters.put("ㅂ", "bi-eup");
        characters.put("ㅅ", "si-eot");
        characters.put("ㅇ", "e-eung");
        characters.put("ㅈ", "ji-eut");
        characters.put("ㅊ", "chi-eut");
        characters.put("ㅋ", "ki-euk");
        characters.put("ㅌ", "ti-eut");
        characters.put("ㅍ", "pi-eup");
        characters.put("ㅎ", "hi-eut");
        characters.put("ㅏ", "ah");
        characters.put("ㅑ", "yah");
        characters.put("ㅓ", "euh");
        characters.put("ㅕ", "yuh");
        characters.put("ㅗ", "oh");
        characters.put("ㅛ", "yoh");
        characters.put("ㅜ", "ooh");
        characters.put("ㅠ", "yooh");
        characters.put("ㅡ", "eu");
        characters.put("ㅣ", "ee");

        wordlets.put("가", "gah");
        wordlets.put("나", "nah");
        wordlets.put("다", "dah");
        wordlets.put("라", "rah");
        wordlets.put("마", "mah");
        wordlets.put("바", "bah");
        wordlets.put("사", "sah");
        wordlets.put("아", "aah");
        wordlets.put("자", "jah");
        wordlets.put("차", "chah");
        wordlets.put("카", "kah");
        wordlets.put("타", "tah");
        wordlets.put("파", "pah");
        wordlets.put("하", "hah");

        words.put("다리", "leg");
        words.put("머리", "head");
        words.put("발", "foot");
        words.put("발가락", "toe");
        words.put("손", "hand");
        words.put("손가락", "finger");
        words.put("어깨", "shoulders");
        words.put("무릎", "knees");
        words.put("엄마", "mom");
        words.put("아빠", "dad");
        words.put("할머니", "grandma");
        words.put("할아버지", "grandpa");
        words.put("형", "older brother");
        words.put("동생", "younger brother/sister");
        words.put("누나", "older sister");
        words.put("삼촌", "uncle");
        words.put("안녕하세요", "hello");
        words.put("안녕히가세요", "bye");
        words.put("고맙습니다", "thank you");
    }
}
