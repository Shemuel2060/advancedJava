package SEconcepts.objectsdesign;

    
import java.util.ArrayList;

public class Content {
    public Publisher source_;
    public ArrayList data_;

    public Content(Publisher src, ArrayList dat) {
        source_ = src;
        data_ = (ArrayList) dat.clone(); // for write safety...
    } // ...avoid aliasing and create a new copy
}

