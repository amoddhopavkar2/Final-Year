import weka.core.Instances;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.ConfusionMatrix;
import weka.classifiers.bayes.NaiveBayes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Exception;

public class NaiveBayesClassification
{
    public NaiveBayesClassification()
    {
        try
        {
            BufferedReader trainReader = new BufferedReader(new FileReader("./training.arff"));
            BufferedReader testReader = new BufferedReader(new FileReader("./testing.arff"));
            
            //File with text to classify
            Instances trainInstance = new Instances(trainReader);
            Instances testInstance = new Instances(testReader);

            trainInstance.setClassIndex(trainInstance.numAttributes() - 1);
            testInstance.setClassIndex(testInstance.numAttributes() -1);
            
            NaiveBayes model = new NaiveBayes();
            model.buildClassifier(trainInstance);
            System.out.println(model);
            
            Evaluation evaluationTest = new Evaluation(testInstance);
            evaluationTest.evaluateModel(model, testInstance);
            
            String[] cmarray = {"normal","anomaly"};
            ConfusionMatrix cm = new ConfusionMatrix(cmarray);
            
            for (int i = 0; i < testInstance.numInstances(); i++)
            {
                testInstance.instance(i).setClassMissing();
                double cls = model.classifyInstance(testInstance.instance(i));
                testInstance.instance(i).setClassValue(cls);
            }
            
            System.out.println("Error Rate: " + evaluationTest.errorRate()*100);
            System.out.println("Pct Correct: " + evaluationTest.pctCorrect());
            
            for (int i=0; i<trainInstance.numClasses(); i++)
            {
                System.out.println("Class " + i);
                System.out.println("Precision " + evaluationTest.precision(i));
                System.out.println("Recall "+ evaluationTest.recall(i));
                System.out.println("Area under ROC "+ evaluationTest.areaUnderROC(i));
                System.out.println();
            }
        }
        catch (Exception o)
        {
            System.err.println(o.getMessage());
        }
    }

    public static void main(String[] args) {
        NaiveBayesClassification nb = new NaiveBayesClassification();
    }
}