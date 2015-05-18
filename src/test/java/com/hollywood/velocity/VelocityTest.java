package com.hollywood.velocity;

import static org.junit.Assert.*;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

public class VelocityTest {
	
	@Test
	public void helloWorldTest() throws Exception {
		/*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        /*  next, get the Template  */
        Template t = ve.getTemplate( "src/test/resources/helloworld.html" );	       
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name", "Velocity!!!");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() );    
	}

}
