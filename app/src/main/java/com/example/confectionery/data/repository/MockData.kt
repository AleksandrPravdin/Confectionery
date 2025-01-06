package com.example.confectionery.data.repository

import com.example.confectionery.domain.model.CharacteristicsOfConfectionery
import com.example.confectionery.domain.model.CompositionOfConfectionery
import com.example.confectionery.domain.model.ConfectioneryAndItsManufacturer
import com.example.confectionery.domain.model.ConfectioneryType
import com.example.confectionery.domain.model.Consistency
import com.example.confectionery.domain.model.Form
import com.example.confectionery.domain.model.Manufacturer
import com.example.confectionery.domain.model.PartyConfectionery

fun getSamplePartyConfectioneries(): List<PartyConfectionery> {
    val consistency1 = Consistency(1, "Твёрдая")
    val consistency2 = Consistency(2, "Мягкая")

    val form1 = Form(1, "Круглая")
    val form2 = Form(2, "Прямоугольная")

    val characteristics1 = CharacteristicsOfConfectionery(1, consistency1, form1, "Средний")
    val characteristics2 = CharacteristicsOfConfectionery(2, consistency2, form2, "Большой")

    val composition1 = CompositionOfConfectionery(1, 10.5f, 5.0f, 20.0f, "Мука, сахар, масло")
    val composition2 = CompositionOfConfectionery(2, 8.0f, 3.5f, 15.0f, "Шоколад, молоко, орехи")

    val confectioneryType1 = ConfectioneryType(1, "Шоколадный батончик")
    val confectioneryType2 = ConfectioneryType(2, "Мармелад")

    val manufacturer1 = Manufacturer(1, "Сладкая фабрика", "г. Москва")
    val manufacturer2 = Manufacturer(2, "Желейные радости", "г. Санкт-Петербург")

    val confectioneryAndManufacturer1 =
        ConfectioneryAndItsManufacturer(1, manufacturer1, confectioneryType1)
    val confectioneryAndManufacturer2 =
        ConfectioneryAndItsManufacturer(2, manufacturer2, confectioneryType2)

    return listOf(
        PartyConfectionery(
            partyConfId = 101,
            characteristics = characteristics1,
            composition = composition1,
            confectioneryAndManufacturer = confectioneryAndManufacturer1,
            dateOfManufacture = "2024-11-20",
            count = 50
        ),
        PartyConfectionery(
            partyConfId = 102,
            characteristics = characteristics2,
            composition = composition2,
            confectioneryAndManufacturer = confectioneryAndManufacturer2,
            dateOfManufacture = "2024-11-21",
            count = 100
        ),
        PartyConfectionery(
            partyConfId = 103,
            characteristics = characteristics2,
            composition = composition2,
            confectioneryAndManufacturer = confectioneryAndManufacturer2,
            dateOfManufacture = "2024-11-21",
            count = 100
        ),
        PartyConfectionery(
            partyConfId = 104,
            characteristics = characteristics2,
            composition = composition2,
            confectioneryAndManufacturer = confectioneryAndManufacturer2,
            dateOfManufacture = "2024-11-21",
            count = 100
        ),
        PartyConfectionery(
            partyConfId = 105,
            characteristics = characteristics2,
            composition = composition2,
            confectioneryAndManufacturer = confectioneryAndManufacturer2,
            dateOfManufacture = "2024-11-21",
            count = 100
        ),
        PartyConfectionery(
            partyConfId = 106,
            characteristics = characteristics2,
            composition = composition2,
            confectioneryAndManufacturer = confectioneryAndManufacturer2,
            dateOfManufacture = "2024-11-21",
            count = 100
        ),
        PartyConfectionery(
            partyConfId = 107,
            characteristics = characteristics2,
            composition = composition2,
            confectioneryAndManufacturer = confectioneryAndManufacturer2,
            dateOfManufacture = "2024-11-21",
            count = 100
        ),
        PartyConfectionery(
            partyConfId = 108,
            characteristics = characteristics2,
            composition = composition2,
            confectioneryAndManufacturer = confectioneryAndManufacturer2,
            dateOfManufacture = "2024-11-21",
            count = 100
        ),
        PartyConfectionery(
            partyConfId = 109,
            characteristics = characteristics2,
            composition = composition2,
            confectioneryAndManufacturer = confectioneryAndManufacturer2,
            dateOfManufacture = "2024-11-21",
            count = 100
        )
    )
}