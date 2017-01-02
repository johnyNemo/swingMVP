package com.swingmvp;

import com.swingmvp.config.Configuration;
import com.swingmvp.config.ViewConfiguration;
import com.swingmvp.config.XMLReader;
import com.swingmvp.dc.ServiceContainer;
import com.swingmvp.dc.ServiceContainerInterface;

/**
 *
 * @author marek
 */
public class Application {

    private ServiceContainerInterface _serviceContainer;

    private Configuration _config;

    public Application(Configuration config, ServiceContainerInterface serviceContainer) {
        _config = config;
        _serviceContainer = serviceContainer;
    }

    public void openWindow(String viewName) {
        ViewConfiguration vconf = _config.getViewConfiguration(viewName);

        java.awt.EventQueue.invokeLater(() -> {
            Presenter presenter = _serviceContainer.getService(vconf.getPresenter());
            View view = _serviceContainer.getService(vconf.getName());

            presenter.setView(view);
            view.setPresenter(presenter);

            view.show();
        });

    }

    public ServiceContainerInterface getServiceContainer() {
        return _serviceContainer;
    }

    public static Application init() {
        ServiceContainer sc = initServiceContainer();
        Configuration config = readConfig();

        Application app = new Application(config, sc);

        sc.registerService("smvp-application", (ServiceContainerInterface serviceContainer) -> {
            return app;
        }, true);

        return app;
    }

    private static ServiceContainer initServiceContainer() {
        return new ServiceContainer();
    }

    private static Configuration readConfig() {
        XMLReader configReader = new XMLReader();
        String fname = Application.class.getClassLoader().getResource("smvp.config.xml").getPath();
        return configReader.read(fname);
    }

}
