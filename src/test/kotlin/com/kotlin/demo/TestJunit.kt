package com.kotlin.demo


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*;

import org.hamcrest.MatcherAssert.*;
import org.hamcrest.Matchers.*;
import org.hamcrest.core.*;


class TestJunit {

    @Test
    fun test() {
        val customer = Customer(name = "Tae").apply { age = 25 }

        assertEquals(customer.name, "Tae")
        assertThat(customer.name, `is`(equalTo("Tae")))

        assertNotNull(customer.name)
        assertThat(customer.name, `is`(notNullValue()))

        assertTrue(customer.name.indexOf("T") > -1)
        assertThat(customer.name, containsString("T"))

        assertTrue(customer.age > 0 )
        assertThat(customer.age, greaterThan(0))

    }

    class Customer(var name:String) {
        var age:Int = 0
    }
}

