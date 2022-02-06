import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WebPage {
    public List<String> dom; // this actually has the html document model.

    public WebPage(){
        dom = new LinkedList<String>();
    }

    public void addTitle(String title){
        dom.add("<h1>"+title+"</h1>");
    }

    public void addParagraph(String paragraph){
        dom.add("<p>"+paragraph+"</p>");
    }

    public String toString(){
        String html = "<html>\n<head>\n</head>\n<body>";
        for(String e:dom){
            html=html+e+"\n";
        }
        return html+"</body>\n</html>";
    }

    public void save(String filename){
        try(FileWriter out = new FileWriter(new File(filename))){
            out.write(this.toString());
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
