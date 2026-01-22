package com.jjtelechea.satejuexample.domain.mapper

interface Mapper<Input, Output> {
    fun map(input: Input): Output
}