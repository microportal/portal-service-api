package br.org.portal.portalserviceapi.listener;

import br.org.portal.portalserviceapi.client.ApplicationsControllerClient;
import br.org.portal.portalserviceapi.config.ApplicationClientProperies;
import br.org.portal.portalserviceapi.model.ApplicationBase;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Optional;

@Slf4j
@Setter(onMethod = @__({@Autowired}))
public class ApplicationEventListener {

    private ApplicationsControllerClient client;

    private ApplicationClientProperies applicationClientProperies;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("Registering Application");
        log.debug(event.toString());

        ApplicationBase application = new ApplicationBase();
        application.setName(applicationClientProperies.getName());
        application.setPath(applicationClientProperies.getPath());
        application.setImageUrl(applicationClientProperies.getImageUrl());
        application.setIndexUrl(applicationClientProperies.getIndexUrl());
        application.setStoreUrl(applicationClientProperies.getStoreUrl());
        application.setService(applicationClientProperies.getService());

        Optional<ApplicationBase> savedApplication = client.registerApplication(application);
        log.info("Registered application");
        log.info(savedApplication.toString());
    }
}
