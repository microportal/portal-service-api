package br.org.portal.portalserviceapi.client;

import br.org.portal.portalserviceapi.model.ApplicationBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "portal-service", url = "${portal.server.listOfServers}")
public interface ApplicationsControllerClient {

    @GetMapping
    List<ApplicationBase> findAll();

    @GetMapping("/services")
    List<ApplicationBase> findServices();

    @GetMapping("/{applicationId}")
    ApplicationBase findById(@PathVariable("applicationId") String applicationId);

    @PostMapping
    Optional<ApplicationBase> registerApplication(@RequestBody ApplicationBase applicationDocument);

    @PutMapping("/{applicationId}")
    ApplicationBase updateApplication(@PathVariable("applicationId") String applicationId, @RequestBody ApplicationBase applicationDocument);

    @DeleteMapping("/{applicationId}")
    void unregister(@PathVariable("applicationId") String applicationId);
}
