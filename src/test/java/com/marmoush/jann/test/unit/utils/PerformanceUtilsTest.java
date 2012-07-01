/**
 * 
 */
package com.marmoush.jann.test.unit.utils;

import static org.junit.Assert.assertTrue;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;
import org.junit.Before;
import org.junit.Test;

import com.marmoush.jann.utils.PerformanceUtils;
import com.marmoush.jann.utils.TransfereUtils;

/**
 * @author marmoush
 * 
 */
public class PerformanceUtilsTest {
    private DoubleMatrix output;
    private DoubleMatrix target;    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	output = DoubleMatrix.valueOf("1; 2; 3");
	target= DoubleMatrix.valueOf("2; 4 ;6");
    }

    /**
     * Test method for
     * {@link com.marmoush.jann.utils.PerformanceUtils#mae(org.jblas.DoubleMatrix)}
     * .
     */
    @Test
    public void testMae() {
	double p = PerformanceUtils.mae(output,target);
	assertTrue("Performance is:" + p, p == 2);
    }
    @Test
    public void testLogRgr(){
	DoubleMatrix transf=TransfereUtils.logsig(output);
	double p = PerformanceUtils.LogRgr(transf,target);
	System.out.println(p);
	
	
	
    }
    /**
     * Test method for
     * {@link com.marmoush.jann.utils.PerformanceUtils#mse(org.jblas.DoubleMatrix)}
     * .
     */
    @Test
    public void testMse() {
	double p = PerformanceUtils.mse(output,target);
	p = Math.round(p * 10000.0) / 10000.0;
	assertTrue("Performance is:" + p, p == 4.6667);
    }

    /**
     * Test method for
     * {@link com.marmoush.jann.utils.PerformanceUtils#sse(org.jblas.DoubleMatrix)}
     * .
     */
    @Test
    public void testSse() {
	double p = PerformanceUtils.sse(output,target);
	assertTrue("Performance is:" + p, p == 14);
    }

}
