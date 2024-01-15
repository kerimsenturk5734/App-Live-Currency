package com.example.applivecurrency.ui.util


enum class CurrencySymbol(val value: String?){
    AED("AED"), ARS("ARS"), AUD("AUD"), BGN("BGN"), BHD("BHD"),
    BND("BND"), BRL("BRL"), BWP("BWP"), VES("VES"), ZAR("ZAR"),
    CAD("CAD"), CHF("CHF"), CLP("CLP"), CNY("CNY"), COP("COP"),
    CZK("CZK"), DKK("DKK"), EUR("EUR"), SGD("SGD"), THB("THB"),
    GBP("GBP"), HKD("HKD"), HUF("HUF"), IDR("IDR"), ILS("ILS"),
    INR("INR"), IRR("IRR"), ISK("ISK"), TWD("TWD"), USD("USD"),
    JPY("KWD"), KRW("KWD"), KWD("KWD"), KZT("KZT"), LKR("LKR"),
    LYD("LYD"), MUR("MUR"), MXN("MXN"), MYR("MYR"), NOK("NOK"),
    NPR("NPR"), NZD("NZD"), OMR("OMR"), TTD("TTD"), SEK("SEK"),
    PHP("PHP"), PKR("PKR"), PLN("PLN"), QAR("QAR"), RON("RON"),
    RUB("RUB"), SAR("SAR"),
}

val CurrencyIcon = mapOf<String, String>(
    CurrencySymbol.AED.name to "https://cdn-icons-png.flaticon.com/512/323/323301.png",
    CurrencySymbol.ARS.name to "https://cdn-icons-png.flaticon.com/512/9906/9906442.png",
    CurrencySymbol.AUD.name to "https://cdn-icons-png.flaticon.com/512/12364/12364253.png",
    CurrencySymbol.BGN.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.BHD.name to "https://cdn-icons-png.flaticon.com/512/11849/11849478.png",
    CurrencySymbol.BND.name to "https://cdn-icons-png.flaticon.com/512/197/197530.png",
    CurrencySymbol.BRL.name to "https://cdn-icons-png.flaticon.com/512/3909/3909370.png",
    CurrencySymbol.BWP.name to "https://cdn-icons-png.flaticon.com/512/197/197510.png",
    CurrencySymbol.CAD.name to "https://cdn-icons-png.flaticon.com/512/197/197430.png",
    CurrencySymbol.CHF.name to "https://cdn-icons-png.flaticon.com/512/197/197540.png",
    CurrencySymbol.CLP.name to "https://cdn-icons-png.flaticon.com/512/5372/5372687.png",
    CurrencySymbol.CNY.name to "https://cdn-icons-png.flaticon.com/512/197/197375.png",
    CurrencySymbol.COP.name to "https://cdn-icons-png.flaticon.com/512/197/197575.png",
    CurrencySymbol.CZK.name to "https://cdn-icons-png.flaticon.com/512/197/197576.png",
    CurrencySymbol.DKK.name to "https://cdn-icons-png.flaticon.com/512/197/197565.png",
    CurrencySymbol.EUR.name to "https://cdn-icons-png.flaticon.com/512/2756/2756443.png",
    CurrencySymbol.GBP.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.HKD.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.HUF.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.IDR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.ILS.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.INR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.IRR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.ISK.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.JPY.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.KRW.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.KWD.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.KZT.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.LKR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.LYD.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.MUR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.MXN.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.MYR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.NOK.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.NPR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.NZD.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.OMR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.PHP.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.PKR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.LYD.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.PLN.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.QAR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.RON.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.RUB.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.SAR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.SEK.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.SGD.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.THB.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.TTD.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.TWD.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.USD.name to "https://cdn-icons-png.flaticon.com/512/3444/3444339.png",
    CurrencySymbol.VES.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
    CurrencySymbol.ZAR.name to "https://cdn-icons-png.flaticon.com/512/11948/11948471.png",
)