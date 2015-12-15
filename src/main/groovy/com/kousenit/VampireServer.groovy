package com.kousenit

import com.gmongo.GMongo
import com.google.gson.Gson
import com.mongodb.DB

@Singleton
class VampireServer {
    Gson gson = new Gson()
    GMongo mongo = new GMongo()
    DB db = mongo.getDB('movies')

    List<Movie> findAllByTitle(String title) {
        def cursor = null
        if (title) {
            cursor = db.vampireMovies.find(title: ~/.*${title}.*/)
        } else {
            cursor = db.vampireMovies.find()
        }
        cursor?.collect {
            gson.fromJson(it.toString(), Movie)
        }
    }

    Movie findByTitle(String title) {
        gson.fromJson(db.vampireMovies.findOne(title: title).toString(), Movie)
    }

    Movie getRandom() {
        List movies = db.vampireMovies.find().collect {
            gson.fromJson(it.toString(), Movie)
        }
        Collections.shuffle(movies)
        movies[0]
    }
}