package com.example.rivenlee.kotlin_learn_diary.project.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @name： KotlinLearnDiary
 * @author： rivenlee
 * @time： 2022/8/5 2:02 下午
 * @description：
 */
public class SBPaoWang extends AppCompatActivity {

    String jsonStr = " {\n" +
            "    \"previewHeight\":1024,\n" +
            "    \"previewVideoLength\":0,\n" +
            "    \"previewWidth\":576,\n" +
            "    \"sceneIn\":0,\n" +
            "    \"sceneOut\":0,\n" +
            "    \"videoList\":[\n" +
            "        {\n" +
            "            \"audioPath\":\"/data/user/0/com.ss.android.ugc.aweme/files/shortvideo/draft/26e93801-e1dd-467c-ad3b-72cbb8cf9e96/multi_edit/1_frag_a\",\n" +
            "            \"videoCutInfo\":{\n" +
            "                \"end\":13071,\n" +
            "                \"rotate\":0,\n" +
            "                \"speed\":1,\n" +
            "                \"start\":0\n" +
            "            },\n" +
            "            \"videoFileInfo\":{\n" +
            "                \"bitrate\":0,\n" +
            "                \"codecType\":-1,\n" +
            "                \"duration\":13071,\n" +
            "                \"fps\":-100,\n" +
            "                \"gop\":-1,\n" +
            "                \"height\":1024,\n" +
            "                \"keyFrameCount\":-1,\n" +
            "                \"width\":576\n" +
            "            },\n" +
            "            \"videoPath\":\"/data/user/0/com.ss.android.ugc.aweme/files/shortvideo/draft/26e93801-e1dd-467c-ad3b-72cbb8cf9e96/multi_edit/1_frag_v\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            Object ja = jsonObject.getJSONArray("videoList");
            Log.e("sb pao wang !", ja.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
