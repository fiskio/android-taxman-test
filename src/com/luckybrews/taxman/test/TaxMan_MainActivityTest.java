package com.luckybrews.taxman.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.luckybrews.taxman.MainActivity;
import com.luckybrews.taxman.R;

public class TaxMan_MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	MainActivity activity;
	 
	public static final int YEAR_COUNT = 13;
	
	public TaxMan_MainActivityTest() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
	}
	
	// check boxes
	public void testTaxYear() {
		
		final Spinner spin = (Spinner) activity.findViewById(R.id.spinnerTY);
		SpinnerAdapter adap = spin.getAdapter();
		
		assertTrue(spin.getOnItemSelectedListener() != null);
	    assertTrue(adap != null);
	    assertEquals(adap.getCount(), YEAR_COUNT);
		
		assertTrue(MainActivity.params.containsKey("yr"));
		String str = MainActivity.params.get("yr");
		assertEquals("2012", str);
	
		assertTrue(MainActivity.params.containsKey("yr"));
		str = MainActivity.params.get("yr");
		assertEquals("2012", str);
	}
	
	public void testBlind() {
		
		String field = "blind";
		final CheckBox check = (CheckBox) activity.findViewById(R.id.checkBlind);

		String str = MainActivity.params.get(field);
		assertEquals(str, null);

		assertFalse(MainActivity.params.containsKey(field));

		TouchUtils.clickView(this, check);

		assertTrue(MainActivity.params.containsKey(field));

		str = MainActivity.params.get(field);
		assertEquals("y", str);
	}

	public void testMarried() {

		String field = "married";
		final CheckBox check = (CheckBox) activity.findViewById(R.id.checkMarried);

		String str = MainActivity.params.get(field);
		assertEquals(str, null);

		assertFalse(MainActivity.params.containsKey(field));

		TouchUtils.clickView(this, check);

		assertTrue(MainActivity.params.containsKey(field));

		str = MainActivity.params.get(field);
		assertEquals("y", str);

	}
	
	public void testNoni() {

		String field = "exNI";
		final CheckBox check = (CheckBox) activity.findViewById(R.id.checkNONI);

		String str = MainActivity.params.get(field);
		assertEquals(str, null);

		assertFalse(MainActivity.params.containsKey(field));

		TouchUtils.clickView(this, check);

		assertTrue(MainActivity.params.containsKey(field));

		str = MainActivity.params.get(field);
		assertEquals("y", str);

	}
	
	public void testStudent() {

		String field = "student";
		final CheckBox check = (CheckBox) activity.findViewById(R.id.checkSL);

		String str = MainActivity.params.get(field);
		assertEquals(str, null);

		assertFalse(MainActivity.params.containsKey(field));

		TouchUtils.clickView(this, check);

		assertTrue(MainActivity.params.containsKey(field));

		str = MainActivity.params.get(field);
		assertEquals("y", str);

	}
	
	// EditText fields
	public void testGross() {
		testEdit("ingr", "40000", R.id.textGross);
	}
	
	public void testDeduction() {
		testEdit("add", "1000", R.id.textDeduction);
	}
	
	public void testPension() {
		testEdit("pension", "15%", R.id.textPension);
	}
	
	public void testChildcare() {
		testEdit("childcare", "12", R.id.textVoucher);
	}
	
	public void testTaxCode() {
		testEdit("code", "012345", R.id.textTaxCode);
	}
	
		
	public void testEdit(String field, String expected, int editText) {

		Instrumentation instrumentation = getInstrumentation();

		
		final EditText edit = (EditText) activity.findViewById(editText);
		
		String str = MainActivity.params.get(field);
		assertEquals("", str);

		assertTrue(MainActivity.params.containsKey(field));

	    TouchUtils.clickView(this, edit);
	    instrumentation.sendStringSync(expected);
		
	    activity.addFields();
	    
		//assertTrue(MainActivity.params.containsKey(field));

		str = MainActivity.params.get(field);
		assertEquals(expected, str);
	
	}
	
	

	
}