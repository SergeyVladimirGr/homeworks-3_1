package ru.netology

import kotlin.random.Random

const val SIXTY = 60

fun main() {
    val timeHasPassed = Random.nextInt(0,260_000)

    val lastOnline = agoToText(timeHasPassed)

    println(lastOnline)
}

fun agoToText(timeHasPassed: Int): String {
    return when (true) {
        just(timeHasPassed) -> "был(а) только что"
        hour(timeHasPassed) -> minutesAgo(timeHasPassed)
        upToADay(timeHasPassed) -> hourAgo(timeHasPassed)
        upToTwoDays(timeHasPassed) -> "был(а) сегодня"
        upToThreeDays(timeHasPassed) -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun just(timeHasPassed: Int) = timeHasPassed in 0..60
fun hour(timeHasPassed: Int) = timeHasPassed in 61..3600
fun upToADay(timeHasPassed: Int) = timeHasPassed in 3601..86_400
fun upToTwoDays(timeHasPassed: Int) = timeHasPassed in 86_401..172_800
fun upToThreeDays(timeHasPassed: Int) = timeHasPassed in 172_801..259_200

fun minutesAgo(timeHasPassed: Int): String {
    val secondsToMinutes = timeHasPassed / SIXTY
    return when (secondsToMinutes) {
        1, 21, 31, 41, 51 -> "был(а) $secondsToMinutes минуту назад"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "был(а) $secondsToMinutes минуты назад"
        else -> "был(а) $secondsToMinutes минут назад"
    }
}

fun hourAgo(timeHasPassed: Int): String {
    val secondsToHours = timeHasPassed / SIXTY / SIXTY
    return when (secondsToHours) {
        1, 21 -> "был(а) в сети $secondsToHours час назад"
        2, 3, 4, 22, 23, 24 -> "был(а) в сети $secondsToHours часа назад"
        else -> "был(а) в сети $secondsToHours часов назад"
    }
}