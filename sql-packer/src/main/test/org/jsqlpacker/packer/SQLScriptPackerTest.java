package org.jsqlpacker.packer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SQLScriptPackerTest {

	private static final String SQL = "Select * from employee";
	// assume there is a class MyDatabase
	@Mock
	SQLScriptPacker scriptPacker;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		scriptPacker.main(new String[]{SQL});
		  // test that the query() method on the 
	    // mock object was called
		SQLScriptPacker testSqlPackager = Mockito.mock(SQLScriptPacker.class);
		  // define return value for method getUniqueId()
		Mockito.when(testSqlPackager.createPackage(Matchers.eq(SQL))).thenReturn(null);
	}
}
