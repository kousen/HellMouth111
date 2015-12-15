package com.kousenit

import groovy.transform.ToString

/**
 * Created by Ken Kousen on 12/6/15.
 */
@ToString(includeNames = true)
class Movie {
    int id
    String title
    String year
    MPAARating mpaa_rating
    String runtime
    Dates release_dates
    Ratings ratings
    String synopsis
    Posters posters
    CastMember[] abridged_cast
    MovieLinks links
}
