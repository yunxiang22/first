package test;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.clusterers.Clusterer;
import weka.clusterers.Cobweb;
import weka.clusterers.DensityBasedClusterer;
import weka.clusterers.EM;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.FarthestFirst;
import weka.clusterers.FilteredClusterer;
import weka.clusterers.HierarchicalClusterer;
import weka.clusterers.MakeDensityBasedClusterer;
import weka.clusterers.SimpleKMeans;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * An example class that shows the use of Weka clusterers from Java.
 */

public class ClusteringDemo {
  /**
   * Run clusterers
   *
   * @param filename      the name of the ARFF file to run on
   */
  public ClusteringDemo(String filename) throws Exception {
    ClusterEvaluation eval;
    Instances               data;
    String[]                options;
    SimpleKMeans   cl;    // num of clusters set by user
    Cobweb cl2;
    EM cl3;
    FarthestFirst cl4;    // num of clusters set by user
    FilteredClusterer cl5;
    HierarchicalClusterer cl6;
    MakeDensityBasedClusterer cl7;
    
    DataSource source = new DataSource(filename);
    data = source.getDataSet();
    //System.out.println("\n\nImported data:\n\n" + data);
    StringToWordVector filter = new StringToWordVector();
    filter.setInputFormat(data);
    Instances dataFiltered = Filter.useFilter(data, filter);
    //System.out.println("\n\nFiltered data:\n\n" + dataFiltered);
    
    // normal
    //System.out.println("\n--> normal");
    options    = new String[2];
    options[0] = "-t";
    options[1] = filename;
    
    // simple k means
    System.out.println("\n--> simple k means (num of clusters set by user)");
    cl   = new SimpleKMeans();
    cl.setNumClusters(3);
    
    // simple k means
    /*cl.buildClusterer(dataFiltered);
    eval = new ClusterEvaluation();
    eval.setClusterer(cl);
    eval.evaluateClusterer(new Instances(dataFiltered));
    System.out.println("# of clusters: " + eval.getNumClusters());
    //System.out.println(eval.clusterResultsToString());
    for(Double d : eval.getClusterAssignments()) {
    	System.out.println(d);
    }
    */
    
    
    /*// Cobweb
    System.out.println("\n--> Cobweb");
    cl2   = new Cobweb();
    cl2.buildClusterer(dataFiltered);
    eval = new ClusterEvaluation();
    eval.setClusterer(cl2);
    eval.evaluateClusterer(new Instances(dataFiltered));
    System.out.println(eval.clusterResultsToString());
    */
    
    /*// EM
    System.out.println("\n--> EM");
    cl3   = new EM();
    cl3.buildClusterer(dataFiltered);
    eval = new ClusterEvaluation();
    eval.setClusterer(cl3);
    eval.evaluateClusterer(new Instances(dataFiltered));
    System.out.println(eval.clusterResultsToString());
    */
    
    /*// FarthestFirst
    System.out.println("\n--> FarthestFirst");
    cl4   = new FarthestFirst();
    cl4.setNumClusters(3);
    cl4.buildClusterer(dataFiltered);
    eval = new ClusterEvaluation();
    eval.setClusterer(cl4);
    eval.evaluateClusterer(new Instances(dataFiltered));
    System.out.println(eval.clusterResultsToString());
    */
    
    /*// FilteredClusterer
    System.out.println("\n--> FilteredClusterer (num of clusters set by user)");
    cl5   = new FilteredClusterer();
    cl5.setClusterer(cl);
    cl5.buildClusterer(dataFiltered);
    
    eval = new ClusterEvaluation();
    eval.setClusterer(cl5);
    eval.evaluateClusterer(new Instances(dataFiltered));
    System.out.println(eval.clusterResultsToString());
    */
    
    // HierarchicalClusterer
    System.out.println("\n--> HierarchicalClusterer (num of clusters set by user)");
    cl6   = new HierarchicalClusterer();
    cl6.setNumClusters(3);
    cl6.buildClusterer(dataFiltered);
    eval = new ClusterEvaluation();
    eval.setClusterer(cl6);
    eval.evaluateClusterer(new Instances(dataFiltered));
    System.out.println(eval.clusterResultsToString());
    double[] d = eval.getClusterAssignments();
    for(double value : d){
    	System.out.println(value);
    }
    
    /*// MakeDensityBasedClusterer
    System.out.println("\n--> MakeDensityBasedClusterer (num of clusters set by user)");
    cl7   = new MakeDensityBasedClusterer();
    cl7.setNumClusters(3);
    cl7.buildClusterer(dataFiltered);
    eval = new ClusterEvaluation();
    eval.setClusterer(cl7);
    eval.evaluateClusterer(new Instances(dataFiltered));
    System.out.println(eval.clusterResultsToString());
    */
    //System.out.println("# of clusters: " + eval.getNumClusters());

    // density based
    
  }

  /**
   * usage:
   *   ClusteringDemo arff-file
   */
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("usage: " + ClusteringDemo.class.getName() + " <arff-file>");
      System.exit(1);
    }

    new ClusteringDemo(args[0]);
  }
}
