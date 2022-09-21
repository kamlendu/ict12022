package entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-06T12:27:35", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(BookMaster.class)
public class BookMaster_ { 

    public static volatile SingularAttribute<BookMaster, String> authorName;
    public static volatile SingularAttribute<BookMaster, String> publisherName;
    public static volatile SingularAttribute<BookMaster, String> synopsis;
    public static volatile SingularAttribute<BookMaster, String> bookName;
    public static volatile SingularAttribute<BookMaster, Integer> bookID;

}