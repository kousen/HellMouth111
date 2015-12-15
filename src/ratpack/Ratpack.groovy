import com.kousenit.Movie
import com.kousenit.VampireServer
import ratpack.groovy.template.MarkupTemplateModule

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

VampireServer server = VampireServer.instance

ratpack {
    bindings {
        module MarkupTemplateModule
    }

    handlers {
        get {
            List<Movie> movies = server.findAllByTitle()
            render groovyMarkupTemplate("index.gtpl", movies: movies)
        }
        get('title/:title') {
            List<Movie> movies = server.findAllByTitle(pathTokens.title)
            render groovyMarkupTemplate("index.gtpl", movies: movies)
        }
        get('movie') {
            Movie movie = server.findByTitle(
                    URLDecoder.decode(request.queryParams.title, 'UTF-8'))
            render groovyMarkupTemplate('show.gtpl', movie: movie)
        }

        files { dir "public" }
    }
}
