package com.udacity.gradle.builditbigger;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class MainActivityTest {
    @Test
    public void testAsyncTaskRetrievesString() {
        try {
            assertNotNull(new EndpointsAsyncTask(new OnEventListener() {
                @Override
                public void onComplete(String result) {
                }
            }).execute().get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}