package be.vdab.koers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.hateoas.server.TypedEntityLinks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("renners")
@ExposesResourceFor(Renner.class)
public class RennerController {
    private final RennerService rennerService;
    private final TypedEntityLinks.ExtendedTypedEntityLinks<Renner> links;

    public RennerController(RennerService rennerService, EntityLinks links) {
        this.rennerService = rennerService;
        this.links = links.forType(Renner.class, Renner::getId);
    }
    @GetMapping("{id}")
    EntityModel<Renner> findById(@PathVariable long id){
       return rennerService.findById(id)
               .map(renner -> EntityModel.of(renner)
                       .add(links.linkToItemResource(renner)))
               .orElseThrow(RennerNotFoundException::new);

    }
}
