package com.udacity.gradle.builditbigger;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class MainActivityTest {
    @Test
    public void testAsyncTaskRetrievesString() {
        String result = null;
        EndpointsAsyncTask task = new EndpointsAsyncTask(new OnEventListener() {
            @Override
            public void onComplete(String result) {
            }
        });
        task.execute();

        try {
            result = task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(result);
        assertNotEquals("", result);
    }
}