package com.android.pacenow.model

data class CountryData(
    val country: List<Country>
) {
    data class Country(
        val available_regions: List<AvailableRegion>,
        val full_name_english: String,
        val full_name_locale: String,
        val id: String,
        val three_letter_abbreviation: String,
        val two_letter_abbreviation: String
    ) {
        data class AvailableRegion(
            val code: String,
            val id: String,
            val name: String
        )
    }
}