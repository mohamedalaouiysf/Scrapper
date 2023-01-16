package ml;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Controller.DbConn;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
import weka.gui.visualize.PlotData2D;
import weka.gui.visualize.ThresholdVisualizePanel;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
public class classification{
	public static  String requete = "SELECT 'Python', 'Java', 'Html', 'Css', 'Js', 'Sql', 'Laravel','NomSociete' "
			+ "UNION ALL SELECT `Python`, `Java`, `Html`,`Css`,`Js`,`Sql`,`Laravel`,`NomSociete` FROM offre  INTO OUTFILE 'C:/Users/ALAOUI/eclipse-workspace/ScrapUi/data/out5.csv' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\r' ";
	public static void classi() {
		DbConn.connecter();
			try {
			   Statement stmt = DbConn.con.createStatement();
			   ResultSet resultats = stmt.executeQuery(requete);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbConn.fermer();
		}
	public static void classifier() throws Exception {
		/*
		 * Load the data
		 */
		 CSVLoader loader = new CSVLoader();
		 loader.setSource(new File("C:\\Users\\ALAOUI\\eclipse-workspace\\ScrapUi\\data\\out5.csv"));
		 Instances data = loader.getDataSet();
		// data.setClassIndex(data.numAttributes()-1);
		 System.out.println(data.toString());
		 
			/*String[] opts = new String[] { "-R", "2" };
			Remove remove = new Remove();
			remove.setOptions(opts);
			remove.setInputFormat(data);
			data = Filter.useFilter(data, remove);*/
			//System.out.println(data.toString());
			// sa permet d afficher par ordre les attributs significatifs
			AttributeSelection attSelect = new AttributeSelection();
		    InfoGainAttributeEval eval = new InfoGainAttributeEval();
		    Ranker search = new Ranker();	
			attSelect.setEvaluator(eval);
			attSelect.setSearch(search);
			attSelect.SelectAttributes(data);
			int[] indices = attSelect.selectedAttributes();
			System.out.println("Selected attributes: "+Utils.arrayToString(indices));
			/*
			 * Build a decision tree
			 */
			
			String[] options = new String[1];
			options[0] = "-U";
			J48 tree = new J48();
			tree.setOptions(options);
			tree.buildClassifier(data);
			System.out.println(tree);
			
			//classify new instance
			double[] vals = new double[data.numAttributes()];
			vals[0] = 0.0; // Python
			vals[1] = 1.0; // java
			vals[2] = 1.0; // html
			vals[3] = 1.0; // Css
			vals[4] = 0.0; // Js
			vals[5] = 0.0; // sql
			vals[6] = 0.0; //Laravel
			Instance myoffer = new DenseInstance(1.0, vals);
			//Assosiate your instance with Instance object in this case dataRaw
			myoffer.setDataset(data); 
			double label = tree.classifyInstance(myoffer);
			System.out.println(data.classAttribute().value((int) label));
			
			/*
			 * Visualize decision tree
			 */
			TreeVisualizer tv = new TreeVisualizer(null, tree.graph(),
			new PlaceNode2());
			JFrame frame = new javax.swing.JFrame("Tree Visualizer");
			frame.setSize(800, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(tv);
			frame.setVisible(true);
			tv.fitToScreen();
			

			/*
			 * Evaluation
			 */

			Classifier cl = new J48();
			Evaluation eval_roc = new Evaluation(data);
			eval_roc.crossValidateModel(cl, data, 10, new Random(1), new Object[] {});
			System.out.println(eval_roc.toSummaryString());
			// Confusion matrix
			double[][] confusionMatrix = eval_roc.confusionMatrix();
			System.out.println(eval_roc.toMatrixString());
	}

}

