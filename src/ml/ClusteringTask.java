package ml;
/**
 * Chapter 3: Classification Task
 * 
 * This example shows how to implement a basic clustering model in Weka and 
 * evaluate its performance. This task uses the Bank dataset:
 * https://archive.ics.uci.edu/ml/datasets/Energy+efficiency
 * 
 * @author Bostjan Kaluza, http://bostjankaluza.net
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
	
public class ClusteringTask {


	public static void main(String args[]) throws Exception{
		
		//load data
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("C:\\Users\\ALAOUI\\eclipse-workspace\\ScrapUi\\data\\out5.csv"));
		Instances data = loader.getDataSet();
		
		// new instance of clusterer
		EM model = new EM();
		// build the clusterer
		model.buildClusterer(data);
		System.out.println(model);
		
		double logLikelihood = ClusterEvaluation.crossValidateModel(model, data, 10, new Random(1));
		System.out.println(logLikelihood);


	}

}
