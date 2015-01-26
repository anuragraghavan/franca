package org.franca.connectors.idl.tests;

import java.io.File;
import java.io.IOException;

import org.franca.connectors.idl.Franca2IdlConverter;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class TestStruct extends FileContentComparator{
	@Test
	public void testAttributes() throws IOException{
		Franca2IdlConverter converter = new Franca2IdlConverter("testcases/model/TestStruct.fidl");
		CharSequence generateContents = converter.generateContents();
		try {
			Files.write(generateContents, new File("testcases/testResult/TestStruct.idl"), Charsets.UTF_8);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(generateContents);
		compare("TestStruct.idl");

	}

	

}
 