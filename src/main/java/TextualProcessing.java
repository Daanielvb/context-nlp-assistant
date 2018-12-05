
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import java.util.Properties;

public class TextualProcessing {


    public static String text = "I’m going to Riomar cinema with Camila today. " +
            "I'm loving horror movies. " +
            "Buy me 2 tickets for Harry Potter at 5PM on RioMar cinema. " +
            "I want tickets for the Titanic next subtitled session. ";

    public static void main(String[] args) {
        // set up pipeline properties
        Properties props = new Properties();
        // set the list of annotators to run
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
        // build pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        // create a document object
        CoreDocument document = new CoreDocument(text);
        // annnotate the document
        pipeline.annotate(document);
        // examples

        for(CoreSentence sentence : document.sentences()){
            System.out.println("Example: pos tags");
            System.out.println(sentence.tokens());
            System.out.println(sentence.posTags());
            for(CoreLabel token : sentence.tokens()){
                System.out.println("Token: " + token + " Lemma: " + token.lemma());
            }
        }








    }
}
