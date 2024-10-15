package com.example.plugins

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import org.bson.Document

@Serializable
data class Article(
    val name: String,
    val lang: String
) {
    companion object {

        fun fromDocument(document: Document): Article = Article(
            name = document.getString("_id"),
            lang = document.getString("lang")
        )
    }
}

class ArticleService(database: MongoDatabase) {
    var collection: MongoCollection<Document>

    init {
        database.createCollection("pages")
        collection = database.getCollection("article")
    }

    suspend fun getById(id: String): Article? = withContext(Dispatchers.IO) {
        collection.find(Filters.eq("_id", id)).first()?.let(Article::fromDocument)
    }

    suspend fun list(): List<Article> = withContext(Dispatchers.IO) {
        collection.find().map(Article::fromDocument).toList()
    }

}


