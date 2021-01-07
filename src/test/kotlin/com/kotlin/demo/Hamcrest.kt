package com.kotlin.demo

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNotSame
import kotlin.test.assertTrue

class Hamcrest {

    @Test
    @DisplayName("Hamcrest Testing")
    fun test() {
        assertThat(Any(), `is`(notNullValue()))
    }

    @Test
    @DisplayName("hamcrest Method")
    fun hamcrest() {
        val aList = listOf(2, 5, 7)
        val bList = listOf(2, 5, 7)
        val map = mapOf("key" to "value", "key2" to "value2")
        val person = Person("Kim","chi")

        assertNotNull(Any())
        assertEquals(aList, bList)
        assertNotSame(aList, bList)
        assertEquals(aList.size, 3)
        assertTrue(aList.contains(2))
        assertTrue(aList.contains(5))
        assertTrue(aList.contains(7))
        assertTrue(map.containsKey("key"))
        assertAll(
            { assertEquals(aList[0], 2) },
            { assertEquals(aList[1], 5) }
        )


        assertThat(Any(), not(nullValue()));
        assertThat(aList, `is`(bList))
        assertThat(aList, not(sameInstance(bList)))
        assertThat(aList, hasSize(3))
        assertThat(aList, contains(2,5,7))
        assertThat(aList, containsInAnyOrder(7,5,2))
        assertThat(aList, hasItem(2))
        assertThat(map, hasKey("key"))
        assertThat(map, hasEntry("key", "value"))
        assertThat(person, allOf( //anyOf
            hasProperty("firstName", `is`("Kim")),
            hasProperty("lastName", `is`("chi")),
        ))



    }
    class Person(var firstName:String, var lastName:String)
}