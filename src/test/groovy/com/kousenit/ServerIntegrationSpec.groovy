package com.kousenit

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.test.ServerBackedApplicationUnderTest
import ratpack.test.http.TestHttpClient
import spock.lang.Specification

class ServerIntegrationSpec extends Specification {

    ServerBackedApplicationUnderTest aut = new GroovyRatpackMainApplicationUnderTest()
    @Delegate
    TestHttpClient client = testHttpClient(aut)

    def "GET(/) with no title returns all movies"() {
        when:
        get('/')

        then: 'table has one header row and 327 movie rows'
        response.body.text.findAll(/<tr>/).size() == 327
        response.statusCode == 200
    }

    def 'GET(/?title=...) returns all movies that include that title'() {
        when:
        get('/?title=Vampire')

        then:
        Document doc = Jsoup.parse(response.body.text)
        doc.select('tr > td:eq(0)').every {
            it.toString().toLowerCase().contains('vampir')
        }
        response.statusCode == 200
    }

    def "GET(/movie?title=...) returns that single movie"() {
        when:
        String encodedTitle =
                URLEncoder.encode('Interview with the Vampire', 'UTF-8')
        get("movie?title=$encodedTitle")

        then:
        response.body.text.contains 'Interview with the Vampire'
        response.body.text.contains '1994'
        response.statusCode == 200
    }

    def 'GET(/title/:title) returns all movies with that title'() {
        when:
        get("title/Vampire")

        then:
        Document doc = Jsoup.parse(response.body.text)
        doc.select('tr > td:eq(0)').every {
            it.toString().toLowerCase().contains('vampir')
        }
        response.statusCode == 200
    }

    def cleanup() {
        aut.stop()
    }
}
