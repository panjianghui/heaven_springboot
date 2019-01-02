package mongo.entity;

import com.mongodb.DBCursor;

public interface MongoDBCursorPreparer
{
	DBCursor prepare(DBCursor cursor);
}
