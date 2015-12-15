package com.kousenit

import spock.lang.Shared
import spock.lang.Specification

class VampireServerSpec extends Specification {
    @Shared VampireServer server = VampireServer.instance

    def "find by title for 'Interview with the Vampire'"() {
        when:
        Movie m = server.findByTitle('Interview with the Vampire')

        then:
        m
        m.year == '1994'
        m.mpaa_rating == MPAARating.R
    }

    def "find all movies where title includes 'Vampire'"() {
        when:
        Collection movies = server.findAllByTitle('Vampire')

        then:
        movies.every { Movie m ->
            m.title.contains('Vampire')
        }
    }

    def 'correct total movies in db'() {
        expect:
        server.findAllByTitle().size() == 326
    }

    def 'getRandom returns single movie'() {
        when:
        Movie m = server.random

        then:
        m
    }
}
