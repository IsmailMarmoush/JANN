package com.marmoush.jann.chart;

import java.util.List;

import org.jblas.DoubleMatrix;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartUtils {
    public static XYSeries xySeries(String key, double[][] data) {
	XYSeries series = new XYSeries(key);
	for (int row = 0; row < data.length; row++) {
	    series.add(data[row][0], data[row][1]);
	}
	return series;
    }

    public static XYSeries xySeries(String key, List<Double> x, List<Double> y) {
	// assert (x.size()==y.size();
	XYSeries series = new XYSeries(key);
	for (int row = 0; row < x.size(); row++) {
	    series.add(x.get(row), y.get(row));
	}
	return series;
    }

    public static XYSeries xySeries(String key, DoubleMatrix xyMtrx,
	    int xColIdx, int yColdIdx) {

	XYSeries series = new XYSeries(key);
	for (int row = 0; row < xyMtrx.rows; row++) {
	    series.add(xyMtrx.get(row, xColIdx), xyMtrx.get(row, yColdIdx));
	}
	return series;
    }

    public static XYSeriesCollection getXYSeriesCollection(
	    XYSeries... seriesList) {
	XYSeriesCollection dataset = new XYSeriesCollection();
	for (XYSeries xySeries : seriesList) {
	    dataset.addSeries(xySeries);
	}
	return dataset;
    }
}
