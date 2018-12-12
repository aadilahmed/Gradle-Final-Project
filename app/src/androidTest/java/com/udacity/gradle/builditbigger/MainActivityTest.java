package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;

import com.example.jokewizard.JokeCreator;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainActivityTest {
    private MyApi myApiService = null;

    @Before
    public void setUp() {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }
    }

    @Test
    public void testAsyncTaskRetrievesString() {
        try {
            assertNotEquals("", myApiService.tellJoke("Funny joke test").execute().getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}