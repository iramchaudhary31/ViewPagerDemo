package com.example.viewpagerdemo.pojo


import com.google.gson.annotations.SerializedName

data class FirstModel(
    @SerializedName("message")
    var message: Message
) {
    data class Message(
        @SerializedName("body")
        var body: Body,
        @SerializedName("header")
        var header: Header
    ) {
        data class Body(
            @SerializedName("artist_list")
            var artistList: ArrayList<Artist>
        ) {
            data class Artist(
                @SerializedName("artist")
                var artist: Artist
            ) {
                data class Artist(
                    @SerializedName("artist_alias_list")
                    var artistAliasList: List<ArtistAlias>,
                    @SerializedName("artist_comment")
                    var artistComment: String,
                    @SerializedName("artist_country")
                    var artistCountry: String,
                    @SerializedName("artist_credits")
                    var artistCredits: ArtistCredits,
                    @SerializedName("artist_id")
                    var artistId: Int,
                    @SerializedName("artist_name")
                    var artistName: String,
                    @SerializedName("artist_name_translation_list")
                    var artistNameTranslationList: List<ArtistNameTranslation>,
                    @SerializedName("artist_rating")
                    var artistRating: Int,
                    @SerializedName("artist_twitter_url")
                    var artistTwitterUrl: String,
                    @SerializedName("restricted")
                    var restricted: Int,
                    @SerializedName("updated_time")
                    var updatedTime: String
                ) {
                    data class ArtistAlias(
                        @SerializedName("artist_alias")
                        var artistAlias: String
                    )

                    data class ArtistCredits(
                        @SerializedName("artist_list")
                        var artistList: List<Any>
                    )

                    data class ArtistNameTranslation(
                        @SerializedName("artist_name_translation")
                        var artistNameTranslation: ArtistNameTranslation
                    ) {
                        data class ArtistNameTranslation(
                            @SerializedName("language")
                            var language: String,
                            @SerializedName("translation")
                            var translation: String
                        )
                    }
                }
            }
        }

        data class Header(
            @SerializedName("execute_time")
            var executeTime: Double,
            @SerializedName("status_code")
            var statusCode: Int
        )
    }
}