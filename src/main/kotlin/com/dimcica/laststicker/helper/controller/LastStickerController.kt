package com.dimcica.laststicker.helper.controller

import com.dimcica.laststicker.helper.model.CollectionChecklist
import com.dimcica.laststicker.helper.repository.CollectionChecklistRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/laststicker")
class LastStickerController(
    val collectionChecklistRepository: CollectionChecklistRepository
) {
    @GetMapping(
        value = ["/checklist"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getChecklists(): Flux<CollectionChecklist> {
        return collectionChecklistRepository.findAll()
    }

    @PutMapping(
        value = ["/checklist"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun addCheckList(
        @RequestBody checklist: CollectionChecklist
    ) {
        collectionChecklistRepository.save(checklist).subscribe()
    }
}
