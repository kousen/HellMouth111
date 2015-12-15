package com.kousenit

import groovy.transform.ToString

/**
 * Created by Ken Kousen on 12/6/15.
 */
@ToString(includeNames = true)
class MovieLinks {
    String self
    String alternate
    String cast
    String clips
    String reviews
    String similar
}
