package com.kousenit

import groovy.transform.ToString

@ToString(includeNames = true)
class CastMember {
    String name
    long id
    List<String> characters = []
}
