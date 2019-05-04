package com.ashj.aspectjdemo;

import android.content.Context;

import org.junit.Test;

import androidx.test.InstrumentationRegistry;

import static org.junit.Assert.*;

public class MainActivityTest {

	@Test
	public void useAppContext() {
		// Context of the app under test.
		Context appContext = InstrumentationRegistry.getTargetContext();

		assertEquals("com.ashj.aspectjdemo", appContext.getPackageName());
	}


}