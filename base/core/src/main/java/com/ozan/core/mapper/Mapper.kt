package com.ozan.core.mapper

@FunctionalInterface
interface Mapper<in T, out R> {

    suspend fun apply(item: T): R
}