
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.*;
import util.FileUtils;

import java.io.File;
import java.util.Properties;

public class TextualProcessing {

    //List of POS-TAGs https://stackoverflow.com/questions/1833252/java-stanford-nlp-part-of-speech-labels


    private static Boolean isQuestion(CoreSentence sentence){
        if(sentence.posTags().get(0).equals("WP") || sentence.posTags().get(0).equals("WDT") || sentence.posTags().get(0).equals("WRB")){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        ClassLoader classLoader = TextualProcessing.class.getClassLoader();
        File file = new File(classLoader.getResource("input-phrases.txt").getFile());
        String input = FileUtils.extractFileContent(file);

        // set up pipeline properties
        Properties props = new Properties();
        // set the list of annotators to run
        props.setProperty("annotators","tokenize,ssplit,pos,lemma,ner,parse,sentiment");
        // build pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        // create a document object
        CoreDocument document = new CoreDocument(input);
        // annnotate the document
        pipeline.annotate(document);
        // examples

        for(CoreSentence sentence : document.sentences()){
            System.out.println(sentence.posTags());
            if(isQuestion(sentence)){
                System.out.println(sentence);
            }
        }








    }
}
