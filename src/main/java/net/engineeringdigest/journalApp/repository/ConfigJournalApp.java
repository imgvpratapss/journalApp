package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.config.JournalConfig;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ConfigJournalApp extends MongoRepository<JournalConfig, ObjectId> {

}
