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
        h1('Vampire Movie')
        table(class: "table table-striped table-bordered") {
            tbody {
                tr {
                    th('Title')
                    td(movie.title)
                }
                tr {
                    th('Year')
                    td(movie.year)
                }
                tr {
                    th('MPAA Rating')
                    td(movie.mpaa_rating)
                }
                tr {
                    th('Critics Score')
                    td(movie.ratings.critics_score)
                }
                tr {
                    th('Audience Score')
                    td(movie.ratings.audience_score)
                }
                tr {
                    th('Synopsis')
                    td(movie.synopsis)
                }
            }
        }
    }
}
