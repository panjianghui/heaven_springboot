package mongo.internal;

import org.bson.Document;

public interface UpdateCallback
{
	Document doCallback(Document valueDBObject);
}
