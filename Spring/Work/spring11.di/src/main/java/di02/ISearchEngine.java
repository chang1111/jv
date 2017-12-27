package di02;

import java.util.List;

public interface ISearchEngine {
    List<Document> findByType(Type documentType);
    List<Document> listAll();
}
