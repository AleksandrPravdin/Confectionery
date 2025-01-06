package com.example.confectionery.data.repository

//fun getSamplePartyConfectioneries(): List<PartyConfectionery> {
//    val consistency1 = Consistency(1, "Твёрдая")
//    val consistency2 = Consistency(2, "Мягкая")
//
//    val form1 = Form(1, "Круглая")
//    val form2 = Form(2, "Прямоугольная")
//
//    val characteristics1 = Characteristics(1, consistency1, form1, "Средний")
//    val characteristics2 = Characteristics(2, consistency2, form2, "Большой")
//
//    val composition1 = Composition(1, 10.5f, 5.0f, 20.0f, "Мука, сахар, масло")
//    val composition2 = Composition(2, 8.0f, 3.5f, 15.0f, "Шоколад, молоко, орехи")
//
//    val confectioneryType1 = Confectionery(1, "Шоколадный батончик")
//    val confectioneryType2 = Confectionery(2, "Мармелад")
//
//    val manufacturer1 = Manufacturer(1, "Сладкая фабрика", "г. Москва")
//    val manufacturer2 = Manufacturer(2, "Желейные радости", "г. Санкт-Петербург")
//
//    val confectioneryAndManufacturer1 =
//        ConfAndItsManuf(1, manufacturer1, confectioneryType1)
//    val confectioneryAndManufacturer2 =
//        ConfAndItsManuf(2, manufacturer2, confectioneryType2)
//
//    return listOf(
//        PartyConfectionery(
//            partyConfId = 101,
//            characteristicsId = characteristics1,
//            compositionId = composition1,
//            confAndItsManufId = confectioneryAndManufacturer1,
//            dateOfManufactureId = "2024-11-20",
//            count = 50
//        ),
//        PartyConfectionery(
//            partyConfId = 102,
//            characteristicsId = characteristics2,
//            compositionId = composition2,
//            confAndItsManufId = confectioneryAndManufacturer2,
//            dateOfManufactureId = "2024-11-21",
//            count = 100
//        ),
//        PartyConfectionery(
//            partyConfId = 103,
//            characteristicsId = characteristics2,
//            compositionId = composition2,
//            confAndItsManufId = confectioneryAndManufacturer2,
//            dateOfManufactureId = "2024-11-21",
//            count = 100
//        ),
//        PartyConfectionery(
//            partyConfId = 104,
//            characteristicsId = characteristics2,
//            compositionId = composition2,
//            confAndItsManufId = confectioneryAndManufacturer2,
//            dateOfManufactureId = "2024-11-21",
//            count = 100
//        ),
//        PartyConfectionery(
//            partyConfId = 105,
//            characteristicsId = characteristics2,
//            compositionId = composition2,
//            confAndItsManufId = confectioneryAndManufacturer2,
//            dateOfManufactureId = "2024-11-21",
//            count = 100
//        ),
//        PartyConfectionery(
//            partyConfId = 106,
//            characteristicsId = characteristics2,
//            compositionId = composition2,
//            confAndItsManufId = confectioneryAndManufacturer2,
//            dateOfManufactureId = "2024-11-21",
//            count = 100
//        ),
//        PartyConfectionery(
//            partyConfId = 107,
//            characteristicsId = characteristics2,
//            compositionId = composition2,
//            confAndItsManufId = confectioneryAndManufacturer2,
//            dateOfManufactureId = "2024-11-21",
//            count = 100
//        ),
//        PartyConfectionery(
//            partyConfId = 108,
//            characteristicsId = characteristics2,
//            compositionId = composition2,
//            confAndItsManufId = confectioneryAndManufacturer2,
//            dateOfManufactureId = "2024-11-21",
//            count = 100
//        ),
//        PartyConfectionery(
//            partyConfId = 109,
//            characteristicsId = characteristics2,
//            compositionId = composition2,
//            confAndItsManufId = confectioneryAndManufacturer2,
//            dateOfManufactureId = "2024-11-21",
//            count = 100
//        )
//    )
//}