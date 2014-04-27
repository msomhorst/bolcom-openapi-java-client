package com.bol.api.openapi

import spock.lang.Specification

import static com.bol.api.openapi.QueryDataTypes.DataType.*

class QueryDataTypesSpec extends Specification {
    def 'Add one type results in a single query value'() {
        given:
        def types = QueryDataTypes.builder()
                .add(PRODUCTS)
                .create()

        expect:
        types.toString() == 'products'
    }

    def 'Add two types results in a comma-separated query value with two values'() {
        given:
        def types = QueryDataTypes.builder()
                .add(PRODUCTS)
                .add(CATEGORIES)
                .create()

        expect:
        types.toString() == 'products,categories'
    }

    def 'Add three types results in a comma-separated query value with three values'() {
        given:
        def types = QueryDataTypes.builder()
                .add(PRODUCTS)
                .add(CATEGORIES)
                .add(REFINEMENTS)
                .create()

        expect:
        types.toString() == 'products,categories,refinements'
    }
}