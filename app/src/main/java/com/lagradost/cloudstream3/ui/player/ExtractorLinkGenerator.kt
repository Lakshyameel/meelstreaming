package com.lagradost.meelstream3.ui.player

import com.lagradost.meelstream3.utils.ExtractorLink
import com.lagradost.meelstream3.utils.ExtractorLinkType

class ExtractorLinkGenerator(
    private val links: List<ExtractorLink>,
    private val subtitles: List<SubtitleData>,
) : NoVideoGenerator() {
    override suspend fun generateLinks(
        clearCache: Boolean,
        sourceTypes: Set<ExtractorLinkType>,
        callback: (Pair<ExtractorLink?, ExtractorUri?>) -> Unit,
        subtitleCallback: (SubtitleData) -> Unit,
        offset: Int,
        isCasting: Boolean
    ): Boolean {
        subtitles.forEach(subtitleCallback)
        links.forEach {
            if(sourceTypes.contains(it.type)) {
                callback.invoke(it to null)
            }
        }

        return true
    }
}