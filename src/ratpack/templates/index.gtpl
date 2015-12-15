yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        meta(charset:'utf-8')
        title('Vampire Movies')

        meta(name: 'apple-mobile-web-app-title', content: 'Ratpack')
        meta(name: 'description', content: '')
        meta(name: 'viewport', content: 'width=device-width, initial-scale=1')

        link(href: '/images/favicon.ico', rel: 'shortcut icon')
        link(href: '/styles/bootstrap.min.css', rel: 'stylesheet')
        link(href: '/styles/bootstrap-theme.min.css', rel: 'stylesheet')
    }
    body {
        h1('Movies')
        table(class: "table table-striped table-bordered") {
            thead {
                tr {
                    th('Title')
                    th('Year')
                    th('MPAA Rating')
                    th('Critics Score')
                    th('Audience Score')
                    th('Synopsis')
                }
            }
            tbody {
                movies.each { movie ->
                    tr {
                        td(movie.title)
                        td(movie.year)
                        td(movie.mpaa_rating)
                        td(movie.ratings.critics_score)
                        td(movie.ratings.audience_score)
                        td(movie.synopsis)
                    }
                }
            }
        }
    }
}
