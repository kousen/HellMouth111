package com.kousenit

import groovy.transform.ToString

/**
 * Created by Ken Kousen on 12/6/15.
 */
@ToString(includeNames = true)
class Ratings {
    String critics_rating
    Integer critics_score
    String audience_rating
    Integer audience_score
}
